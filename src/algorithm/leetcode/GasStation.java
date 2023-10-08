package algorithm.leetcode;

public class GasStation {

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int currentGas;
        boolean flag;
        for (int i = 0; i < gas.length; i++) {
            // i 는 시작 지점임.
            currentGas = gas[i];
            int j = i;
            int count = gas.length + 1;
            flag = true;
            while (flag) {
                j = j >= gas.length - 1 ? 0 : j + 1;
                currentGas -= cost[j];
                if (currentGas < 0) {
                    flag = false;
                    continue;
                }
                currentGas += gas[j];
                if (count-- == 0) return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        canCompleteCircuit(new int[]{1, 2, 3, 4, 5}, new int[]{3, 4, 5, 1, 2});
    }

}
