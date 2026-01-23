import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    private static class AlwaysMoveCondition implements MoveCondition {
        @Override
        public boolean canMove() { return true; }
    }

    private static class NeverMoveCondition implements MoveCondition {
        @Override
        public boolean canMove() { return false; }
    }

    @DisplayName("이동 조건이 true면 Car 위치 증가")
    @Test
    void moveWhenConditionTrue() {
        Car car = new Car();
        car.move(new AlwaysMoveCondition());
        assertEquals(1, car.getPosition());
    }

    @DisplayName("이동 조건이 false면 Car 위치 유지")
    @Test
    void moveWhenConditionFalse() {
        Car car = new Car();
        car.move(new NeverMoveCondition());
        assertEquals(0, car.getPosition());
    }
}

