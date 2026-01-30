package carrace.domain.race;

import carrace.domain.car.Car;
import carrace.fixture.CarsFixture;
import carrace.fixture.MoveConditions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


class RaceTest {

    @Test
    @DisplayName("Race는 생성시 자동차 목록을 가진다")
    void race_initialCars_listExists() {
        List<Car> cars = CarsFixture.threeCars();
        Race race = new Race(cars);

        assertThat(race.getCars()).hasSize(3);
    }

    @Test
    @DisplayName("moveOnce 호출 시 이동하지 않는 조건이면 자동차 위치는 그대로다")
    void moveOnce_neverMove_positionUnchanged() {
        List<Car> cars = CarsFixture.threeCars();
        Race race = new Race(cars);

        race.moveOnce(MoveConditions.neverMove());

        for (Car car : race.getCars()) {
            assertThat(car.getPosition()).isEqualTo(0);
        }
    }

    @Test
    @DisplayName("getCars 반환은 내부 리스트를 보호한다")
    void getCars_returnsUnmodifiableList() {
        List<Car> cars = CarsFixture.threeCars();
        Race race = new Race(cars);

        List<Car> raceCars = race.getCars();

        assertThat(raceCars).containsExactlyElementsOf(cars);
        // 내부 리스트 수정 시도 시 예외 발생 확인
        assertThatThrownBy(() -> raceCars.add(new Car("kdu")))
                .isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    @DisplayName("우승자 1명일 때 getWinners 반환")
    void getWinners_single() {
        List<Car> cars = CarsFixture.threeCars();
        Race race = new Race(cars);

        cars.get(0).move(MoveConditions.alwaysMove());

        List<Car> winners = race.getWinners();
        assertThat(winners).hasSize(1);
        assertThat(winners.get(0)).isSameAs(cars.get(0));
    }

    @Test
    @DisplayName("우승자가 여러명일 때 getWinners 반환")
    void getWinners_multiple() {
        List<Car> cars = CarsFixture.threeCars();
        Race race = new Race(cars);

        cars.get(0).move(MoveConditions.alwaysMove());
        cars.get(1).move(MoveConditions.alwaysMove());

        List<Car> winners = race.getWinners();

        assertThat(winners).hasSize(2);
        assertThat(winners).contains(cars.get(0),cars.get(1));
    }
}


