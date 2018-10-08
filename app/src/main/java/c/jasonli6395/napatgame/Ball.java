package c.jasonli6395.napatgame;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;

public class Ball {

    private int radius;
    private Paint paint;
    private int x, y;
    private int xVel = 10, yVel = 5;
    private int screenWidth = Resources.getSystem().getDisplayMetrics().widthPixels;
    private int screenHeight = Resources.getSystem().getDisplayMetrics().heightPixels;

    public Ball() {
        paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.RED);
        radius = 25;
        x = 100;
        y = 100;
    }

    public void draw(Canvas canvas) {
        canvas.drawCircle(x, y, radius, paint);
    }

    public void update() {
        if (x < 0 && y < 0) {
            x = screenWidth / 2;
            y = screenHeight / 2;
        } else {
            x += xVel;
            y += yVel;
            if (x > screenWidth - radius * 2 || x < 0) {
                Log.d("X",Integer.toString(x));
                xVel = xVel * -1;
            }
            if (y > screenHeight - radius * 2 || y < 0) {
                Log.d("Y",Integer.toString(y));
                yVel = yVel * -1;
            }
        }
    }
}
