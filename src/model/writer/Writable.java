package model.writer;

import model.Contact;
import model.exceptions.MyExceptions;

import java.io.IOException;

public interface Writable {
    void save (Contact contact) throws IOException, MyExceptions;
    void read (String fileName) throws MyExceptions;
}
