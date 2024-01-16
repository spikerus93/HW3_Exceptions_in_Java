package model;

import java.io.Serializable;
import java.time.LocalDate;

public class Contact implements Serializable {
    private String lastName;
    private String firstName;
    private String middleName;
    private LocalDate birthDate;
    private long phoneNumber;
    private String gender;

    public String getLastName(String lastName) {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName(String firstName) {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName(String middleName) {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = LocalDate.parse(birthDate);
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getInfo() {
        StringBuilder getInfo = new StringBuilder();
        getInfo.append("ФИО: ");
        getInfo.append(lastName);
        getInfo.append(" ");
        getInfo.append(firstName);
        getInfo.append(" ");
        getInfo.append(middleName);
        getInfo.append("Дата Рождения: ");
        getInfo.append(birthDate);
        getInfo.append("Номер телефона: ");
        getInfo.append(phoneNumber);
        getInfo.append("Пол: ");
        getInfo.append(gender);
        return getInfo.toString();
    }

    @Override public String toString() {
        return getInfo();
    }
    public Contact(String lastName, String firstName, String middleName, LocalDate birthDate, long phoneNumber, String gender) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.birthDate = birthDate;
        this.phoneNumber = phoneNumber;
        this.gender = gender;

    }
}
