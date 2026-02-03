package carrace.domain.car;


import carrace.domain.move.MoveCondition;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        validate(cars);
        this.cars = cars;
    }

    public static Cars from(String input) {
        String[] names = input.split(",");
        List<Car> cars = new ArrayList<>();

        for (String name : names) {
            cars.add(new Car(name.trim()));
        }
        return new Cars(cars);
    }

    private void validate(List<Car> cars) {
        if (cars.isEmpty()) {
            throw new IllegalArgumentException("자동차는 최소 1대 이상이어여 합니다.");
        }
        validateDuplicateNames(cars);
    }

    private void validateDuplicateNames(List<Car> cars) {
        Set<String> names = new HashSet<>();
        for (Car car : cars) {
            if (!names.add(car.getCarName())) {
                throw new IllegalArgumentException("자동차 이름은 중복될 수 없습니다.");
            }
        }
    }

    public void moveAll(MoveCondition condition) {
        cars.forEach(car -> car.move(condition));
    }

    public List<Car> getWinners() {
        int max = 0;
        for (Car car : cars) {
            max = Math.max(max, car.getPosition());
        }

        List<Car> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() == max) {
                winners.add(car);
            }
        }
        return winners;
    }

    public List<Car> asList() {
        return List.copyOf(cars);
    }

}
