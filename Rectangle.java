public class Rectangle extends Shape {
    private int x,y,w,h;
    public Rectangle(String color ,int x, int y, int w, int h) {
        super(color);
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;}
    public String draw() {
        return "rectangle :("+x+","+y+"), width="+w+", height="+h +" color="+color;

    }
    public void translate(int dx, int dy) {
      x += dx;
      y += dy;

    }
    public boolean isWithinRectangle(int rx, int ry, int rw, int rh) {
        return x >= rx && y >= ry && (x + w) <= (rx + rw) && (y + h) <= (ry + rh);
    }
    public boolean isWithinCircle(int cx, int cy, int r) {
        return Math.hypot(x - cx, y - cy) <= r &&
                Math.hypot((x + w) - cx, y - cy) <= r &&
                Math.hypot(x - cx, (y + h) - cy) <= r &&
                Math.hypot((x + w) - cx, (y + h) - cy) <= r;
    }
    public String toSVG() {
        return "<Rectangle  x"+x+", y"+y+", width"+w+", height"+h +" fill="+color+">";
    }

}
