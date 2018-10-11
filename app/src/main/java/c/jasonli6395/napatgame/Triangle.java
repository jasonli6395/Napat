package c.jasonli6395.napatgame;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;

public class Triangle implements UserObjects {
    private Paint paint;
    private boolean placed;
    private int x, y;
    private int xVel = 10, yVel = 5;
    private int screenWidth = Resources.getSystem().getDisplayMetrics().widthPixels;
    private int screenHeight = Resources.getSystem().getDisplayMetrics().heightPixels;
    private int width = 150;
    public Triangle(){
        placed = false;
        paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.GREEN);
        x = screenWidth/2 - width/16;
        y = screenHeight - 100;
    }

    @Override
    public void set(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void place() {
        placed = true;
    }

    @Override
    public void draw(Canvas canvas) {

        int x1 = x - width / 2;
        int x2 =  x + width / 2;
        int y1 =y - width / 2;
        int y2 = y + width / 2;
        Path path = new Path();
        path.setFillType(Path.FillType.EVEN_ODD);
        path.moveTo(x2, y2);
        path.lineTo(x1, y2);
        path.lineTo(x2, y1);
        path.lineTo(x2, y2);
        path.close();
        canvas.drawPath(path,paint);
    }

    @Override
    public void update() {

    }
}
