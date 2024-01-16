package view.commands;

public class ReadContacts extends Command {
    public ReadContacts(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Показать все контакты";
    }

    @Override
    public void execute() {
        consoleUI.read();
    }
}
