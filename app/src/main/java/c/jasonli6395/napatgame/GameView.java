package c.jasonli6395.napatgame;

import android.content.Context;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.SurfaceHolder;

import java.util.ArrayList;
import java.util.List;

import c.jasonli6395.napatgame.GameObjects.Ball;
import c.jasonli6395.napatgame.GameObjects.GameObject;
import c.jasonli6395.napatgame.GameObjects.UserObjects.UserObjectHandler;
import c.jasonli6395.napatgame.GameObjects.UserObjects.UserObjects;

public class GameView extends SurfaceView implements SurfaceHolder.Callback {
    private MainThread thread;
    private c.jasonli6395.napatgame.GameObjects.Ball Ball;
    private UserObjectHandler userObjectHandler;
    private UserObjects currentObject;
    private UserObjects nextObject;
    private List<GameObject> placedObjects;

    public GameView(Context context) {
        super(context);
        placedObjects = new ArrayList<GameObject>();
        userObjectHandler = new UserObjectHandler();
        getHolder().addCallback(this);
        thread = new MainThread(getHolder(), this);
        setFocusable(true);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
            case MotionEvent.ACTION_MOVE:
                currentObject.set((int)event.getX(),(int)event.getY());
                break;
            case MotionEvent.ACTION_UP:
                userObjectHandler.generateNextObject();
                currentObject.place();
                placedObjects.add(currentObject);
                currentObject = userObjectHandler.ObjectList.remove();
                currentObject.set( Constants.INITIAL_CURRENT_X,Constants.INITIAL_CURRENT_Y);
                nextObject = userObjectHandler.ObjectList.peek();
                nextObject.set(Constants.INITIAL_NEXT_X,Constants.INITIAL_NEXT_Y);

                break;
        }
        return true;
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {

        Ball = new Ball();
        currentObject = userObjectHandler.ObjectList.remove();
        userObjectHandler.generateNextObject();
        nextObject = userObjectHandler.ObjectList.peek();
        nextObject.set(Constants.INITIAL_NEXT_X,Constants.INITIAL_NEXT_Y);
        thread.setRunning(true);
        thread.start();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        boolean retry = true;
        while (retry) {
            try {
                thread.setRunning(false);
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            retry = false;
        }
    }

    public void update() {
        Ball.update();
        if(currentObject!=null){
            currentObject.update();
        }
        if(nextObject!=null){
            nextObject.update();
        }
        for (int i = 0; i<placedObjects.size();i++) {
            placedObjects.get(i).update();
        }
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (canvas != null) {
            Ball.draw(canvas);
            if(currentObject!=null){
                currentObject.draw(canvas);
            }
            if(nextObject!=null){
                nextObject.draw(canvas);
            }
            for (int i = 0; i<placedObjects.size();i++) {
                placedObjects.get(i).draw(canvas);
            }
        }
    }
}
