package hw3.task3;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Passport {

    private static int nextId;

    private final int id;

    private String name;
    private String middleName;
    private String lastName;
    private LocalDate dateOfBirth;

    public Passport(String name, String middleName, String lastName, LocalDate dateOfBirth) {
        this.id = ++nextId;
        setName(name);
        setMiddleName(middleName);
        setLastName(lastName);
        setDateOfBirth(dateOfBirth);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name != null && !name.isEmpty() && !name.isBlank()) {
            this.name = name;
        } else {
            throw new IllegalArgumentException("invalid product's name");
        }
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (lastName != null && !lastName.isEmpty() && !lastName.isBlank()) {
            this.lastName = lastName;
        } else {
            throw new IllegalArgumentException("invalid lastname");
        }
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        if (dateOfBirth != null && dateOfBirth.isBefore(LocalDate.now().minusYears(14))) {
            this.dateOfBirth = dateOfBirth;
        } else {
            throw new IllegalArgumentException("invalid date of birthday");
        }
    }

    public void update() {
        this.name += "+";
        this.middleName += "+";
        this.lastName += "+";
        this.dateOfBirth = LocalDate.now();
    }

    @Override
    public String toString() {
        return String.format("Номер паспорта: %d| %s %s %s| %s",
                getId(),
                getLastName(),
                getName(),
                getMiddleName(),
                getDateOfBirth().format(DateTimeFormatter.ofPattern("dd LLLL yyyy")));
    }
}
