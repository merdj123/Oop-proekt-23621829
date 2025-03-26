class Circle extends Shape {
    private int cx, cy, r;

    public Circle(String color, int cx, int cy, int r) {
        super(color);
        this.cx = cx;
        this.cy = cy;
        this.r = r;
    }

    @Override
    public String toString() {
        return "circle " + cx + " " + cy + " " + r + " " + color;
    }

    @Override
    public String toSVG() {
        return "<circle cx=\"" + cx + "\" cy=\"" + cy + "\" r=\"" + r +
                "\" fill=\"" + color + "\" />";
    }

    @Override
    public boolean isWithin(Rectangle rectangle) {
        return cx - r >= rectangle.getX() &&
                cy - r >= rectangle.getY() &&
                cx + r <= rectangle.getX() + rectangle.getWidth() &&
                cy + r <= rectangle.getY() + rectangle.getHeight();
    }

    @Override
    public boolean isWithin(Circle circle) {
        int dx = cx - circle.cx;
        int dy = cy - circle.cy;
        double distance = Math.sqrt(dx * dx + dy * dy);
        return distance + r <= circle.r;
    }

    @Override
    public void translate(int dx, int dy) {
        cx += dx;
        cy += dy;
    }

    public int getCx() { return cx; }
    public int getCy() { return cy; }
    public int getR() { return r; }
}