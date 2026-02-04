package carrace.service;

import carrace.view.CarRaceInputView;

public class InputService {

    private final CarRaceInputView inputView;

    public InputService(CarRaceInputView inputView) {
        this.inputView = inputView;
    }

    public String readCarNames() {
        String input = inputView.readCarNames();
        validateCarNames(input);
        return input;
    }

    public int readRounds() {
        int value = parseInt(inputView.readMoveCount());

        if (value <= 0) {
            throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
        }
        return value;
    }

    private int parseInt(String input) {
        return Integer.parseInt(input);
    }

    private void validateCarNames(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("자동차 이름을 입력하세요");
        }

        String[] names = input.split(",");
        for (String name : names) {
            if (name.trim().isBlank()) {
                throw new IllegalArgumentException("자동차 이름은 공백일 수 없습니다.");
            }
        }
    }
}
