package c.jasonli6395.napatgame;

import android.support.annotation.NonNull;
import android.util.Log;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;

public class UserObjectHandler {
    public Queue<UserObjects> ObjectList;

    public UserObjectHandler() {
        ObjectList = new LinkedList<>();
        for (int i = 0; i < 3; i++) {
            addRandomObject();
        }
    }

    public void generateNextObject() {
        addRandomObject();
    }

    private void addRandomObject() {
        int randomNum = getRandomNumberInRange(0, 1);
        switch (randomNum) {
            case 0:
                ObjectList.add(new Triangle());
                break;
            case 1:
                ObjectList.add(new Square());
                break;
            default:
                ObjectList.add(new Square());
                break;
        }

    }

    private static int getRandomNumberInRange(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }
}

