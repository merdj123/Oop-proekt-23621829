class Line extends Shape {
    private int x1;
    private int y1;
    private int x2;
    private int y2;

    public Line(int x1, int y1, int x2, int y2, String stroke) {
        super(stroke);
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    @Override
    public String getShapeType() {
        return "line";
    }

    @Override
    public void translate(int horizontal, int vertical) {
        this.x1 += horizontal;
        this.y1 += vertical;
        this.x2 += horizontal;
        this.y2 += vertical;
    }

    @Override
    public boolean isWithinRectangle(int x, int y, int width, int height) {
        return x1 >= x && x1 <= x + width && y1 >= y && y1 <= y + height &&
                x2 >= x && x2 <= x + width && y2 >= y && y2 <= y + height;
    }

    @Override
    public boolean isWithinCircle(int cx, int cy, int radius) {
        int dx1 = x1 - cx;
        int dy1 = y1 - cy;
        int dx2 = x2 - cx;
        int dy2 = y2 - cy;
        return (dx1*dx1 + dy1*dy1 <= radius*radius) &&
                (dx2*dx2 + dy2*dy2 <= radius*radius);
    }

    @Override
    public String toSVG() {
        return "<line x1=\"" + this.x1 + "\" y1=\"" + this.y1 + "\" x2=\"" +
                this.x2 + "\" y2=\"" + this.y2 + "\" stroke=\"" + this.fill + "\" />";
    }

    @Override
    public String toString() {
        return "line " + this.x1 + " " + this.y1 + " " + this.x2 + " " + this.y2 + " " + this.fill;
    }
}