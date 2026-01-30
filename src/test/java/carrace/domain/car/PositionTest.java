package carrace.domain.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

public class PositionTest {

    @Test
    @DisplayName("기본 생성 시 위치는 0")
    void defaultPositionIsZero() {
        Position position = new Position();
        assertThat(position.getValue()).isEqualTo(0);
    }

    @Test
    @DisplayName("음수로 생성하면 예외 발생")
    void negativeValueThrowsException() {
        Position position = new Position();
        assertThrows(IllegalArgumentException.class,() -> new Position(-1));
    }

    @Test
    @DisplayName("MoveForward는 기존 객체를 변경하지 않는다")
    void moveForwardReturnsNewInstance() {
        Position position = new Position(2);
        Position moved = position.moveForward();

        assertEquals(3,moved.getValue());
        assertEquals(2,position.getValue());
    }


}
