package hw3.task1.transport;

public class Truck extends Transport implements Competing {

    private Load loadCapacity;
    private static final String TRUCK = "Грузовой автомобиль: ";

    public Truck(String brand, String model, double engineVolume) {
        super(brand, model, engineVolume);
        this.loadCapacity = Load.N1;
    }

    public Truck(String brand, String model) {
        super(brand, model);
        this.loadCapacity = Load.N1;
    }

    public Truck(String brand) {
        super(brand);
        this.loadCapacity = Load.N1;
    }

    public Truck() {
        this.loadCapacity = Load.N1;
    }


    public Load getLoadCapacity() {
        return loadCapacity;
    }

    public void setLoadCapacity(Load loadCapacity) {
        this.loadCapacity = loadCapacity;
    }

    @Override
    public void start() {
        System.out.println(TRUCK + getBrand() + " " + getModel() + " начал движение!");
    }

    @Override
    public void stop() {
        System.out.println(TRUCK + getBrand() + " " + getModel() + " закончил движение!");
    }

    @Override
    public void refill() {
        System.out.println("Грузовик заправляется дизелем ...");
    }

    @Override
    public void pitStop() {
        System.out.println("Грузовик. Пит-стоп!");
    }

    @Override
    public void bestLapTime() {
        System.out.println("Лучшее время круга для грузовика: ");
    }

    @Override
    public void maxSpeed() {
        System.out.println("максимальная скорость авто: ");
    }

    @Override
    public void printType() {
        if (loadCapacity != null) {
            System.out.printf("Грузоподъёмность: от %.1f до %.1f тон\n",
                    getLoadCapacity().from,
                    getLoadCapacity().to);
        } else {
            System.out.println("Данных по грузовику недостаточно");
        }

    }

    @Override
    public boolean diag() {
        return Math.random() > 0.5;
    }

    public enum Load {
        N1(0, 3.5),
        N2(3.5, 12),
        N3(12, 40);

        private double from;
        private double to;

        Load(double from, double to) {
            this.from = from;
            this.to = to;
        }

        public double getFrom() {
            return from;
        }

        public double getTo() {
            return to;
        }

        public void setFrom(double from) {
            this.from = from;
        }

        public void setTo(double to) {
            this.to = to;
        }
    }
}
