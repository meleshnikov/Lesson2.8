package hw3.task1.driver;


import hw3.task1.transport.Truck;

public class DriverC extends Driver<Truck> {
    public DriverC(String name, Truck transport, int experience) {
        super(name, transport, experience);
        setLicense("C");
    }

    public DriverC(String name, Truck transport) {
        super(name, transport);
        setLicense("C");
    }
}
