package hw3.task1;



import hw3.task1.driver.Driver;
import hw3.task1.driver.DriverB;
import hw3.task1.driver.DriverC;
import hw3.task1.driver.DriverD;
import hw3.task1.service.Mechanic;
import hw3.task1.service.Sponsor;
import hw3.task1.transport.Bus;
import hw3.task1.transport.Car;
import hw3.task1.transport.Transport;
import hw3.task1.transport.Truck;

import java.util.HashSet;
import java.util.Set;

public class Main {

    private static final Set<Transport> vehicles = new HashSet<>();
    private static final Set<Driver<?>> drivers = new HashSet<>();

    private static final Set<Sponsor> sponsors = new HashSet<>();


    public static void main(String[] args) {

        fillVehicles();
        fillSponsors();
        fillDrivers();
        testDrivers();
        testSponsors();
        testMechanic();
    }

    private static void fillVehicles() {

        vehicles.add(new Car("ВАЗ", "21099", 1.5));
        vehicles.add(new Car("Toyota", "Camry", 3.5));
        vehicles.add(new Car("BMW", "X5", 3, Car.Body.CROSSOVER));

        vehicles.add(new Truck("Камаз", "65115-48", 6.7));
        vehicles.add(new Truck("MAN", "TGX"));
        vehicles.add(new Truck("ЗИЛ", "4314", 6));
        vehicles.add(new Truck("Volvo"));

        vehicles.add(new Bus("ЛиАЗ", "5256", 8));
        vehicles.add(new Bus("ПАЗ", "3206", 7.5));
        vehicles.add(new Bus("Hyundai", "Universe"));
        vehicles.add(new Bus("Volvo", "9500"));
    }

    private static void fillSponsors() {
        sponsors.add(new Sponsor("Петр Иванович", 5_000_000));
        sponsors.add(new Sponsor("Газпром", 3_000_000));
        sponsors.add(new Sponsor("Андрей Михайлович", 500_000));
    }


    private static void fillDrivers() {
        Car mercedes = new Car("Mercedes", "GLC");
        Truck kamaz = new Truck("Камаз", "43118");
        Bus icarus = new Bus("Икарус", "250");
        drivers.add(new DriverB("Иванов Иван Иванович", mercedes));
        drivers.add(new DriverC("Василий Васильевич Васильев", kamaz));
        drivers.add(new DriverD("Петр Петрович Петренко", icarus));
        drivers.add(new DriverD("Петр Петрович Петренко", icarus));
    }

    private static void testDrivers() {
        System.out.println(drivers);
    }

    private static void testSponsors() {
        for (Sponsor sponsor : sponsors) {
            sponsor.donate(Math.random() * 100_000, vehicles);
        }

        for (Transport vehicle : vehicles) {
            System.out.println(vehicle);
            System.out.println(vehicle.getSponsors());
        }
    }

    private static void testMechanic() {
        Mechanic<Car> oleg = new Mechanic<>("Олег", "Олегов", "Авто49");
        Mechanic<Transport> alex = new Mechanic<>("Алексей", "Алексеев", "Helix");
        for (Transport vehicle : vehicles) {
            if (vehicle instanceof Car) {
                oleg.service((Car) vehicle);
                oleg.repair((Car) vehicle);
            }
            alex.service(vehicle);
            alex.repair(vehicle);
        }
    }

}