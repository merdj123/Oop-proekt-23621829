import java.util.List;

public class Svg implements SvgEditor {

    private List<Shape> shapes;
    private String currentFile = "";

    public Svg(List<Shape> shapes) {
        this.shapes = shapes;
    }
    @Override
    public void close() {

    }

    @Override
    public void save(String filename) {

    }

    @Override
    public void print() {

    }

    @Override
    public void create(String[] params) {

    }

    @Override
    public void erase(int index) {

    }

    @Override
    public void translate(int index, int dx, int dy) {

    }

    @Override
    public void changeColor(int index, String newColor) {

    }

    public void help() {
        System.out.println("Available commands:");
        System.out.println("  open <filename>         - Open a file with shapes");
        System.out.println("  close                   - Close the current file");
        System.out.println("  save <filename>         - Save shapes to a file");
        System.out.println("  print                   - Print all shapes");
        System.out.println("  create <shape> <params> - Create a new shape");
        System.out.println("       rectangle <color> <x> <y> <width> <height>");
        System.out.println("       circle <color> <cx> <cy> <r>");
        System.out.println("       line <color> <x1> <y1> <x2> <y2>");
        System.out.println("  erase <index>           - Erase a shape by its index");
        System.out.println("  translate <index> <dx> <dy> - Move a shape");
        System.out.println("  color <index> <newColor>    - Change color of a shape");
        System.out.println("  help                    - Show this help");
        System.out.println("  exit                    - Exit the program");
    }

    public void exit() {
        System.out.println("Exiting program.");
        System.exit(0);
    }



    @Override
    public void open(String filename) {

    }

}

