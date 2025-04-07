import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class OpenCommand extends Command {
    @Override
    public void execute(SVGContext context, String[] args) {
        if (args.length < 2) {
            System.out.println("Invalid open command format.");
            return;
        }

        String filename = args[1];
        context.getShapes().clear();
        context.setCurrentFile(filename);

        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            StringBuilder svgContent = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                svgContent.append(line);
            }
            reader.close();

            parseShapes(svgContent.toString(), context.getShapes());

            System.out.println("Successfully opened " + filename);
        } catch (IOException e) {
            System.out.println("Error opening file: " + e.getMessage());
        }
    }

    private void parseShapes(String svgContent, List<Shape> shapes) {
        // Извличане на правоъгълници
        Pattern rectPattern = Pattern.compile("<rect\\s+x=\"(\\d+)\"\\s+y=\"(\\d+)\"\\s+width=\"(\\d+)\"\\s+height=\"(\\d+)\"\\s+fill=\"([^\"]+)\"\\s*/>");
        Matcher rectMatcher = rectPattern.matcher(svgContent);

        while (rectMatcher.find()) {
            int x = Integer.parseInt(rectMatcher.group(1));
            int y = Integer.parseInt(rectMatcher.group(2));
            int width = Integer.parseInt(rectMatcher.group(3));
            int height = Integer.parseInt(rectMatcher.group(4));
            String fill = rectMatcher.group(5);

            shapes.add(new Rectangle(x, y, width, height, fill));
        }

        // Извличане на кръгове
        Pattern circlePattern = Pattern.compile("<circle\\s+cx=\"(\\d+)\"\\s+cy=\"(\\d+)\"\\s+r=\"(\\d+)\"\\s+fill=\"([^\"]+)\"\\s*/>");
        Matcher circleMatcher = circlePattern.matcher(svgContent);

        while (circleMatcher.find()) {
            int cx = Integer.parseInt(circleMatcher.group(1));
            int cy = Integer.parseInt(circleMatcher.group(2));
            int r = Integer.parseInt(circleMatcher.group(3));
            String fill = circleMatcher.group(4);

            shapes.add(new Circle(cx, cy, r, fill));
        }

        // Извличане на линии
        Pattern linePattern = Pattern.compile("<line\\s+x1=\"(\\d+)\"\\s+y1=\"(\\d+)\"\\s+x2=\"(\\d+)\"\\s+y2=\"(\\d+)\"\\s+stroke=\"([^\"]+)\"\\s*/>");
        Matcher lineMatcher = linePattern.matcher(svgContent);

        while (lineMatcher.find()) {
            int x1 = Integer.parseInt(lineMatcher.group(1));
            int y1 = Integer.parseInt(lineMatcher.group(2));
            int x2 = Integer.parseInt(lineMatcher.group(3));
            int y2 = Integer.parseInt(lineMatcher.group(4));
            String stroke = lineMatcher.group(5);

            shapes.add(new Line(x1, y1, x2, y2, stroke));
        }
    }
}
