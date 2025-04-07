import java.io.FileWriter;
import java.io.IOException;

class SaveAsCommand extends Command {
    @Override
    public void execute(SVGContext context, String[] args) {
        if (args.length < 3) {
            System.out.println("Invalid save as command format.");
            return;
        }

        String filename = args[2];
        context.setCurrentFile(filename);

        try {
            FileWriter writer = new FileWriter(filename);
            writer.write("<?xml version=\"1.0\" standalone=\"no\"?>\n");
            writer.write("<!DOCTYPE svg PUBLIC \"-//W3C//DTD SVG 1.1//EN\" \"http://www.w3.org/Graphics/SVG/1.1/DTD/svg11.dtd\">\n");
            writer.write("<svg>\n");

            for (Shape shape : context.getShapes()) {
                writer.write(shape.toSVG() + "\n");
            }

            writer.write("</svg>");
            writer.close();

            System.out.println("Successfully saved as " + filename);
        } catch (IOException e) {
            System.out.println("Error saving file: " + e.getMessage());
        }
    }
}
