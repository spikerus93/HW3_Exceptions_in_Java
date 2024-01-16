package model.writer;

import model.Contact;
import model.exceptions.MyExceptions;

import java.io.*;

public class FileHandler implements Writable{
    @Override
    public void save(Contact contact) throws MyExceptions {
        String filePath = "src/contacts/" + contact.getLastName() + ".txt";
        File file = new File(filePath);
        try (FileWriter writer = new FileWriter(file, true)) {
            if (file.length() > 0) {
                writer.write("\n");
            }
            writer.write(contact.toString());
        } catch (IOException e) {
            throw new MyExceptions("Ошибка записи в файл.");
        }
    }

    @Override
    public void read(String fileName) throws MyExceptions {
        String filePath = "src/contacts/" + fileName;
        File file = new File(filePath);
        try (BufferedReader reader = new BufferedReader(new FileReader(file))){
            String line = reader.readLine();
            while (line != null) {
                System.out.println(line);
                line = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            throw new MyExceptions("Файл не найден");
        } catch (IOException e) {
            throw new MyExceptions("Ошибка чтения из файла");
        }
    }
}
