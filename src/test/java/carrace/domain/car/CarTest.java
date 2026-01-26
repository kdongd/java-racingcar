package carrace.domain.car;

import carrace.domain.Car;
import carrace.domain.MoveCondition;
import carrace.fixture.AlwaysMoveCondition;
import carrace.fixture.NeverMoveCondition;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    @DisplayName("이동 조건이 true면 위치가 1 증가한다")
    @Test
    void move_whenConditionTrue() {
        Car car = new Car();
        car.move((MoveCondition) new AlwaysMoveCondition());
        assertEquals(1, car.getPosition());
    }

    @DisplayName("이동 조건이 false면 위치가 증가하지 않는다")
    @Test
    void move_whenConditionFalse() {
        Car car = new Car();
        car.move((MoveCondition) new NeverMoveCondition());
        assertEquals(0, car.getPosition());
    }
}

