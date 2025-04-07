class Circle extends Shape {
    private int cx;
    private int cy;
    private int radius;

    public Circle(int cx, int cy, int radius, String fill) {
        super(fill);
        this.cx = cx;
        this.cy = cy;
        this.radius = radius;
    }

    @Override
    public String getShapeType() {
        return "circle";
    }

    @Override
    public void translate(int horizontal, int vertical) {
        this.cx += horizontal;
        this.cy += vertical;
    }

    @Override
    public boolean isWithinRectangle(int x, int y, int width, int height) {
        return this.cx - this.radius >= x &&
                this.cx + this.radius <= x + width &&
                this.cy - this.radius >= y &&
                this.cy + this.radius <= y + height;
    }

    @Override
    public boolean isWithinCircle(int cx, int cy, int radius) {
        int dx = this.cx - cx;
        int dy = this.cy - cy;
        return Math.sqrt(dx * dx + dy * dy) + this.radius <= radius;
    }

    @Override
    public String toSVG() {
        return "<circle cx=\"" + this.cx + "\" cy=\"" + this.cy + "\" r=\"" +
                this.radius + "\" fill=\"" + this.fill + "\" />";
    }

    @Override
    public String toString() {
        return "circle " + this.cx + " " + this.cy + " " + this.radius + " " + this.fill;
    }
}