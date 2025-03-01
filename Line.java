import java.awt.*;

public class Line extends shape {
    private int x1, y1, x2, y2;
    public Line(int x1, int y1, int x2, int y2, String color) {
        super(color);
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;

    }
    public String draw() {
        return "Line "+"(" + x1 + ", " + y1 + "),to (" + x2 + ", " + y2+")";

    }
    public void translate(int dx, int dy) {
        x1 += dx;
        y1 += dy;
        x2 += dx;
        y2 += dy;

    }
}
