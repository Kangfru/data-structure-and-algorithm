package algorithm.inflearn2.section8graph;

public class TargetNumber {

    //n개의 음이 아닌 정수들이 있습니다. 이 정수들을 순서를 바꾸지 않고 적절히 더하거나 빼서 타겟 넘버를 만들려고 합니다. 예를 들어 [1, 1, 1, 1, 1]로 숫자 3을 만들려면 다음 다섯 방법을 쓸 수 있습니다.
    //
    //-1+1+1+1+1 = 3
    //+1-1+1+1+1 = 3
    //+1+1-1+1+1 = 3
    //+1+1+1-1+1 = 3
    //+1+1+1+1-1 = 3
    //사용할 수 있는 숫자가 담긴 배열 numbers, 타겟 넘버 target이 매개변수로 주어질 때 숫자를 적절히 더하고 빼서 타겟 넘버를 만드는 방법의 수를 return 하도록 solution 함수를 작성해주세요.

    public int solution(int[] numbers, int target) {
        return sumCount(numbers, target, 0, 0);
    }

    int sumCount(final int[] numbers, final int target, int i, int sum ) {
        if (i == numbers.length) {
            if (sum == target) {
                return 1;
            }
            return 0;
        }
        return sumCount (numbers, target, i + 1, sum + numbers[i])
        + sumCount (numbers, target, i + 1, sum - numbers[i]);
    }

}
