import java.util.Scanner;

public class CarRaceInputView {

    private final Scanner scanner = new Scanner(System.in);

    public String readCarCount() {
        System.out.println("자동차 대수는 몇 대인가요?");
        return scanner.nextLine();
    }

    public String readMoveCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        return scanner.nextLine();
    }
}
