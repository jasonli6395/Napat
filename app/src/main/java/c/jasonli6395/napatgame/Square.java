package c.jasonli6395.napatgame;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

public class Square implements UserObjects {

    private Paint paint;
    private boolean placed;
    private Rect rectangle;
    private int x, y;
    private int xVel = 10, yVel = 5;
    private int screenWidth = Resources.getSystem().getDisplayMetrics().widthPixels;
    private int screenHeight = Resources.getSystem().getDisplayMetrics().heightPixels;
    private int width = 150;

    public Square() {
        rectangle = new Rect();
        placed = false;
        paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.BLUE);
        x = screenWidth/2 - width/16;
        y = screenHeight - 100;
        rectangle.set(x - width / 2, y - width/ 2, x + width / 2, y + width / 2);
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
        rectangle.set(x - rectangle.width() / 2, y - rectangle.width() / 2, x + rectangle.width() / 2, y + rectangle.width() / 2);

    }

    @Override
    public void set(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
