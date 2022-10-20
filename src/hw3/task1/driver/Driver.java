package hw3.task1.driver;


import hw3.task1.transport.Competing;
import hw3.task1.transport.Drivable;
import hw3.task1.transport.Transport;

public abstract class Driver<T extends Transport & Competing> implements Drivable {

    private final String name;
    private T transport;
    private String license;
    private int experience;

    private static final int DEFAULT_EXPERIENCE = 0;
    private static final String DEFAULT = "Информация отсутствует";

    private static final String NO_TRANSPORT = "Транспорт отсутствует!";

    public Driver(String name, T transport, int experience) {
        if (name != null && !name.isEmpty() && !name.isBlank()) {
            this.name = name;
        } else {
            this.name = DEFAULT;
        }
        setTransport(transport);
        setExperience(experience);
    }

    public Driver(String name, T transport) {
        this(name, transport, DEFAULT_EXPERIENCE);
    }

    public String getName() {
        return name;
    }

    public String getLicense() {
        return license;
    }

    protected void setLicense(String license) {
        this.license = license;
    }

    ;

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience > 0 && experience < 100 ? experience : DEFAULT_EXPERIENCE;
    }

    public T getTransport() {
        return transport;
    }

    public void setTransport(T transport) {
        if (transport != null) {
            this.transport = transport;
        } else {
            throw new NullPointerException();
        }
    }


    @Override
    public void start() {
        transport.start();
    }

    @Override
    public void stop() {
        transport.stop();
    }

    @Override
    public void refill() {
        transport.refill();
    }

    @Override
    public String toString() {
        return "driver.Driver{" +
                "name='" + name + '\'' +
                ", transport=" + transport +
                ", drivingLicense='" + license + '\'' +
                ", experience=" + experience +
                '}';
    }

    public void getInfo() {
        System.out.printf("Водитель %s с категорией прав %s управляет %s и будет участвовать в заезде\n",
                getName(),
                getLicense(),
                getTransport());
    }

}
