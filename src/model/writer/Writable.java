package model.writer;

import model.Contact;
import model.exceptions.MyExceptions;

import java.io.Serializable;

public interface Writable extends Serializable {
    void save (Contact contact) throws MyExceptions;
    void read (String fileName) throws MyExceptions;
}
