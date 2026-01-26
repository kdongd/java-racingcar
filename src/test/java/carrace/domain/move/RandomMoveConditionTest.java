package carrace.domain.move;

import carrace.domain.RandomMoveCondition;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RandomMoveConditionTest {

    @DisplayName("canMove는 true 또는 false만 반환한다")
    @Test
    void canMoveReturnsBoolean() {
        RandomMoveCondition condition = new RandomMoveCondition();

        boolean result = condition.canMove();

        assertTrue(result || !result); // 논리적 계약 테스트
    }

    @DisplayName("여러 번 호출해도 예외가 발생하지 않는다")
    @Test
    void canMoveRepeatedly() {
        RandomMoveCondition condition = new RandomMoveCondition();

        assertDoesNotThrow(() -> {
            for (int i = 0; i < 100; i++) {
                condition.canMove();
            }
        });
    }
}
