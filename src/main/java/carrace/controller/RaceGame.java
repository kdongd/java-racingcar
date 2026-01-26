package carrace.controller;

import carrace.domain.MoveCondition;
import carrace.domain.Race;
import carrace.view.CarRaceOutputView;

public class RaceGame {

    private final Race race;
    private final MoveCondition condition;
    private final CarRaceOutputView outputView;

    public RaceGame(Race race, MoveCondition condition, CarRaceOutputView outputView) {
        this.race = race;
        this.condition = condition;
        this.outputView = outputView;
    }

    public void play(int rounds) {
        outputView.printStartMessage();

        for (int i = 0; i < rounds; i++) {
            race.moveOnce(condition);
            outputView.printResult(race.getCars());
        }
    }
}
