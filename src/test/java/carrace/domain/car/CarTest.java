package carrace.domain.car;

import carrace.fixture.MoveConditions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @Test
    @DisplayName("새 자동차는 기본 위치가 0")
    void newCar_defaultPosition_zero() {
        Car car = new Car();
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    @DisplayName("이동 조건 충족 시 항상 위치는 1 증가")
    void move_alwaysMove_incrementsPosition() {
        Car car = new Car();
        car.move(MoveConditions.alwaysMove());
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("이동하지 않는 조건에서 자동차 위치는 그대로다")
    void move_neverMove_positionUnchanged() {
        Car car = new Car();
        car.move(MoveConditions.neverMove());
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    @DisplayName("연속 이동 시 위치가 누적된다")
    void move_multipleTimes_positionAccumulates() {
        Car car = new Car();
        car.move(MoveConditions.alwaysMove());
        car.move(MoveConditions.alwaysMove());
        assertThat(car.getPosition()).isEqualTo(2);
    }
}
