class ExitCommand extends Command {
    @Override
    public void execute(SVGContext context, String[] args) {
        System.out.println("Exit");
        System.exit(0);
    }
}