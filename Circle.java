public class Circle extends Shape {

    private  int cx, cy, radius;

    public Circle(String color ,int cx, int cy, int radius) {
        super(color);
        this.cx = cx;
        this.cy = cy;
        this.radius = radius;

    }
    public String draw(){
        return "circle : ("+cx+","+cy+"),radius : "+radius +",color"+color;
    }
    public void translate(int dx, int dy) {
     cx += dx;
     cy += dy;

    }
}
