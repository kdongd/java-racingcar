package carrace.domain.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CarCreatorTest {

    @Test
    @DisplayName("쉼표 기준으로 자동차 생성")
    void createCars_byComma() {
        List<Car> cars = CarCreator.create("kkk,ddd,uuu");

        assertEquals(3, cars.size());
        assertEquals("kkk", cars.get(0).getCarName());
        assertEquals("ddd", cars.get(1).getCarName());
        assertEquals("uuu", cars.get(2).getCarName());
    }

    @Test
    @DisplayName("자동차 이름 앞뒤 공백 제거")
    void createCars_trimNames() {
        List<Car> cars = CarCreator.create("kkk,ddd,uuu");

        assertEquals(3, cars.size());
        assertEquals("kkk", cars.get(0).getCarName());
        assertEquals("ddd", cars.get(1).getCarName());
        assertEquals("uuu", cars.get(2).getCarName());
    }
}

