public class InputService {

    private final CarRaceInputView inputView;
    private final IntParser parser;

    public InputService(CarRaceInputView inputView, IntParser parser) {
        this.inputView = inputView;
        this.parser = parser;
    }

    public int readCarCount() {
        int value = parser.parse(
                inputView.readCarCount(),
                "자동차 대수는 숫자여야 합니다."
        );
        if (value <= 0) {
            throw new IllegalArgumentException("자동차는 1대 이상이어야 합니다.");
        }
        return value;
    }

    public int readRounds() {
        int value = parser.parse(
                inputView.readMoveCount(),
                "시도 횟수는 숫자여야 합니다."
        );
        if (value <= 0) {
            throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
        }
        return value;
    }
}
