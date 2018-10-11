package c.jasonli6395.napatgame;

import android.content.res.Resources;

import java.net.FileNameMap;

public final class Constants {
    public static final int SCREEN_WIDRTH = Resources.getSystem().getDisplayMetrics().widthPixels;
    public static final int SCREEN_HEIGHT = Resources.getSystem().getDisplayMetrics().heightPixels;
    public static final int USEROBJECT_WIDTH = SCREEN_WIDRTH / 5;
    public static final int BALL_RADIUS = USEROBJECT_WIDTH / 5;
    public static final int INITIAL_CURRENT_X = SCREEN_WIDRTH / 2 - USEROBJECT_WIDTH / 16;
    public static final int INITIAL_CURRENT_Y = SCREEN_HEIGHT - USEROBJECT_WIDTH - 50;
    public static final int INITIAL_NEXT_X = SCREEN_WIDRTH / 2 + USEROBJECT_WIDTH + 50;
    public static final int INITIAL_NEXT_Y = SCREEN_HEIGHT - USEROBJECT_WIDTH - 50;
}
