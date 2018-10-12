package c.jasonli6395.napatgame;

public final class HelperLibrary {
    public static int ShortestDistance(int x,int y,int x1,int y1,int x2,int y2){
        int A = x - x1;
        int B = y - y1;
        int C = x2 - x1;
        int D = y2 - y1;
        int dot = A * C + B * D;
        int len_sq = C * C + D * D;
        int param = -1;
        if (len_sq != 0) //in case of 0 length line
            param = dot / len_sq;
        int xx, yy;

        if (param < 0) {
            xx = x1;
            yy = y1;
        }
        else if (param > 1) {
            xx = x2;
            yy = y2;
        }
        else {
            xx = x1 + param * C;
            yy = y1 + param * D;
        }

        int dx = x - xx;
        int dy = y - yy;
        return (int) Math.sqrt(dx * dx + dy * dy);
    }
}
