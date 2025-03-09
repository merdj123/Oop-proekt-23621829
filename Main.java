import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Svg svgEditor = new Svg();
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


