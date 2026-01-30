package carrace.service;

import carrace.fixture.StubInputView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InputServiceTest {

    @DisplayName("자동차 수가 1이면 정상 입력 (경계값)")
    @Test
    void carCountOneIsValid() {
        InputService service = new InputService(new StubInputView("1", "5"));
        assertEquals(1, service.readCarCount());
    }

    @DisplayName("자동차 수가 0이면 예외 발생 (경계값)")
    @Test
    void carCountZeroThrows() {
        InputService service = new InputService(new StubInputView("0", "5"));
        assertThrows(IllegalArgumentException.class, service::readCarCount);
    }

    @DisplayName("시도 횟수가 음수면 예외 발생 (경계값)")
    @Test
    void roundsNegativeThrows() {
        InputService service = new InputService(new StubInputView("3", "-1"));
        assertThrows(IllegalArgumentException.class, service::readRounds);
    }

    @Test
    @DisplayName("자동차 이름이 5글자 초과이면 예외 발생")
    void carNameTooLongThrows() {
        StubInputView inputView = new StubInputView("TOOLONG","3");
        InputService service = new InputService(inputView);

        assertThrows(IllegalArgumentException.class, service::readCarNames);
    }

    @Test
    @DisplayName("자동차 이름 공백시 예외 발생")
    void carNameBlankThrows() {
        StubInputView inputView = new StubInputView(" , , ", "3");
        InputService service = new InputService(inputView);

        assertThrows(IllegalArgumentException.class, service::readCarNames);
    }
}
