package c.jasonli6395.napatgame;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.SurfaceHolder;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class GameView extends SurfaceView implements SurfaceHolder.Callback {
    private MainThread thread;
    private Ball Ball;
    private UserObjectHandler userObjectHandler;
    private UserObjects currentObject;
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

                break;
        }
        return true;
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {

        Ball = new Ball();
        currentObject = userObjectHandler.ObjectList.remove();
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
            for (int i = 0; i<placedObjects.size();i++) {
                placedObjects.get(i).draw(canvas);
            }
        }
    }
}
