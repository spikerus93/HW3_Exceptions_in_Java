package view.commands;

public class AddContact extends Command {
    public AddContact(ConsoleUI consoleUI){
        super(consoleUI);
        description = "Добавить контакт";
    }

    @Override
    public void execute() {
        consoleUI.addContact();
    }
}
