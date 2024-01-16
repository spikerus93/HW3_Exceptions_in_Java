package model;

import model.exceptions.MyExceptions;
import model.writer.Writable;

import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Service {
    List<String> personalInfo;
    Writable writable;
    
    public Service() {
        personalInfo = new ArrayList<>();
    }

    public void setWritable (Writable writable) {
        this.writable = writable;
    }

    public String addContact (String text) throws MyExceptions {
        setPersonalInfo(text);
        return save (createContact());
    }

    private String save(Contact contact) {
        try {
            writable.save(contact);
        } catch (MyExceptions e) {
            System.out.println(e.getMessage());
        }
        return contact.getInfo();
    }

    public void read() throws MyExceptions {
        File folder = new File("src/contacts/");
        File[] listFile = folder.listFiles();
        assert listFile != null;
        if (listFile.length != 0) {
            for (File file : listFile) {
                if (file.isFile()) {
                    try {
                        writable.read(file.getName());
                    } catch (MyExceptions e) {
                        System.out.println(e.getMessage());
                    }
                }
            }
        } else {
            throw new MyExceptions("Контакты отсутствуют.");
        }
    }

    private Contact createContact() throws MyExceptions {
        String lastName;
        String firstName;
        String middleName;
        LocalDate birthDate = getDate();
        long phoneNumber = getPhoneNumber();
        String gender = getGender();
        if (personalInfo.size() == 3) {
                lastName = getName("Фамилия");
                firstName = getName("Имя");
                middleName = getName("Отчество");
            } else {
            throw new MyExceptions("Данные не корректны!");
            }
        return new Contact(lastName, firstName, middleName, birthDate, phoneNumber, gender);
    }
    private void setPersonalInfo(String text) throws MyExceptions {
        String[] personalInfo = text.split(" ");
        if (checkLengthExceptions(checkInputLength(personalInfo))) {
            this.personalInfo = new ArrayList<>(List.of(personalInfo));
        } else {
            throw new MyExceptions("Повторите ввод");
        }
    }

    public int checkInputLength (String[] personalInfo) {
        return Integer.compare(personalInfo.length, 6);
    }

    public boolean checkLengthExceptions (int code) {
        if (code == -1) {
            System.out.println("Вы ввели недостаточно данных");
            return false;
        } else if (code == 1) {
            System.out.println("Вы ввели много информации.");
            return false;
        } else {
            return true;
        }
    }

    public LocalDate getDate() throws MyExceptions {
        LocalDate date = null;
        String str;
        for (int i = 0; i < personalInfo.size(); i++) {
            if (personalInfo.get(i).matches("[0-9].+[0-9].+[0-9]+")) {
                str = personalInfo.remove(i).replace(".","-");
                try {
                    date = LocalDate.parse(str);
                } catch (Exception e) {
                    throw new MyExceptions("Вы ввели некорректную дату");
                }
            }
        }
        return date;
    }

    public long getPhoneNumber() {
        long phoneNumber = 0;
        for (int i = 0; i < personalInfo.size(); i++) {
            if (personalInfo.get(i).matches("[0-9]+")) {
            phoneNumber = Long.parseLong(personalInfo.remove(i));
        }
    }
        return phoneNumber;
    }

    public String getGender() throws MyExceptions {
        String gender = null;
        for (int i = 0; i < personalInfo.size(); i++) {
            if (personalInfo.get(i).length() == 1){
                if (personalInfo.get(i).equals("m") | personalInfo.get(i).equals("f")) {
                    gender = personalInfo.remove(i);
                } else {
                    throw new MyExceptions("Пол введен некорретно.");
                }
            }
        }
        return gender;
    }

    public boolean checkIfText (String text) {
        return text.matches("\\D+");
    }

    public String getName (String message) {
        String name;
        if (checkIfText(personalInfo.get(0))) {
            name = personalInfo.remove(0);
        } else {
            throw new RuntimeException(message+ "ошибка ввода данных!");
        }
        return name;
    }
}
