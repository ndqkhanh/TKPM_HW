import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        boolean connect = ProductDAO.connectDB();
        if (!connect) {
            return;
        }
        MainUI.createAndShowGUI();
    }
}