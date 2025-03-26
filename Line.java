class Line extends Shape {
    private int x1, y1, x2, y2;

    public Line(String color, int x1, int y1, int x2, int y2) {
        super(color);
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    @Override
    public String toString() {
        return "line " + x1 + " " + y1 + " " + x2 + " " + y2 + " " + color;
    }

    @Override
    public String toSVG() {
        return "<line x1=\"" + x1 + "\" y1=\"" + y1 +
                "\" x2=\"" + x2 + "\" y2=\"" + y2 +
                "\" stroke=\"" + color + "\" />";
    }

    @Override
    public boolean isWithin(Rectangle rect) {
        return (x1 >= rect.getX() && y1 >= rect.getY() &&
                x2 <= rect.getX() + rect.getWidth() &&
                y2 <= rect.getY() + rect.getHeight());
    }

    @Override
    public boolean isWithin(Circle circle) {
        return isInside(x1, y1, circle) && isInside(x2, y2, circle);
    }

    private boolean isInside(int x, int y, Circle circle) {
        int dx = x - circle.getCx();
        int dy = y - circle.getCy();
        return dx * dx + dy * dy <= circle.getR() * circle.getR();
    }

    @Override
    public void translate(int dx, int dy) {
        x1 += dx;
        y1 += dy;
        x2 += dx;
        y2 += dy;
    }
}