public abstract class shape {
    protected  String color;
    public shape(String color) {
        this.color = color;
    }
    public abstract String  draw() ;
    public abstract void translate(int dx ,int  dy);
}
