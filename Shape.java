public abstract class Shape {
    protected String color;
    public Shape(String color) { this.color = color; }
    public abstract String draw();
    public abstract void translate(int dx, int dy);
    public abstract boolean isWithinRectangle(int x, int w, int y, int h);
    public abstract boolean isWithinCircle(int cx, int cy, int r);
}
