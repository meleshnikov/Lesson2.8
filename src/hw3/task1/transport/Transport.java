package hw3.task1.transport;

import hw3.task1.service.Mechanic;
import hw3.task1.service.Sponsor;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public abstract class Transport implements Drivable {
    private String brand;
    private String model;
    private double engineVolume;

    private final Set<Sponsor> sponsors = new HashSet<>();
    private final Set<Mechanic<?>> mechanics = new HashSet<>();

    private double donatesSum;

    private static final String DEFAULT = "default";
    private static final double DEFAULT_ENGINE = 0.0;

    public Transport(String brand, String model, double engineVolume) {
        setBrand(brand);
        setModel(model);
        setEngineVolume(engineVolume);
    }

    public Transport(String brand, String model) {
        this(brand, model, DEFAULT_ENGINE);
    }

    public Transport(String brand) {
        this(brand, DEFAULT);
    }

    public Transport() {
        this(DEFAULT);
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public double getEngineVolume() {
        return engineVolume;
    }

    public Set<Sponsor> getSponsors() {
        return sponsors;
    }

    public double getDonatesSum() {
        return donatesSum;
    }

    public Set<Mechanic<?>> getMechanics() {
        return mechanics;
    }

    public void setBrand(String brand) {
        this.brand = isValid(brand) ? brand : DEFAULT;
    }

    public void setModel(String model) {
        this.model = isValid(model) ? model : DEFAULT;
    }

    public void setEngineVolume(double engineVolume) {
        this.engineVolume = engineVolume > 0 && engineVolume < 20 ? engineVolume : DEFAULT_ENGINE;
    }

    public void setDonatesSum(double donatesSum) {
        this.donatesSum = donatesSum;
    }

    @Override
    public String toString() {
        return getBrand() + " " + getModel();
    }

    public abstract void printType();

    public abstract boolean diag();

    public void addMechanic(Mechanic<?> mechanic) {
        mechanics.add(mechanic);
    }

    public void addMechanic(Mechanic<?>... mechanics) {
        Collections.addAll(this.mechanics, mechanics);
    }


    protected static boolean isValid(String field) {
        return field != null && !field.isEmpty() && !field.isBlank();
    }

}
