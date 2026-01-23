import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PositionTest {

    @DisplayName("기본 생성자는 0으로 초기화")
    @Test
    void defaultConstructor() {
        Position pos = new Position();
        assertEquals(0, pos.getValue());
    }

    @DisplayName("생성자에 음수 입력 시 예외 발생")
    @Test
    void negativeValueThrows() {
        assertThrows(IllegalArgumentException.class, () -> new Position(-1));
    }

    @DisplayName("moveForward 호출 시 값 1 증가")
    @Test
    void moveForwardIncrements() {
        Position pos = new Position(2);
        Position moved = pos.moveForward();
        assertEquals(3, moved.getValue());
        assertEquals(2, pos.getValue(), "원래 객체는 불변이어야 함");
    }
}
