import java.util.List;

class TranslateCommand extends Command {
    @Override
    public void execute(SVGContext context, String[] args) {
        int horizontal = 0;
        int vertical = 0;
        int shapeIndex = -1;

        for (int i = 1; i < args.length; i++) {
            String arg = args[i];
            if (arg.startsWith("horizontal=")) {
                try {
                    horizontal = Integer.parseInt(arg.substring("horizontal=".length()));
                } catch (NumberFormatException e) {
                    System.out.println("Invalid horizontal value.");
                    return;
                }
            } else if (arg.startsWith("vertical=")) {
                try {
                    vertical = Integer.parseInt(arg.substring("vertical=".length()));
                } catch (NumberFormatException e) {
                    System.out.println("Invalid vertical value.");
                    return;
                }
            } else {
                try {
                    shapeIndex = Integer.parseInt(arg);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid shape index.");
                    return;
                }
            }
        }

        List<Shape> shapes = context.getShapes();

        if (shapeIndex != -1) {
            if (shapeIndex <= 0 || shapeIndex > shapes.size()) {
                System.out.println("There is no figure number " + shapeIndex + "!");
                return;
            }

            shapes.get(shapeIndex - 1).translate(horizontal, vertical);
            System.out.println("Translated shape at index " + shapeIndex);
        } else {
            for (Shape shape : shapes) {
                shape.translate(horizontal, vertical);
            }
            System.out.println("Translated all figures");
        }
    }
}
