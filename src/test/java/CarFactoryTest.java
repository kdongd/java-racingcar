import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class CarFactoryTest {

    @Test
    void 입력한_수만큼_자동차를_생성한다() {
        Car[] cars = CarFactory.create(3);
        assertThat(cars).hasSize(3);
    }
}
