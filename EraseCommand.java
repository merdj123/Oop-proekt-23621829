import java.util.List;

class EraseCommand extends Command {
    @Override
    public void execute(SVGContext context, String[] args) {
        if (args.length < 2) {
            System.out.println("Invalid erase command format.");
            return;
        }

        try {
            int index = Integer.parseInt(args[1]);
            List<Shape> shapes = context.getShapes();

            if (index <= 0 || index > shapes.size()) {
                System.out.println("There is no figure number " + index + "!");
                return;
            }

            Shape removed = shapes.remove(index - 1);
            System.out.println("Erased a " + removed.getShapeType() + " (" + index + ")");
        } catch (NumberFormatException e) {
            System.out.println("Invalid index format.");
        }
    }
}
