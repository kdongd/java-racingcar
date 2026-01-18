import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    private static class AlwaysMoveCondition extends MoveCondition {
        @Override
        public boolean canMove() { return true; }
    }

    private static class NeverMoveCondition extends MoveCondition {
        @Override
        public boolean canMove() { return false; }
    }

    @Test
    void 이동_조건이_참이면_자동차가_전진한다() {
        Car car = new Car();
        car.move(new AlwaysMoveCondition());

        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void 이동_조건이_거짓이면_자동차는_전진하지_않는다() {
        Car car = new Car();
        car.move(new NeverMoveCondition());

        assertThat(car.getPosition()).isEqualTo(0);
    }
}
