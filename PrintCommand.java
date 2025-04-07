import java.util.List;

class PrintCommand extends Command {
    @Override
    public void execute(SVGContext context, String[] args) {
        List<Shape> shapes = context.getShapes();
        if (shapes.isEmpty()) {
            System.out.println("No shapes to display.");
            return;
        }

        for (int i = 0; i < shapes.size(); i++) {
            System.out.println((i + 1) + ". " + shapes.get(i).toString());
        }
    }
}