import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InputServiceTest {

    private static class StubInputView extends CarRaceInputView {
        private final String carCount;
        private final String rounds;

        public StubInputView(String carCount, String rounds) {
            this.carCount = carCount;
            this.rounds = rounds;
        }

        @Override
        public String readCarCount() { return carCount; }

        @Override
        public String readMoveCount() { return rounds; }
    }

    private final IntParser parser = new IntParser();

    @DisplayName("자동차 수 0 이하 입력 시 예외 발생")
    @Test
    void carCountZeroThrows() {
        InputService service = new InputService(new StubInputView("0", "5"), parser);
        assertThrows(IllegalArgumentException.class, service::readCarCount);
    }

    @DisplayName("시도 횟수 0 이하 입력 시 예외 발생")
    @Test
    void roundsZeroThrows() {
        InputService service = new InputService(new StubInputView("3", "0"), parser);
        assertThrows(IllegalArgumentException.class, service::readRounds);
    }

    @DisplayName("정상 입력 시 값 반환")
    @Test
    void validInputReturnsValue() {
        InputService service = new InputService(new StubInputView("3", "5"), parser);
        assertEquals(3, service.readCarCount());
        assertEquals(5, service.readRounds());
    }
}

