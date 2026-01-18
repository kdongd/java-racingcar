public class Application {
    public static void main(String[] args) {
        CarRaceInputView inputView = new CarRaceInputView();

        int carCount = readInt(inputView.readCarCount(), "자동차 대수는 숫자여야 합니다.");
        int rounds = readInt(inputView.readMoveCount(), "시도 횟수는 숫자여야 합니다.");

        validate(carCount, rounds);

        Car[] cars = CarFactory.create(carCount);
        MoveCondition condition = new MoveCondition();
        MoveAction moveAction = new MoveAction();
        CarRaceOutputView outputView = new CarRaceOutputView();

        Race race = new Race(cars, rounds);
        race.run(moveAction, condition, outputView);
    }

    private static int readInt(String input, String errorMessage) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(errorMessage);
        }
    }

    private static void validate(int carCount, int rounds) {
        if (carCount <= 0) {
            throw new IllegalArgumentException("자동차는 1대 이상이어야 합니다.");
        }
        if (rounds <= 0) {
            throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
        }
    }
}
