package carrace.domain.car;

import carrace.fixture.MoveConditions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class CarTest {

    @Test
    @DisplayName("새 자동차는 기본 위치가 0")
    void newCar_defaultPosition_zero() {
        Car car = new Car("kdu");
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    @DisplayName("이동 조건 충족 시 항상 위치는 1 증가")
    void move_alwaysMove_incrementsPosition() {
        Car car = new Car("kdu");
        car.move(MoveConditions.alwaysMove());
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("이동하지 않는 조건에서 자동차 위치는 그대로다")
    void move_neverMove_positionUnchanged() {
        Car car = new Car("kdu");
        car.move(MoveConditions.neverMove());
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    @DisplayName("연속 이동 시 위치가 누적된다")
    void move_multipleTimes_positionAccumulates() {
        Car car = new Car("kdu");
        car.move(MoveConditions.alwaysMove());
        car.move(MoveConditions.alwaysMove());
        assertThat(car.getPosition()).isEqualTo(2);
    }

    @Test
    @DisplayName("자동차는 이름을 가진다")
    void car_has_name() {
        Car car = new Car("kdu");
        assertThat(car.getCarName()).isEqualTo("kdu");
    }

    @Test
    @DisplayName("이름이 5글자 초과면 예외")
    void name_too_long_throws() {
        assertThatThrownBy(() -> new Car("abcdef"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("이름이 null 이면 예외")
    void name_null_throws() {
        assertThatThrownBy(() -> new Car(null))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("이름이 공백이면 예외")
    void name_blank_throws() {
        assertThatThrownBy(() -> new Car("  "))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
