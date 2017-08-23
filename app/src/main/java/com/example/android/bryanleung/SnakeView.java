package com.example.android.bryanleung;

/**
 * Created by byn on 7/27/2017.
 */

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.media.SoundPool;
import android.graphics.Point;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import java.util.Random;

class SnakeView extends SurfaceView implements Runnable {
    //update the game 12 times per second
    private final long FPS = 10;
    //1000 milliseconds per second
    private final long MILLIS_IN_A_SECOND = 1000;
    //size in segments of the playable area
    private final int NUM_BLOCKS_WIDE = 35;
    //code will run separately to the UI
    private Thread m_Thread = null;
    //this variable determines when the game is playing
    //it is declared as volatile because
    //it can be accessed from inside and outside the thread
    private volatile boolean m_Playing;
    //what we draw on
    private Canvas m_Canvas;
    //this is required by the Canvas class to do the drawing
    private SurfaceHolder m_Holder;
    //gives access to colors
    private Paint m_Paint;
    //this will be a reference to the Activity
    private Context m_context;
    //sound but I don't use it
    private SoundPool m_SoundPool;
    private int m_get_mouse_sound = -1;
    private int m_dead_sound = -1;
    //begin by heading to the right
    private Direction m_Direction = Direction.RIGHT;
    //the screen resolution
    private int m_ScreenWidth;
    private int m_ScreenHeight;
    //control pausing between updates
    private long m_NextFrameTime;
    //draw the frame much more often
    //current m_Score
    private int m_Score;

    //location in the grid of all the segments
    private int[] m_SnakeXs;
    private int[] m_SnakeYs;

    //length of the snake
    private int m_SnakeLength;

    //mouse location
    private int m_MouseX;
    private int m_MouseY;

    //size in pixels of a snake segment
    private int m_BlockSize;
    private int m_NumBlocksHigh; // determined dynamically

    public SnakeView(Context context, Point size) {
        super(context);

        m_context = context;

        m_ScreenWidth = size.x;
        m_ScreenHeight = size.y;

        //determines the size of each block/place on the game board
        m_BlockSize = m_ScreenWidth / NUM_BLOCKS_WIDE;
        //how many blocks of the same size will fit into the height
        m_NumBlocksHigh = m_ScreenHeight / m_BlockSize;

        //set the sound up
        //loadSound();

        //initialize the drawing objects
        m_Holder = getHolder();
        m_Paint = new Paint();

        //if you score this number you are rewarded with anapp crash
        m_SnakeXs = new int[69];
        m_SnakeYs = new int[69];

        //start the game
        startGame();
    }

    @Override
    public void run() {
        //check for m_Playing and prevents a crash at the start
        //could also extend the code to make a pause feature
        while (m_Playing) {

            //update variable # of times a second
            if (checkForUpdate()) {
                updateGame();
                drawGame();
            }

        }
    }

    public void pause() {
        m_Playing = false;
        try {
            m_Thread.join();
        } catch (InterruptedException e) {
            //error
        }
    }

    public void resume() {
        m_Playing = true;
        m_Thread = new Thread(this);
        m_Thread.start();
    }

    public void startGame() {
        //start with just a head, in the middle of the screen
        m_SnakeLength = 1;
        m_SnakeXs[0] = NUM_BLOCKS_WIDE / 2;
        m_SnakeYs[0] = m_NumBlocksHigh / 2;

        //spawn the food
        spawnMouse();

        //reset the m_Score at start game
        m_Score = 0;

        //setup m_NextFrameTime so an update is triggered immediately
        m_NextFrameTime = System.currentTimeMillis();
    }

    public void spawnMouse() {
        Random random = new Random();
        m_MouseX = random.nextInt(NUM_BLOCKS_WIDE - 1) + 1;
        m_MouseY = random.nextInt(m_NumBlocksHigh - 1) + 1;
    }

    /*
    public void loadSound() {
        m_SoundPool = new SoundPool(10, AudioManager.STREAM_MUSIC, 0);
        try {
            // Create objects of the 2 required classes
            // Use m_Context because this is a reference to the Activity
            AssetManager assetManager = m_context.getAssets();
            AssetFileDescriptor descriptor;

            // Prepare the two sounds in memory
            descriptor = assetManager.openFd("get_mouse_sound.ogg");
            m_get_mouse_sound = m_SoundPool.load(descriptor, 0);

            descriptor = assetManager.openFd("death_sound.ogg");
            m_dead_sound = m_SoundPool.load(descriptor, 0);

        } catch (IOException e) {
            // Error
        }
    }
    */

    private void eatMouse() {
        //increase the size of the snake
        m_SnakeLength++;
        //replace the mouse
        spawnMouse();
        //add to the m_Score
        m_Score = m_Score + 1;
        //m_SoundPool.play(m_get_mouse_sound, 1, 1, 0, 0, 1);
    }

