package hw3.task1.driver;


import hw3.task1.transport.Car;

public class DriverB extends Driver<Car> {
    public DriverB(String name, Car transport, int experience) {
        super(name, transport, experience);
        setLicense("B");
    }

    public DriverB(String name, Car transport) {
        super(name, transport);
        setLicense("B");
    }

}
