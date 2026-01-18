import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class MoveActionTest {

    // 테스트용 가짜 MoveCondition
    private static class AlwaysMoveCondition extends MoveCondition {
        @Override
        public boolean canMove() { return true; }
    }

    @Test
    void 모든_자동차가_한번씩_이동을_시도한다() {
        Car[] cars = { new Car(), new Car(), new Car() };
        MoveAction moveAction = new MoveAction();

        moveAction.moveAll(cars, new AlwaysMoveCondition());

        for (Car car : cars) {
            assertThat(car.getPosition()).isEqualTo(1);
        }
    }
}
