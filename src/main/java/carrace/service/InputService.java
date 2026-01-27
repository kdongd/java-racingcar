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

    public int readCarCount() {
        int value = parseInt(
                inputView.readCarCount(),
                "자동차 대수는 숫자여야 합니다."
        );

        if (value <= 0) {
            throw new IllegalArgumentException("자동차는 1대 이상이어야 합니다.");
        }
        return value;
    }

    public int readRounds() {
        int value = parseInt(
                inputView.readMoveCount(),
                "시도 횟수는 숫자여야 합니다."
        );

        if (value <= 0) {
            throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
        }
        return value;
    }

    private int parseInt(String input, String errorMessage) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(errorMessage);
        }
    }

    private void validateCarNames(String input) {
        String[] names = input.split(",");
        for (String name : names) {
            String trimmed = name.trim();
            if (trimmed.isEmpty() || trimmed.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.");
            }
        }
    }
}
