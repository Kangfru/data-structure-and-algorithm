package algorithm.programmers;

import java.util.Stack;

// 프로그래머스 택배 상자
public class ParcelService {

    public int solution(int[] order) {
        int answer = 0;
        Stack<Integer> mainContainer = new Stack<>();
        Stack<Integer> subContainer = new Stack<>();
        for (int i = order.length; i > 0; i--) {
            mainContainer.push(i);
        }
        while (order[0] != mainContainer.peek()) {
            subContainer.push(mainContainer.pop());
        }
        answer++;
        mainContainer.pop();

        for(int i = 1; i < order.length; i++){
            if (!mainContainer.isEmpty() && order[i] == mainContainer.peek()){
                answer++;
                mainContainer.pop();
            } else if(!subContainer.isEmpty() && order[i] == subContainer.peek()){

                answer++;
                subContainer.pop();
            } else{
                if(!mainContainer.isEmpty() && mainContainer.peek() < order[i]) {

                    while(order[i] != mainContainer.peek()){
                        subContainer.push(mainContainer.pop());
                    }
                    answer++;
                    mainContainer.pop();
                }else{
                    break;
                }

            }
        }

        return answer;
    }

}
