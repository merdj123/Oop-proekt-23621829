import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        SVGContext context = new SVGContext();
        Map<String, Command> commands = new HashMap<>();

        commands.put("print", new PrintCommand());
        commands.put("create", new CreateCommand());
        commands.put("erase", new EraseCommand());
        commands.put("translate", new TranslateCommand());
        commands.put("within", new WithinCommand());
        commands.put("open", new OpenCommand());
        commands.put("save", new SaveCommand());
        commands.put("save as", new SaveAsCommand());
        commands.put("close", new CloseCommand());
        commands.put("help", new HelpCommand());
        commands.put("exit", new ExitCommand());


        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Available commands:");
        System.out.println("open <filename> - Open SVG file");
        System.out.println("close - Close current file");
        System.out.println("save - Save changes to current file");
        System.out.println("save as <filename> - Save changes to a new file");
        System.out.println("print - Print all shapes");
        System.out.println("create <shape> <params> - Create a new shape");
        System.out.println("erase <n> - Delete shape with index n");
        System.out.println("translate [<n>] [horizontal=X] [vertical=Y] - Translate shape(s)");
        System.out.println("within <option> <params> - Find shapes within region");
        System.out.println("help - Show this help message");
        System.out.println("exit - Exit the program");

        while (true) {
            try {
                System.out.print("> ");
                String input = reader.readLine();

                if (input == null || input.trim().isEmpty()) {
                    continue;
                }

                executeCommand(input, commands, context);
            } catch (IOException e) {
                System.out.println("Error reading input: " + e.getMessage());
            }
        }
    }

    private static void executeCommand(String input, Map<String, Command> commands, SVGContext context) {
        String[] parts = input.trim().split("\\s+");
        String commandName = parts[0].toLowerCase();

        // Специален случай за "save as" команда
        if (parts.length > 1 && commandName.equals("save") && parts[1].equals("as")) {
            commandName = "save as";
        }

        Command command = commands.get(commandName);

        if (command != null) {
            command.execute(context, parts);
        } else {
            System.out.println("Unknown command: " + commandName);
        }
    }
}