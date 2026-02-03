package carrace.domain.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarsTest {

    @Test
    @DisplayName("쉼표 기준으로 자동차 생성")
    void createCars_byComma() {
        Cars cars = Cars.from("kkk,ddd,uuu");

        List<Car> list = cars.asList();
        assertEquals(3, list.size());
        assertEquals("kkk", list.get(0).getCarName());
        assertEquals("ddd", list.get(1).getCarName());
        assertEquals("uuu", list.get(2).getCarName());
    }

    @Test
    @DisplayName("자동차 이름 앞뒤 공백 제거")
    void createCars_trimNames() {
        Cars cars = Cars.from(" kkk , ddd , uuu ");

        List<Car> list = cars.asList();
        assertEquals(3, list.size());
        assertEquals("kkk", list.get(0).getCarName());
        assertEquals("ddd", list.get(1).getCarName());
        assertEquals("uuu", list.get(2).getCarName());
    }

    @Test
    @DisplayName("자동차가 1대도 없으면 예외 발생")
    void cars_shouldNotBeEmpty() {
        assertThatThrownBy(() -> Cars.from(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차 이름이 중복되면 예외 발생")
    void cars_shouldNotHaveDuplicateNames() {
        assertThatThrownBy(() -> Cars.from("car1,car1"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}

