package hw3.task1.transport;

public class Car extends Transport implements Competing, Drivable {

    private final Body body;
    private static final String CAR = "Легковой автомобиль: ";
    private static final Body DEFAULT_BODY = Body.SEDAN;

    public Car(String brand, String model, double engineVolume, Body body) {
        super(brand, model, engineVolume);
        this.body = body;
    }

    public Car(String brand, String model, double engineVolume) {
        super(brand, model, engineVolume);
        this.body = DEFAULT_BODY;
    }

    public Car(String brand, String model) {
        super(brand, model);
        this.body = DEFAULT_BODY;
    }

    public Car(String brand) {
        super(brand);
        this.body = DEFAULT_BODY;
    }

    public Car() {
        this.body = DEFAULT_BODY;
    }

    public Body getBody() {
        return body;
    }

    @Override
    public void start() {
        System.out.println(CAR + getBrand() + " " + getModel() + " начал движение!");
    }

    @Override
    public void stop() {
        System.out.println(CAR + getBrand() + " " + getModel() + " закончил движение!");
    }

    @Override
    public void refill() {
        System.out.println("Авто заправляется бензином ...");
    }

    @Override
    public void pitStop() {
        System.out.println("Автомобиль. Пит-стоп!");
    }

    @Override
    public void bestLapTime() {
        System.out.println("Лучшее время круга для авто: ");
    }

    @Override
    public void maxSpeed() {
        System.out.println("максимальная скорость авто: ");

    }

    @Override
    public String toString() {
        return super.toString() + " " + body.getTranscript();
    }

    @Override
    public void printType() {
        if (body != null) {
            System.out.println("тип кузова: " + getBody().getTranscript());
        } else {
            System.out.println("Данных по авто недостаточно");
        }
    }

    @Override
    public boolean diag() {
        return Math.random() < 0.8;
    }

    public enum Body {
        SEDAN("Седан"),
        HATCHBACK("Хэтчбек"),
        COUPE("Купе"),
        WAGON("Универсал"),
        SUV("Внедорожник"),
        CROSSOVER("Кроссовер"),
        PICKUP("Пикап"),
        VAN("Фургон"),
        MINIVAN("Минивэн");

        private final String transcript;

        Body(String name) {
            this.transcript = name;
        }

        public String getTranscript() {
            return transcript;
        }

    }


}
