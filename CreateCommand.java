class CreateCommand extends Command {
    @Override
    public void execute(SVGContext context, String[] args) {
        if (args.length < 2) {
            System.out.println("Invalid create command format.");
            return;
        }

        String shapeType = args[1];
        Shape newShape = null;

        if (shapeType.equals("rectangle")) {
            if (args.length < 7) {
                System.out.println("Invalid rectangle format.");
                return;
            }
            try {
                int x = Integer.parseInt(args[2]);
                int y = Integer.parseInt(args[3]);
                int width = Integer.parseInt(args[4]);
                int height = Integer.parseInt(args[5]);
                String fill = args[6];
                newShape = new Rectangle(x, y, width, height, fill);
            } catch (NumberFormatException e) {
                System.out.println("Invalid rectangle parameters.");
                return;
            }
        } else if (shapeType.equals("circle")) {
            if (args.length < 6) {
                System.out.println("Invalid circle format.");
                return;
            }
            try {
                int cx = Integer.parseInt(args[2]);
                int cy = Integer.parseInt(args[3]);
                int radius = Integer.parseInt(args[4]);
                String fill = args[5];
                newShape = new Circle(cx, cy, radius, fill);
            } catch (NumberFormatException e) {
                System.out.println("Invalid circle parameters.");
                return;
            }
        } else if (shapeType.equals("line")) {
            if (args.length < 7) {
                System.out.println("Invalid line format.");
                return;
            }
            try {
                int x1 = Integer.parseInt(args[2]);
                int y1 = Integer.parseInt(args[3]);
                int x2 = Integer.parseInt(args[4]);
                int y2 = Integer.parseInt(args[5]);
                String stroke = args[6];
                newShape = new Line(x1, y1, x2, y2, stroke);
            } catch (NumberFormatException e) {
                System.out.println("Invalid line parameters.");
                return;
            }
        } else {
            System.out.println("Unknown shape type: " + shapeType);
            return;
        }

        if (newShape != null) {
            context.getShapes().add(newShape);
            System.out.println("Successfully created " + newShape.getShapeType() + " (" + context.getShapes().size() + ")");
        }
    }
}
