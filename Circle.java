public class Circle extends Shape {

    private  int cx, cy, radius;

    public Circle(String color ,int cx, int cy, int radius) {
        super(color);
        this.cx = cx;
        this.cy = cy;
        this.radius = radius;

    }
    public String draw(){
        return "circle : ("+cx+","+cy+"),radius : "+radius +",color"+color;
    }
    public void translate(int dx, int dy) {
     cx += dx;
     cy += dy;

    }

    public boolean isWithinRectangle(int rx, int ry, int rw, int rh) {
        return (cx - radius) >= rx && (cy - radius) >= ry && (cx + radius) <= (rx + rw) && (cy + radius) <= (ry + rh);
    }
    public boolean isWithinCircle(int ccx, int ccy, int cr) {
        return Math.hypot(cx - ccx, cy - ccy) + radius <= cr;
    }
    public String toSVG() {
        return "<circle  cx "+ cx+ "cy "+ cy+ "radius "+ radius + "fill "+ color + ">";
    }
}
