package carrace.fixture;

import carrace.domain.car.Car;
import carrace.domain.car.CarCreator;

import java.util.List;

public class CarsFixture {

    // 자동차 3대를 만드는 Fixture
    public static List<Car> threeCars() {
        return CarCreator.create(3);
    }

    // 자동차 n대를 만드는 Fixture
    public static List<Car> nCars(int n) {
        return CarCreator.create(n);
    }
}
