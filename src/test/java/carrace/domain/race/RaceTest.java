package carrace.domain.race;

import carrace.domain.Car;
import carrace.domain.Race;
import carrace.fixture.AlwaysMoveCondition;
import carrace.fixture.NeverMoveCondition;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RaceTest {

    @DisplayName("moveOnce 호출 시 모든 자동차가 이동한다")
    @Test
    void moveOnceMovesAllCars() {
        List<Car> cars = List.of(new Car(), new Car(), new Car());
        Race race = new Race(cars);

        race.moveOnce(new AlwaysMoveCondition());

        for (Car car : cars) {
            assertEquals(1, car.getPosition());
        }
    }

    @DisplayName("이동 조건이 false면 자동차는 이동하지 않는다")
    @Test
    void moveOnceDoesNotMoveWhenConditionFalse() {
        List<Car> cars = List.of(new Car(), new Car());
        Race race = new Race(cars);

        race.moveOnce(new NeverMoveCondition());

        for (Car car : cars) {
            assertEquals(0, car.getPosition());
        }
    }

    @DisplayName("자동차가 1대여도 정상 동작한다 (경계값)")
    @Test
    void raceWithSingleCar() {
        List<Car> cars = List.of(new Car());
        Race race = new Race(cars);

        race.moveOnce(new AlwaysMoveCondition());

        assertEquals(1, cars.get(0).getPosition());
    }

    @DisplayName("자동차가 0대여도 예외 없이 동작한다 (경계값)")
    @Test
    void raceWithNoCars() {
        Race race = new Race(List.of());

        assertDoesNotThrow(() ->
                race.moveOnce(new AlwaysMoveCondition()));
    }
}

