package presenter;

import model.Service;
import model.exceptions.MyExceptions;
import model.writer.Writable;
import view.commands.ConsoleUI;
import view.commands.View;

public class Presenter{
    private final View view;
    private  final Service service;

    public Presenter(View view) {
        this.view = view;
        this.service = new Service();
    }

    public void setWritable (Writable writable) {
        service.setWritable(writable);
    }

    public void addContact (String text) {
        String line;
        try {
            line = service.addContact(text);
        } catch (MyExceptions e) {
            throw new RuntimeException(e.getMessage());
        }
        view.answer("Успешно!\n");
        view.answer(line);
    }

    public void read() {
        try {
            service.read();
        }catch (MyExceptions e) {
            System.out.println(e.getMessage());
        }
    }
}