    private void moveSnake() {
        //move the body
        for (int i = m_SnakeLength; i > 0; i--) {
            //start at the back and move it to the position in front of it
            m_SnakeXs[i] = m_SnakeXs[i - 1];
            m_SnakeYs[i] = m_SnakeYs[i - 1];

            //excludes the head because the head has nothing in front of it
        }

        //move the head in the appropriate m_Direction
        switch (m_Direction) {
            case UP:
                m_SnakeYs[0]--;
                break;

            case RIGHT:
                m_SnakeXs[0]++;
                break;

            case DOWN:
                m_SnakeYs[0]++;
                break;

            case LEFT:
                m_SnakeXs[0]--;
                break;
        }
    }

    private boolean detectDeath() {
        //has the snake died?
        boolean dead = false;

        // Hit a wall?
        if (m_SnakeXs[0] == -1) dead = true;
        if (m_SnakeXs[0] >= NUM_BLOCKS_WIDE) dead = true;
        if (m_SnakeYs[0] == -1) dead = true;
        if (m_SnakeYs[0] == m_NumBlocksHigh) dead = true;

        //eaten itself?
        for (int i = m_SnakeLength - 1; i > 0; i--) {
            if ((i > 4) && (m_SnakeXs[0] == m_SnakeXs[i]) && (m_SnakeYs[0] == m_SnakeYs[i])) {
                dead = true;
            }
        }

        return dead;
    }

    public void updateGame() {
        //did the head of the snake touch the mouse?
        if (m_SnakeXs[0] == m_MouseX && m_SnakeYs[0] == m_MouseY) {
            eatMouse();
        }

        moveSnake();

        if (detectDeath()) {
            //start again
            //m_SoundPool.play(m_dead_sound, 1, 1, 0, 0, 1);
            startGame();
        }
    }

    public void drawGame() {
        //prepare to draw
        if (m_Holder.getSurface().isValid()) {
            m_Canvas = m_Holder.lockCanvas();

            //clear the screen with a blue background
            m_Canvas.drawColor(Color.argb(255,0 ,0 ,205 ));

            //set the color of the paint to draw the snake and mouse with, white
            m_Paint.setColor(Color.argb(255, 255, 255, 255));

            //choose how big the score will be
            m_Paint.setTextSize(50);
            m_Canvas.drawText("Score:" + m_Score, 20, 50, m_Paint);

            //draw the snake
            for (int i = 0; i < m_SnakeLength; i++) {
                m_Canvas.drawRect(m_SnakeXs[i] * m_BlockSize,
                        (m_SnakeYs[i] * m_BlockSize),
                        (m_SnakeXs[i] * m_BlockSize) + m_BlockSize,
                        (m_SnakeYs[i] * m_BlockSize) + m_BlockSize,
                        m_Paint);
            }

            //draw the mouse
            m_Canvas.drawRect(m_MouseX * m_BlockSize,
                    (m_MouseY * m_BlockSize),
                    (m_MouseX * m_BlockSize) + m_BlockSize,
                    (m_MouseY * m_BlockSize) + m_BlockSize,
                    m_Paint);

            // Draw the whole frame
            m_Holder.unlockCanvasAndPost(m_Canvas);
        }
    }

    public boolean checkForUpdate() {

        //are we due to update the frame
        if (m_NextFrameTime <= System.currentTimeMillis()) {
            //tenth of a second has passed

            //setup when the next update will be triggered
            m_NextFrameTime = System.currentTimeMillis() + MILLIS_IN_A_SECOND / FPS;

            //return true so that the update and draw functions are executed
            return true;
        }

        return false;
    }


    //handles the swiping up down left right motions
    float prevX, prevY;

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                prevX = event.getX();
                prevY = event.getY();

                return true;
            case MotionEvent.ACTION_UP:
                float newX = event.getX();
                float newY = event.getY();
                //Calculates where we swiped

                if (Math.abs(newX - prevX) > Math.abs(newY - prevY)) {
                    //LEFT - RiGHT Direction

                    if (newX > prevX) {
                        //RIGHT
                        m_Direction = Direction.RIGHT;
                    } else {
                        //LEFT
                        m_Direction = Direction.LEFT;
                    }
                } else {
                    // UP-DOWN Direction
                    if (newY > prevY) {
                        //DOWN
                        m_Direction = Direction.DOWN;
                    } else {
                        //UP
                        m_Direction = Direction.UP;
                    }
                }

                break;
        }
        return false;
    }

    //for tracking movement m_Direction
    private enum Direction {
        UP, RIGHT, DOWN, LEFT
    }

}
