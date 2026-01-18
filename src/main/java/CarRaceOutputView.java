public class CarRaceOutputView {
    public void printStartMessage() {
        System.out.println("\n실행 결과");
    }

    public void printRoundResult(Car[] cars) {
        for (Car car : cars) {
            System.out.println("-".repeat(car.getPosition()));
        }
        System.out.println();
    }
}
