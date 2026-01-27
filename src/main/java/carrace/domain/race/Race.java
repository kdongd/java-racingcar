package carrace.domain.race;

import carrace.domain.car.Car;
import carrace.domain.move.MoveCondition;

import java.util.ArrayList;
import java.util.List;

public class Race {

    private final List<Car> cars;

    public Race(List<Car> cars) {
        this.cars = cars;
    }

    public void moveOnce(MoveCondition condition) {
        for (Car car : cars) {
            car.move(condition);
        }
    }

    public List<Car> getWinners() {
        int maxPosition = 0;

        for (Car car : cars) {
            if (car.getPosition() > maxPosition) {
                maxPosition = car.getPosition();
            }
        }

        List<Car> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car);
            }
        }
        return winners;
    }

    //내부 상태 보호를 위해 자동차 목록을 그대로 반환하지 않고
    //읽기 전용 리스트(unmodifiableList)를 반환하도록 수정했습니다.
    public List<Car> getCars() {
        return List.copyOf(cars);
    }


}
