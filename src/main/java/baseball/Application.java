package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public List<Integer> generateAnswer(){
        List<Integer> answer = new ArrayList<>();
        while(answer.size()<3){
            int random = Randoms.pickNumberInRange(1, 9);
            if(!answer.contains(random)) answer.add(random);
        }
        return answer;
    }
    public static void main(String[] args) {
    }
}
