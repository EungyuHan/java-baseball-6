package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    static final int ANSWER_SIZE = 3;

    public static List<Integer> generateAnswer() {
        List<Integer> answer = new ArrayList<>();
        while (answer.size() < ANSWER_SIZE) {
            int random = Randoms.pickNumberInRange(1, 9);
            if (!answer.contains(random)) {
                answer.add(random);
            }
        }
        return answer;
    }

    public static List<Integer> getUserInput() {
        List<Integer> input = new ArrayList<>();
        String in = readLine();
        // 길이가 3이 아닌경우
        if (in.length() != ANSWER_SIZE) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < ANSWER_SIZE; i++) {
            int tmp = in.charAt(i) - '0';
            // 숫자로만 입력되지 않은 경우 or 입력 중 중복된 숫자가 있을 경우
            if ((tmp < 1 || tmp > 9) || input.contains(tmp)) {
                throw new IllegalArgumentException();
            }
            input.add(tmp);
        }
        return input;
    }

    public static List<Integer> compareAnswer(List<Integer> answer, List<Integer> input) {
        int strike = 0;
        int ball = 0;
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < ANSWER_SIZE; i++) {
            // 스트라이크 갯수 카운트
            if (answer.get(i).equals(input.get(i))) {
                strike++;
            }
            // 볼 개수 카운트
            for (int j = 0; j < ANSWER_SIZE; j++) {
                if (i == j) {
                    continue;
                }
                if (answer.get(i).equals(input.get(j))) {
                    ball++;
                }
            }
        }
        result.add(strike);
        result.add(ball);
        return result;
    }

    public static void startGame() {
        List<Integer> answer = generateAnswer();
        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            List<Integer> input = getUserInput();
            List<Integer> result = compareAnswer(answer, input);
            int strike = result.get(0);
            int ball = result.get(1);
            if (strike == 0 && ball == 0) {
                System.out.println("낫싱");
                continue;
            }
            String indicator = "";
            if (ball != 0) {
                indicator += ball + "볼";
            }
            if (strike != 0) {
                if (!indicator.isEmpty()) {
                    indicator += " ";
                }
                indicator += strike + "스트라이크";
            }
            System.out.println(indicator);
            if (strike == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (true) {
            startGame();
            while (true) {
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                int flag = Integer.parseInt(readLine());
                // 1이나 2가 아닌 수가 입력된 경우
                if (flag == 1) { // 1이 입력된 경우, 루프를 종료하고 재시작
                    break;
                } else if (flag == 2) { // 2가 입력된 경우, 프로그램 종료
                    return;
                }
            }
        }
    }
}
