package hw3.task3;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Passport ivan = new Passport(
                "Иван",
                "Иванович",
                "Иванов",
                LocalDate.of(1995, 8, 12));
        Passport petr = new Passport(
                "Петр",
                "Петрович",
                "Петров",
                LocalDate.of(1997, 4, 20));
        PassportOffice passports = new PassportOffice();
        passports.add(ivan);
        passports.add(petr);
        System.out.println(passports);
        System.out.println(passports.find(2));
        System.out.println(passports.find(10));
        passports.add(ivan);
        System.out.println(passports);
    }
}
