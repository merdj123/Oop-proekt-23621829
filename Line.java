import java.awt.*;

public class Line extends Shape {
    private int x1, y1, x2, y2;

    public Line(int x1, int y1, int x2, int y2, String color) {
        super(color);
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;

    }

    public String draw() {
        return "Line " + "(" + x1 + ", " + y1 + "),to (" + x2 + ", " + y2 + ")";

    }

    public void translate(int dx, int dy) {
        x1 += dx;
        y1 += dy;
        x2 += dx;
        y2 += dy;

    }

    public boolean isWithinRectangle(int rx, int ry, int rw, int rh) {
        return x1 >= rx && y1 >= ry && x1 <= (rx + rw) && y1 <= (ry + rh) &&
                x2 >= rx && y2 >= ry && x2 <= (rx + rw) && y2 <= (ry + rh);
    }

    public boolean isWithinCircle(int cx, int cy, int r) {
        return Math.hypot(x1 - cx, y1 - cy) <= r && Math.hypot(x2 - cx, y2 - cy) <= r;
    }

    public String toSVG() {
        return "<Line x1"+x1 +"y1"+y1 +"x2"+x2 +"y2"+y2+ "stroke "+color+">";
    }
}
