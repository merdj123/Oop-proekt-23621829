import java.util.ArrayList;
import java.util.List;

class WithinCommand extends Command {
    @Override
    public void execute(SVGContext context, String[] args) {
        if (args.length < 2) {
            System.out.println("Invalid within command format.");
            return;
        }

        String option = args[1];
        List<Shape> shapes = context.getShapes();
        List<Shape> withinShapes = new ArrayList<>();

        if (option.equals("rectangle")) {
            if (args.length < 6) {
                System.out.println("Invalid within rectangle format.");
                return;
            }

            try {
                int x = Integer.parseInt(args[2]);
                int y = Integer.parseInt(args[3]);
                int width = Integer.parseInt(args[4]);
                int height = Integer.parseInt(args[5]);

                for (Shape shape : shapes) {
                    if (shape.isWithinRectangle(x, y, width, height)) {
                        withinShapes.add(shape);
                    }
                }

                if (withinShapes.isEmpty()) {
                    System.out.println("No figures are located within rectangle " + x + " " + y + " " + width + " " + height);
                } else {
                    for (Shape shape : withinShapes) {
                        int index = shapes.indexOf(shape) + 1;
                        System.out.println(index + ". " + shape.toString());
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid rectangle parameters.");
            }
        } else if (option.equals("circle")) {
            if (args.length < 5) {
                System.out.println("Invalid within circle format.");
                return;
            }

            try {
                int cx = Integer.parseInt(args[2]);
                int cy = Integer.parseInt(args[3]);
                int radius = Integer.parseInt(args[4]);

                for (Shape shape : shapes) {
                    if (shape.isWithinCircle(cx, cy, radius)) {
                        withinShapes.add(shape);
                    }
                }

                if (withinShapes.isEmpty()) {
                    System.out.println("No figures are located within circle " + cx + " " + cy + " " + radius);
                } else {
                    for (Shape shape : withinShapes) {
                        int index = shapes.indexOf(shape) + 1;
                        System.out.println(index + ". " + shape.toString());
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid circle parameters.");
            }
        } else {
            System.out.println("Unknown option for within command: " + option);
        }
    }
}