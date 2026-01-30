package carrace.domain.car;


import java.util.ArrayList;
import java.util.List;

public class CarCreator {

    public static List<Car> create(String input) {
        String[] names = input.split(",");
        List<Car> cars = new ArrayList<>();

        for (int i = 0; i < names.length; i++) {
            String name = names[i].trim();
            cars.add(new Car(name));
        }
        return cars;
    }
}
