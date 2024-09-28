package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {
    static final int ANSWER_SIZE = 3;

    public static List<Integer> generateAnswer(){
        List<Integer> answer = new ArrayList<>();
        while(answer.size()<ANSWER_SIZE){
            int random = Randoms.pickNumberInRange(1, 9);
            if(!answer.contains(random)) answer.add(random);
        }
        return answer;
    }
    public static List<Integer> getUserInput(Scanner scanner){
        List<Integer> input = new ArrayList<>();
        String in = scanner.nextLine();
        // 길이가 3이 아닌경우
        if(in.length()!=ANSWER_SIZE) throw new IllegalArgumentException();
        for (int i = 0; i < ANSWER_SIZE; i++) {
            int tmp = in.charAt(i) - '0';
            // 숫자로만 입력되지 않은 경우 or 입력 중 중복된 숫자가 있을 경우
            if((tmp<1||tmp>9) || input.contains(tmp)) throw new IllegalArgumentException();
            input.add(tmp);
        }
        return input;
    }

    public static List<Integer> compareAnswer(List<Integer> answer, List<Integer> input) {
        int strike = 0;
        int ball = 0;
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < ANSWER_SIZE; i++) {
            if(answer.get(i).equals(input.get(i))) strike++;
            for (int j = 0; j < ANSWER_SIZE; j++) {
                if(i==j) continue;
                if(answer.get(i).equals(input.get(j))) ball++;
            }
        }
        result.add(strike);
        result.add(ball);
        return result;
    }
    public static void main(String[] args) {
    }
}
