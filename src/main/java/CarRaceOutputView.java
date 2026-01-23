import java.util.List;

public class CarRaceOutputView {

    public void printStartMessage() {
        System.out.println("\n실행 결과");
    }

    public void printResult(List<Car> cars) {
        for (Car car : cars) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < car.getPosition(); i++) {
                sb.append("-");
            }
            System.out.println(sb.toString());
        }
        System.out.println();
    }
}
