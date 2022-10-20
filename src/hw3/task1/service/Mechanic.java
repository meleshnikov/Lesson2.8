package hw3.task1.service;


import hw3.task1.transport.Transport;

public class Mechanic<T extends Transport> {

    private final String name;
    private final String surname;
    private String company = "";

    public Mechanic(String name, String surname, String company) {
        if (name != null && !name.isEmpty() && !name.isBlank()) {
            this.name = name;
        } else {
            throw new IllegalArgumentException("Имя не указано");
        }

        if (surname != null && !surname.isEmpty() && !surname.isBlank()) {
            this.surname = surname;
        } else {
            throw new IllegalArgumentException("Фамилия не указана");
        }

        setCompany(company);

    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        if (company != null && !company.isEmpty() && !company.isBlank()) {
            this.company = company;
        } else {
            throw new IllegalArgumentException("Компания не указана");
        }
    }

    public void service(T transport) {
        if (transport.diag()) {
            System.out.printf("%s прошел ТО (%s)\n", transport, this);
        } else {
            System.out.printf("%s не прошел ТО. Необходим ремонт (%s)\n", transport, this);
        }
    }

    public void repair(T transport) {
        System.out.printf("%s починен (%s)\n",
                transport,
                this);
    }

    @Override
    public String toString() {
        return String.format("%s %s - %s", getName(), getSurname(), getCompany());
    }
}
