package carrace.view;

import java.util.Scanner;

public class CarRaceInputView {

    private final Scanner scanner = new Scanner(System.in);


    public String readCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return scanner.nextLine();
    }
    public String readCarCount() {
        System.out.println("자동차 대수는 몇 대인가요?");
        return scanner.nextLine();
    }

    public String readMoveCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        return scanner.nextLine();
    }
}
