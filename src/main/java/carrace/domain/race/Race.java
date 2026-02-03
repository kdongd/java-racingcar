package carrace.domain.race;

import carrace.domain.car.Car;
import carrace.domain.car.Cars;
import carrace.domain.move.MoveCondition;


import java.util.List;

public class Race {

    private final Cars cars;

    public Race(Cars cars) {
        this.cars = cars;
    }

    public void moveOnce(MoveCondition condition) {
        cars.moveAll(condition);
    }

    public List<Car> getCars() {
        return cars.asList();
    }

    public List<Car> getWinners() {
        return cars.getWinners();
    }
}
