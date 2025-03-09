public class Rectangle extends Shape {
    private int x,y,w,h;
    public Rectangle(String color ,int x, int y, int w, int h) {
        super(color);
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;}
    public String draw() {
        return "rectangle :("+x+","+y+"), width="+w+", height="+h +" color="+color;

    }
    public void translate(int dx, int dy) {
      x += dx;
      y += dy;

    }
}
