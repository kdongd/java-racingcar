import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RaceTest {

    private static class DummyOutputView extends CarRaceOutputView {
        @Override public void printStartMessage() {}
        @Override public void printRoundResult(Car[] cars) {}
    }

    private static class AlwaysMoveCondition extends MoveCondition {
        @Override public boolean canMove() { return true; }
    }

    @Test
    void 라운드_수만큼_자동차가_이동한다() {
        Car[] cars = { new Car(), new Car() };
        Race race = new Race(cars, 3);

        race.run(new MoveAction(), new AlwaysMoveCondition(), new DummyOutputView());

        assertThat(cars[0].getPosition()).isEqualTo(3);
    }
}
