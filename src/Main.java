import model.writer.FileHandler;
import view.commands.ConsoleUI;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        ConsoleUI consoleUI = new ConsoleUI();
        consoleUI.setWritable(new FileHandler());
        consoleUI.start();
    }
}
