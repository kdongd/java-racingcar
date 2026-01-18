public class Race {
    private final Car[] cars;
    private final int rounds;

    public Race(Car[] cars, int rounds) {
        this.cars = cars;
        this.rounds = rounds;
    }

    public void run(MoveAction moveAction, MoveCondition condition, CarRaceOutputView outputView) {
        outputView.printStartMessage();

        for (int i = 0; i < rounds; i++) {
            moveAction.moveAll(cars, condition);
            outputView.printRoundResult(cars);
        }
    }

    public Car[] getCars() {
        return cars;
    }
}
