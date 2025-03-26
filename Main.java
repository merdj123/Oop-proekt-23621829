import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        List<Shape> shapes = new ArrayList<>();
        Svg svgEditor = new Svg(shapes);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("> ");
            String input = scanner.nextLine().trim();
            if (input.isEmpty()) continue;

            String[] parts = input.split("\\s+", 2);
            String command = parts[0].toLowerCase();
            String parameters = parts.length > 1 ? parts[1] : "";

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
                        if (parameters.isEmpty()) {
                            if (svgEditor.getCurrentFile().isEmpty()) {
                                System.out.println("No file is open");
                            } else {
                                svgEditor.save(svgEditor.getCurrentFile());
                            }
                        } else {
                            svgEditor.save(parameters);
                        }
                        break;

                    case "print":


                    case "create":

                    case "erase":


                    case "translate":


                    case "within":

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