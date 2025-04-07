import java.util.ArrayList;
import java.util.List;

class SVGContext {
    private List<Shape> shapes;
    private String currentFile;

    public SVGContext() {
        shapes = new ArrayList<>();
        currentFile = null;
    }

    public List<Shape> getShapes() {
        return shapes;
    }

    public String getCurrentFile() {
        return currentFile;
    }

    public void setCurrentFile(String file) {
        this.currentFile = file;
    }
}