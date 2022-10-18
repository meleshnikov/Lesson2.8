package hw3.task3;

import java.util.HashMap;
import java.util.Map;

public class PassportOffice {

    private final Map<Integer, Passport> passports = new HashMap<>();

    public Map<Integer, Passport> getPassports() {
        return passports;
    }

    public void add(Passport passport) {
        int key = passport.getId();
        if (!passports.containsKey(key)) {
            passports.put(key, passport);
        } else {
            System.out.println(passport + " уже есть в базе");
            passport.update();
        }
    }

    public Passport find(int id) {
        return passports.get(id);
    }

    @Override
    public String toString() {
        return getPassports().toString();
    }
}
