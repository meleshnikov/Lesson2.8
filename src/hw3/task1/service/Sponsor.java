package hw3.task1.service;


import hw3.task1.transport.Transport;

import java.util.Set;

public class Sponsor {

    private final String name;

    private double balance;

    private static final double DEFAULT_BALANCE = 100_000.0;

    public Sponsor(String name, double balance) {

        if (name != null && !name.isEmpty() && !name.isBlank()) {
            this.name = name;
        } else {
            throw new IllegalArgumentException("Имя не указано");
        }

        if (balance < 0) {
            throw new IllegalArgumentException("Деньги не могут иметь отрицательное значение");
        }
        this.balance = balance;
    }

    public Sponsor(String name) {
        this(name, DEFAULT_BALANCE);
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        if (balance < 0) {
            throw new IllegalArgumentException("Деньги не могут иметь отрицательное значение");
        }
        this.balance = balance;
    }

    public void donate(double donation, Transport transport) {

        if (donation < 0) {
            throw new IllegalArgumentException("Деньги не могут иметь отрицательное значение");
        }

        if ((balance - donation) < 0) {
            System.out.printf("Спонсор %s - недостаточно средств!\n", getName());
            return;
        }

        if (!transport.getSponsors().contains(this)) {
            transport.getSponsors().add(this);
        }
        transport.setDonatesSum(transport.getDonatesSum() + donation);
        this.balance -= donation;

        System.out.printf("Спонсор %s выделил %.1f руб. Транспорт - %s\n",
                getName(),
                donation,
                transport);
    }

    public void donate(double donation, Transport... transports) {
        for (Transport vehicle : transports) {
            donate(donation, vehicle);
        }
    }

    public void donate(double donation, Set<Transport> transports) {
        for (Transport vehicle : transports) {
            donate(donation, vehicle);
        }
    }


    @Override
    public String toString() {
        return getName();
    }
}
