import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.*;
public class Svg implements SvgEditor {
    private List<Shape> shapes;
    private String currentFile = "svg.test";

    public Svg(List<Shape> shapes) {
        this.shapes = shapes;
    }

    @Override
    public void open(String filename) {
        try {
            File file = new File(filename);
            if (!file.exists()) {
                System.out.println("Error: File '" + filename + "' does not exist");
                return;
            }

            currentFile = filename;
            shapes.clear();

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(file);
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
                    shapes.add(new Line(color, x1, y1, x2, y2));
                }
            }
            System.out.println("Successfully opened " + filename);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    @Override
    public void close() {
        shapes.clear();
        currentFile = "";
        System.out.println("Closed file");
    }

    @Override
    public void save() {
        if (currentFile.isEmpty()) {
            System.out.println("No current file to save to. Use 'saveas <filename>' instead.");
            return;
        }

        if (writeToFile(currentFile)) {
            System.out.println("Successfully saved to " + currentFile);
        }
    }


    @Override
    public void saveAs(String filename) {
        if (filename.isEmpty()) {
            System.out.println("Error: No filename specified");
            return;
        }


        String finalFilename = filename;
        if (!finalFilename.toLowerCase().endsWith(".svg")) {
            finalFilename += ".svg";
        }


        File file = new File(finalFilename);
        if (file.exists()) {
            System.out.println("Warning: File '" + finalFilename + "' already exists.");

        }

        if (writeToFile(finalFilename)) {
            currentFile = finalFilename;
            System.out.println("Successfully saved as " + finalFilename);
        }
    }


    private boolean writeToFile(String filename) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            writer.println("<?xml version=\"1.0\" standalone=\"no\"?>");
            writer.println("<!DOCTYPE svg PUBLIC \"-//W3C//DTD SVG 1.1//EN\"");
            writer.println("  \"http://www.w3.org/Graphics/SVG/1.1/DTD/svg11.dtd\">");
            writer.println("<svg width=\"800\" height=\"600\" xmlns=\"http://www.w3.org/2000/svg\" version=\"1.1\">");
            for (Shape s : shapes) {
                writer.println("  " + s.toSVG());
            }
            writer.println("</svg>");
            return true;
        } catch (Exception e) {
            System.out.println("Error saving file: " + e.getMessage());
            return false;
        }
    }

    @Override
    public void print() {
        if (shapes.isEmpty()) {
            System.out.println("No shapes to display");
            return;
        }
        System.out.println("Current file: " + (currentFile.isEmpty() ? "None" : currentFile));
        System.out.println("Shapes:");
        for (int i = 0; i < shapes.size(); i++) {
            System.out.println((i + 1) + ". " + shapes.get(i).toString());
        }
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

    public void within(String option, String[] params) {

    }

    @Override
    public void help() {
        System.out.println("Available commands:");
        System.out.println("  open <filename>         - Open an SVG file");
        System.out.println("  close                   - Close the current file");
        System.out.println("  save                    - Save to the current file");
        System.out.println("  saveas <filename>       - Save to a new file (Save As)");
        System.out.println("  print                   - Display all shapes");
        System.out.println("  create <shape> <params> - Create a new shape");
        System.out.println("       rectangle <x> <y> <width> <height> <color>");
        System.out.println("       circle <cx> <cy> <r> <color>");
        System.out.println("       line <x1> <y1> <x2> <y2> <color>");
        System.out.println("  erase <n>               - Delete shape number n");
        System.out.println("  translate [<n>] horizontal=<dx> vertical=<dy> - Move shape(s)");
        System.out.println("  changecolor <n> <color> - Change color of shape n");
        System.out.println("  within <option> <params> - Find shapes within a region");
        System.out.println("       rectangle <x> <y> <width> <height>");
        System.out.println("       circle <cx> <cy> <r>");
        System.out.println("  help                    - Show this help");
        System.out.println("  exit                    - Exit the program");
    }

    @Override
    public void exit() {
        System.out.println("Exiting program");
        System.exit(0);
    }

    public String getCurrentFile() {
        return currentFile;
    }

}