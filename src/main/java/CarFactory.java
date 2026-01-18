public class CarFactory {
    public static Car[] create(int count) {
        Car[] cars = new Car[count];
        for (int i = 0; i < count; i++) {
            cars[i] = new Car();
        }
        return cars;
    }
}
