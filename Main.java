import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Shape> shapes = new ArrayList<>();
        Svg svgEditor = new Svg(shapes);
        Scanner scanner = new Scanner(System.in);
        System.out.println("SVG Editor - Enter a command (type 'help' for commands):");
        while (true) {
            System.out.print("> ");
            String command = scanner.next();
            try {
                if (command.equalsIgnoreCase("open")) {
                } else if (command.equalsIgnoreCase("help")) {
                    svgEditor.help();
                } else if (command.equalsIgnoreCase("exit")) {
                    svgEditor.exit();
                } else {
                    System.out.println("Unknown command. Type 'help' for a list of commands.");
                }

            } catch (Exception e) {
                System.out.println("Invalid input. Please check your command format.");
                scanner.nextLine();
            }


        }
    }
}


