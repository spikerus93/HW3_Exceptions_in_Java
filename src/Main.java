import model.exceptions.MyExceptions;
import model.writer.FileHandler;
import view.commands.ConsoleUI;

public class Main {
    public static void main(String[] args) throws MyExceptions {
        ConsoleUI consoleUI = new ConsoleUI();
        consoleUI.setWritable(new FileHandler());
        consoleUI.start();
    }
}
