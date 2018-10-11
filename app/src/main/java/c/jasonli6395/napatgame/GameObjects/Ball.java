package c.jasonli6395.napatgame.GameObjects;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import c.jasonli6395.napatgame.Constants;

public class Ball implements GameObject {

    private int radius;
    private Paint paint;
    private int x, y;
    private int xVel = 10, yVel = 5;

    public Ball() {
        paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.RED);
        radius = Constants.BALL_RADIUS;
        x = 100;
        y = 100;
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.drawCircle(x, y, radius, paint);
    }
    @Override
    public void update() {
        if (x < 0 && y < 0) {
            x = Constants.SCREEN_WIDRTH/ 2;
            y = Constants.SCREEN_HEIGHT / 2;
        } else {
            x += xVel;
            y += yVel;
            if (x > Constants.SCREEN_WIDRTH - radius* 2 || x < 0) {
                xVel = xVel * -1;
            }
            if (y > Constants.SCREEN_HEIGHT - radius * 2 || y < 0) {
                yVel = yVel * -1;
            }
        }
    }
}
