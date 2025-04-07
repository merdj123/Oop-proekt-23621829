class HelpCommand extends Command {
    @Override
    public void execute(SVGContext context, String[] args) {
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
    }
}