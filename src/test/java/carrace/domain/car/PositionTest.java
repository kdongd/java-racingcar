package carrace.domain.car;

import carrace.domain.Position;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PositionTest {

    @DisplayName("기본 생성 시 위치는 0이다 (경계값)")
    @Test
    void defaultPositionIsZero() {
        Position position = new Position();
        assertEquals(0, position.getValue());
    }

    @DisplayName("0으로 생성하면 정상이다 (경계값)")
    @Test
    void createWithZero() {
        Position position = new Position(0);
        assertEquals(0, position.getValue());
    }

    @DisplayName("음수로 생성하면 예외가 발생한다 (경계값)")
    @Test
    void negativeValueThrowsException() {
        assertThrows(IllegalArgumentException.class,
                () -> new Position(-1));
    }

    @DisplayName("moveForward는 기존 객체를 변경하지 않는다 (불변성)")
    @Test
    void moveForwardReturnsNewInstance() {
        Position position = new Position(2);
        Position moved = position.moveForward();

        assertEquals(3, moved.getValue());
        assertEquals(2, position.getValue());
    }
}

