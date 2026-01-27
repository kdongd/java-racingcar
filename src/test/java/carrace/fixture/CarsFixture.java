package carrace.fixture;

import carrace.domain.car.Car;

import java.util.List;

public class CarsFixture {

    public static List<Car> threeCars() {
        return List.of(
                new Car("car1"),
                new Car("car2"),
                new Car("car3")
        );
    }


}

