package view.commands;

import model.exceptions.MyExceptions;

public interface View {
    void start() throws MyExceptions;

    void answer(String text);
}