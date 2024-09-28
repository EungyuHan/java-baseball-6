package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {
    public static List<Integer> generateAnswer(){
        List<Integer> answer = new ArrayList<>();
        while(answer.size()<3){
            int random = Randoms.pickNumberInRange(1, 9);
            if(!answer.contains(random)) answer.add(random);
        }
        return answer;
    }
    public static List<Integer> getUserInput(Scanner scanner){
        List<Integer> input = new ArrayList<>();
        String in = scanner.nextLine();
        // 길이가 3이 아닌경우
        if(in.length()!=3) throw new IllegalArgumentException();
        for (int i = 0; i < 3; i++) {
            int tmp = in.charAt(i) - '0';
            // 숫자로만 입력되지 않은 경우 or 입력 중 중복된 숫자가 있을 경우
            if((tmp<1||tmp>9) || input.contains(tmp)) throw new IllegalArgumentException();
            input.add(tmp);
        }
        return input;
    }
    public static void main(String[] args) {
    }
}
