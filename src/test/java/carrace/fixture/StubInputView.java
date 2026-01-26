package carrace.fixture;

import carrace.view.CarRaceInputView;

public class StubInputView extends CarRaceInputView {

    private final String carCount;
    private final String rounds;

    public StubInputView(String carCount, String rounds) {
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
}

