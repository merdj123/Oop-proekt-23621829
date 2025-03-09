class Rectangle extends Shape {
    private int x, y, width, height;

    public Rectangle(String color, int x, int y, int width, int height) {
        super(color);
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    @Override
    public String toString() {
        return "rectangle " + x + " " + y + " " + width + " " + height + " " + color;
    }

    @Override
    public String toSVG() {
        return "<rect x=\"" + x + "\" y=\"" + y + "\" width=\"" + width +
                "\" height=\"" + height + "\" fill=\"" + color + "\" />";
    }

    @Override
    public boolean isWithin(Rectangle rectangle) {
        return x >= rectangle.x && y >= rectangle.y &&
                x + width <= rectangle.x + rectangle.width &&
                y + height <= rectangle.y + rectangle.height;
    }

    @Override
    public boolean isWithin(Circle circle) {
        return isPointInCircle(x, y, circle) &&
                isPointInCircle(x + width, y, circle) &&
                isPointInCircle(x, y + height, circle) &&
                isPointInCircle(x + width, y + height, circle);
    }

    private boolean isPointInCircle(int px, int py, Circle circle) {
        int dx = px - circle.getCx();
        int dy = py - circle.getCy();
        return dx * dx + dy * dy <= circle.getR() * circle.getR();
    }

    @Override
    public void translate(int dx, int dy) {
        x += dx;
        y += dy;
    }

    public int getX() { return x; }
    public int getY() { return y; }
    public int getWidth() { return width; }
    public int getHeight() { return height; }
}
class Rectangle extends Shape {
    private int x, y, width, height;

    public Rectangle(String color, int x, int y, int width, int height) {
        super(color);
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    @Override
    public String toString() {
        return "rectangle " + x + " " + y + " " + width + " " + height + " " + color;
    }

    @Override
    public String toSVG() {
        return "<rect x=\"" + x + "\" y=\"" + y + "\" width=\"" + width +
                "\" height=\"" + height + "\" fill=\"" + color + "\" />";
    }

    @Override
    public boolean isWithin(Rectangle rectangle) {
        return x >= rectangle.x && y >= rectangle.y &&
                x + width <= rectangle.x + rectangle.width &&
                y + height <= rectangle.y + rectangle.height;
    }

    @Override
    public boolean isWithin(Circle circle) {
        return isPointInCircle(x, y, circle) &&
                isPointInCircle(x + width, y, circle) &&
                isPointInCircle(x, y + height, circle) &&
                isPointInCircle(x + width, y + height, circle);
    }

    private boolean isPointInCircle(int px, int py, Circle circle) {
        int dx = px - circle.getCx();
        int dy = py - circle.getCy();
        return dx * dx + dy * dy <= circle.getR() * circle.getR();
    }

    @Override
    public void translate(int dx, int dy) {
        x += dx;
        y += dy;
    }

    public int getX() { return x; }
    public int getY() { return y; }
    public int getWidth() { return width; }
    public int getHeight() { return height; }
}
