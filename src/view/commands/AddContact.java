package view.commands;

import model.exceptions.MyExceptions;

public class AddContact extends Command {
    public AddContact(ConsoleUI consoleUI){
        super(consoleUI);
        description = "Добавить контакт";
    }

    @Override
    public void execute() throws MyExceptions {
        consoleUI.addContact();
    }
}
