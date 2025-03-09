public interface SvgEditor {
        void open(String filename);
        void close();
        void save(String filename);
        void print();
        void create(String[] params);
        void erase(int index);
        void translate(int index, int dx, int dy);
        void help();
        void exit();
 }

