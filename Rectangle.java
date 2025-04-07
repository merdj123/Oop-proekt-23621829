class Rectangle extends Shape {
    private int x;
    private int y;
    private int width;
    private int height;

    public Rectangle(int x, int y, int width, int height, String fill) {
        super(fill);
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    @Override
    public String getShapeType() {
        return "rectangle";
    }

    @Override
    public void translate(int horizontal, int vertical) {
        this.x += horizontal;
        this.y += vertical;
    }

    @Override
    public boolean isWithinRectangle(int x, int y, int width, int height) {
        return this.x >= x && this.x + this.width <= x + width &&
                this.y >= y && this.y + this.height <= y + height;
    }

    @Override
    public boolean isWithinCircle(int cx, int cy, int radius) {
        // Проверка дали всички ъгли са в кръга
        int dx1 = this.x - cx;
        int dy1 = this.y - cy;
        int dx2 = (this.x + this.width) - cx;
        int dy2 = this.y - cy;
        int dx3 = this.x - cx;
        int dy3 = (this.y + this.height) - cy;
        int dx4 = (this.x + this.width) - cx;
        int dy4 = (this.y + this.height) - cy;

        return (dx1*dx1 + dy1*dy1 <= radius*radius) &&
                (dx2*dx2 + dy2*dy2 <= radius*radius) &&
                (dx3*dx3 + dy3*dy3 <= radius*radius) &&
                (dx4*dx4 + dy4*dy4 <= radius*radius);
    }

    @Override
    public String toSVG() {
        return "<rect x=\"" + this.x + "\" y=\"" + this.y + "\" width=\"" +
                this.width + "\" height=\"" + this.height + "\" fill=\"" + this.fill + "\" />";
    }

    @Override
    public String toString() {
        return "rectangle " + this.x + " " + this.y + " " + this.width + " " + this.height + " " + this.fill;
    }
}
