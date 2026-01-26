package carrace.domain;

import java.util.List;
import java.util.stream.IntStream;


public class Car {

    private Position position = new Position();

    public static List<Car> createCars(int count) {
        return IntStream.range(0,count) //정수 스트림 생성, 0부터 count -1까지 숫자를 차례대로 흘려보냄, ex) count = 3, stream = 0 -> 1 -> 2
                .mapToObj(i -> new Car()) //스트림에 흐르는 각 숫자 i를 Car 객체로 변환
                .toList(); // 스트림을 List로 수집, 이 순간에만 실제 실행됨(최종 연산)
    } // ex) 결과 : List<Car> cars = [new Car(), new Car(), new Car()]

    public void move(MoveCondition condition) {
        if (condition.canMove()) {
            position = position.moveForward();
        }
    }

    public int getPosition() {
        return position.getValue();
    }
}
