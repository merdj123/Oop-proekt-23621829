import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.*;

public class Svg implements SvgEditor {

    private List<Shape> shapes;
    private String currentFile = "";

    public Svg(List<Shape> shapes) {
        this.shapes = shapes;
    }
    public void open(String filename) {
        currentFile = filename;
        shapes.clear();
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new File(filename));
            doc.getDocumentElement().normalize();
            NodeList list = doc.getDocumentElement().getChildNodes();
            for (int i = 0; i < list.getLength(); i++) {
                Node n = list.item(i);
                if (n.getNodeType() != Node.ELEMENT_NODE) continue;
                Element elem = (Element) n;
                String tag = elem.getTagName().toLowerCase();
                if (tag.equals("rect")) {
                    String color = elem.getAttribute("fill");
                    int x = Integer.parseInt(elem.getAttribute("x"));
                    int y = Integer.parseInt(elem.getAttribute("y"));
                    int w = Integer.parseInt(elem.getAttribute("width"));
                    int h = Integer.parseInt(elem.getAttribute("height"));
                    shapes.add(new Rectangle(color, x, y, w, h));
                } else if (tag.equals("circle")) {
                    String color = elem.getAttribute("fill");
                    int cx = Integer.parseInt(elem.getAttribute("cx"));
                    int cy = Integer.parseInt(elem.getAttribute("cy"));
                    int r = Integer.parseInt(elem.getAttribute("r"));
                    shapes.add(new Circle(color, cx, cy, r));
                } else if (tag.equals("line")) {
                    String color = elem.getAttribute("stroke");
                    int x1 = Integer.parseInt(elem.getAttribute("x1"));
                    int y1 = Integer.parseInt(elem.getAttribute("y1"));
                    int x2 = Integer.parseInt(elem.getAttribute("x2"));
                    int y2 = Integer.parseInt(elem.getAttribute("y2"));
                    shapes.add(new Line( x1, y1, x2, y2,color));
                }
            }
            System.out.println("Opened " + filename);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
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





}

