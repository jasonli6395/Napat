package c.jasonli6395.napatgame.GameObjects.UserObjects;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

import c.jasonli6395.napatgame.Constants;
import c.jasonli6395.napatgame.GameObjects.UserObjects.UserObjects;

public class Square implements UserObjects {

    private Paint paint;
    private boolean placed;
    private Rect rectangle;
    private int x, y;
    private int xVel = 10, yVel = 5;

    public Square() {
        rectangle = new Rect();
        placed = false;
        paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.BLUE);
        x = Constants.SCREEN_WIDRTH/2 - Constants.USEROBJECT_WIDTH/16;
        y = Constants.SCREEN_HEIGHT - 100;
        rectangle.set(x - Constants.USEROBJECT_WIDTH / 2, y - Constants.USEROBJECT_WIDTH/ 2, x + Constants.USEROBJECT_WIDTH / 2, y + Constants.USEROBJECT_WIDTH / 2);
    }
    @Override
    public void place() {
        placed = true;
    }
    @Override
    public void draw(Canvas canvas) {
        canvas.drawRect(rectangle, paint);
    }
    @Override
    public void update() {
        rectangle.set(x -  Constants.USEROBJECT_WIDTH/ 2, y -  Constants.USEROBJECT_WIDTH / 2, x +  Constants.USEROBJECT_WIDTH / 2, y +  Constants.USEROBJECT_WIDTH / 2);
    }
    @Override
    public void set(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
