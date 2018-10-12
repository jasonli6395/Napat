package c.jasonli6395.napatgame.GameObjects.UserObjects;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;

import c.jasonli6395.napatgame.Constants;
import c.jasonli6395.napatgame.GameObjects.UserObjects.UserObjects;

public class Triangle implements UserObjects {
    private Paint paint;
    private boolean placed;
    private int x, y;
    public Triangle(){
        placed = false;
        paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.GREEN);
        x = Constants.SCREEN_WIDRTH/2 - Constants.USEROBJECT_WIDTH/16;
        y = Constants.SCREEN_HEIGHT- 100;
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
    public boolean CheckCollision(int x, int y, int radius) {
        return false;
    }

    @Override
    public void draw(Canvas canvas) {

        int x1 = x - Constants.USEROBJECT_WIDTH / 2;
        int x2 =  x + Constants.USEROBJECT_WIDTH / 2;
        int y1 =y - Constants.USEROBJECT_WIDTH / 2;
        int y2 = y + Constants.USEROBJECT_WIDTH / 2;
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
