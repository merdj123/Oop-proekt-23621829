public abstract class Shape {
    protected  String color;
    public Shape(String color) {
        this.color = color;
    }
    public abstract String  draw() ;
    public abstract void translate(int dx ,int  dy);
}
