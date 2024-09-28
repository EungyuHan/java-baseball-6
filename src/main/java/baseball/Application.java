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
        if(in.length()!=3) throw new IllegalArgumentException();
        for (int i = 0; i < 3; i++) {
            int tmp = in.charAt(i) - '0';
            if(tmp<1 || tmp>9) throw new IllegalArgumentException();
            input.add(tmp);
        }
        return input;
    }
    public static void main(String[] args) {
    }
}
