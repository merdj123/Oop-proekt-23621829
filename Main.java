import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        List<Shape> shapes = new ArrayList<>();
        Svg svgEditor = new Svg(shapes);
        Scanner scanner = new Scanner(System.in);

        System.out.println("SVG Editor started. Type 'help' for commands.");

        while (true) {
            System.out.print("> ");
            String input = scanner.nextLine().trim();
            if (input.isEmpty()) continue;

            String[] tokens = input.split("\\s+", 2);
            String command = tokens[0].toLowerCase();
            String parameters = tokens.length > 1 ? tokens[1] : "";

            try {
                switch (command) {
                    case "open":
                        if (parameters.isEmpty()) {
                            System.out.println("Please specify a filename");
                        } else {
                            svgEditor.open(parameters);
                        }
                        break;

                    case "close":
                        svgEditor.close();
                        break;

                    case "save":
                        svgEditor.save();
                        break;

                    case "saveas":
                        if (parameters.isEmpty()) {
                            System.out.println("Usage: saveas <filename>");
                        } else {
                            svgEditor.saveAs(parameters);
                        }
                        break;

                    case "print":
                        svgEditor.print();
                        break;

                    case "create":
                        break;

                    case "erase":
                       break;

                    case "translate":
                       break;

                    case "changecolor":
                       break;

                    case "within":
                      break;

                    case "help":
                        svgEditor.help();
                        break;

                    case "exit":
                        svgEditor.exit();
                        break;

                    default:
                        System.out.println("Unknown command. Type 'help' for a list of commands.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}