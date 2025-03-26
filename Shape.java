abstract class Shape {
    protected String color;

    public Shape(String color) {
        this.color = color;
    }

    public abstract String toString();
    public abstract String toSVG();
    public abstract boolean isWithin(Rectangle rectangle);
    public abstract boolean isWithin(Circle circle);
    public abstract void translate(int dx, int dy);

    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }
}