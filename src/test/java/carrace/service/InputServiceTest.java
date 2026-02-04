package carrace.service;

import carrace.fixture.StubInputView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InputServiceTest {

    @DisplayName("시도 횟수가 음수면 예외 발생 (경계값)")
    @Test
    void roundsNegativeThrows() {
        InputService service = new InputService(new StubInputView("3", "-1"));
        assertThrows(IllegalArgumentException.class, service::readRounds);
    }

    @Test
    @DisplayName("자동차 이름 공백시 예외 발생")
    void carNameBlankThrows() {
        StubInputView inputView = new StubInputView(" , , ", "3");
        InputService service = new InputService(inputView);

        assertThrows(IllegalArgumentException.class, service::readCarNames);
    }
}
