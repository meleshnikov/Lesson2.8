package hw3.task1.transport;

public class Bus extends Transport implements Competing {

    private Capacity capacity;
    private static final String BUS = "Автобус: ";

    public Bus(String brand, String model, double engineVolume) {
        super(brand, model, engineVolume);
        this.capacity = Capacity.MEDIUM;
    }

    public Bus(String brand, String model) {
        super(brand, model);
        this.capacity = Capacity.MEDIUM;
    }

    public Bus(String brand) {
        super(brand);
        this.capacity = Capacity.MEDIUM;
    }

    public Bus() {
        this.capacity = Capacity.MEDIUM;
    }

    public Capacity getCapacity() {
        return capacity;
    }

    public void setCapacity(Capacity capacity) {
        this.capacity = capacity;
    }

    @Override
    public void start() {
        System.out.println(BUS + getBrand() + " " + getModel() + " начал движение!");
    }

    @Override
    public void stop() {
        System.out.println(BUS + getBrand() + " " + getModel() + " закончил движение!");
    }

    @Override
    public void refill() {
        System.out.println("Автобус заправляется соляркой ...");
    }

    @Override
    public void pitStop() {
        System.out.println("Автобус. Пит-стоп!");
    }

    @Override
    public void bestLapTime() {
        System.out.println("Лучшее время круга для автобуса: ");
    }

    @Override
    public void maxSpeed() {
        System.out.println("максимальная скорость автобуса: ");
    }

    @Override
    public void printType() {
        if (capacity != null) {
            System.out.printf("Вместимость: от %d до %d мест\n",
                    getCapacity().from,
                    getCapacity().to);
        } else {
            System.out.println("Данных по автобусу недостаточно");
        }
    }

    @Override
    public boolean diag() {
        return Math.random() < 0.9;
        //throw new UnsupportedOperationException("Автобусы» диагностику проходить не могут");
    }

    public enum Capacity {
        EXTRA_SMALL(0, 10),
        SMALL(10, 25),
        MEDIUM(40, 50),
        LARGE(60, 80),
        EXTRA_LARGE(100, 120);

        private int from;
        private int to;

        Capacity(int from, int to) {
            this.from = from;
            this.to = to;
        }

        public int getFrom() {
            return from;
        }

        public int getTo() {
            return to;
        }

        public void setFrom(int from) {
            this.from = from;
        }

        public void setTo(int to) {
            this.to = to;
        }
    }

}
