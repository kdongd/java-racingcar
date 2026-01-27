package carrace.fixture;

import carrace.view.CarRaceInputView;

public class StubInputView extends CarRaceInputView {

    private final String carName;
    private final String carCount;
    private final String rounds;

    public StubInputView(String carCount, String rounds) {
        this.carName = "";
        this.carCount = carCount;
        this.rounds = rounds;
    }

    public StubInputView(String carName, String carCount, String rounds) {
        this.carName = carName;
        this.carCount = carCount;
        this.rounds = rounds;
    }

    @Override
    public String readCarCount() {
        return carCount;
    }

    @Override
    public String readMoveCount() {
        return rounds;
    }

    @Override
    public String readCarNames() {
        return carName;
    }
}
