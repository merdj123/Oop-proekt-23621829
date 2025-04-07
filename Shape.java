abstract class Shape {
    protected String fill;

    public Shape(String fill) {
        this.fill = fill;
    }

    public abstract String getShapeType();

    public abstract void translate(int horizontal, int vertical);

    public abstract boolean isWithinRectangle(int x, int y, int width, int height);

    public abstract boolean isWithinCircle(int cx, int cy, int radius);

    public abstract String toSVG();

    @Override
    public abstract String toString();
}