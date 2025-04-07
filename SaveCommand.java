import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

class SaveCommand extends Command {
    @Override
    public void execute(SVGContext context, String[] args) {
        String filename = context.getCurrentFile();

        if (filename == null) {
            System.out.println("No file is currently open. Use 'save as' command.");
            return;
        }

        saveSVG(context.getShapes(), filename);
        System.out.println("Successfully saved the changes to " + filename);
    }

    protected void saveSVG(List<Shape> shapes, String filename) {
        try {
            FileWriter writer = new FileWriter(filename);
            writer.write("<?xml version=\"1.0\" standalone=\"no\"?>\n");
            writer.write("<!DOCTYPE svg PUBLIC \"-//W3C//DTD SVG 1.1//EN\" \"http://www.w3.org/Graphics/SVG/1.1/DTD/svg11.dtd\">\n");
            writer.write("<svg>\n");

            for (Shape shape : shapes) {
                writer.write(shape.toSVG() + "\n");
            }

            writer.write("</svg>");
            writer.close();
        } catch (IOException e) {
            System.out.println("Error saving file: " + e.getMessage());
        }
    }
}