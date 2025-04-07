class CloseCommand extends Command {
    @Override
    public void execute(SVGContext context, String[] args) {
        context.getShapes().clear();
        context.setCurrentFile(null);
        System.out.println("File closed");
    }
}