package view.commands;

import model.exceptions.MyExceptions;
import model.writer.Writable;
import presenter.Presenter;

import java.util.Scanner;

public class ConsoleUI implements View {
    private Scanner scanner;
    private Presenter presenter;
    private boolean work;
    private  MainMenu menu;

    public ConsoleUI() {
        scanner = new Scanner(System.in);
        presenter = new Presenter(this);
        work = true;
        menu = new MainMenu(this);
    }

    @Override
    public void start() throws MyExceptions {
        hello();
        while (work){
            printMenu();
            execute();
        }
    }

    @Override
    public void answer(String text) {
        System.out.println(text);
    }

    private void printMenu() {
        answer(menu.getMenu());
    }

    private void execute() throws MyExceptions {
        String input = scanner.nextLine();
        if (checkNumber(input)) {
            int numCommand = Integer.parseInt(input);
            if (checkCommand(numCommand)) {
                menu.execute(numCommand);
            }
        }
    }

    private boolean checkCommand(int numCommand) {
        if (numCommand <= menu.getSize()) {
            return true;
        } else {
            inputError();
            return false;
        }
    }

    private void inputError() {
        answer("Вы ввели некорректное значение. Введите целое число.");
    }

    private boolean checkNumber(String input) {
        if (input.matches("[0-9]+")){
            return true;
        } else {
            inputError();
            return false;
        }
    }

    public void setWritable (Writable writable) {
        presenter.setWritable(writable);
    }

    private void hello() {
        answer("Добро пожаловать!");
    }

    public void finish() {
        answer("Работа завершена. Всего доброго!");
        work = false;
        scanner.close();
    }

    public void addContact() throws MyExceptions {
        String text;
        answer("(\"Введите следующие данные через пробел в произвольном порядке: \" +\n" +
                "\"ФИО, дата рождения в формате ГГГГ.ММ.ДД, номер телефона, пол (m ");
        text = scanner.nextLine();
        presenter.addContact(text);
    }

    public void read() {
        presenter.read();
    }
}
