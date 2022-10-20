package hw3.task1.driver;


import hw3.task1.transport.Bus;

public class DriverD extends Driver<Bus> {

    public DriverD(String name, Bus transport, int experience) {
        super(name, transport, experience);
        setLicense("D");
    }

    public DriverD(String name, Bus transport) {
        super(name, transport);
        setLicense("D");
    }
}
