import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RaceTest {

    private static class AlwaysMoveCondition implements MoveCondition {
        @Override
        public boolean canMove() { return true; }
    }

    @DisplayName("Race moveOnce 호출 시 모든 자동차 이동")
    @Test
    void moveOnceMovesAllCars() {
        List<Car> cars = List.of(new Car(), new Car(), new Car());
        Race race = new Race(cars);

        race.moveOnce(new AlwaysMoveCondition());

        for (Car car : cars) {
            assertEquals(1, car.getPosition());
        }
    }
}

