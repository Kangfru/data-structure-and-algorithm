package algorithm.leetcode;

public class IntegerToRoman {

    public static String intToRoman(int num) {
        StringBuilder roman = new StringBuilder();
        int carry1000 = num / 1000;
        num %= 1000;
        int carry100 = num / 100;
        num %= 100;
        int carry10 = num / 10;
        num %= 10;
        // 1000 의 자리
        for (int i = 0; i < carry1000; i++) {
            roman.append("M");
        }
        // 100의 자리
        if (carry100 == 4) {
            roman.append("CD");
        } else if (carry100 == 9) {
            roman.append("CM");
        } else if (carry100 >= 5) {
            roman.append("D");
            for (int i = 0; i < carry100 - 5; i++) {
                roman.append("C");
            }
        } else {
            for (int i = 0; i < carry100; i++) {
                roman.append("C");
            }
        }
        // 10의 자리
        if (carry10 == 4) {
            roman.append("XL");
        } else if (carry10 == 9) {
            roman.append("XC");
        } else if (carry10 >= 5) {
            roman.append("L");
            for (int i = 0; i < carry10 - 5; i++) {
                roman.append("X");
            }
        } else {
            for (int i = 0; i < carry10; i++) {
                roman.append("X");
            }
        }
        // 1의 자리
        if (num == 4) {
            roman.append("IV");
        } else if (num == 9) {
            roman.append("IX");
        } else if (num >= 5) {
            roman.append("V");
            for (int i = 0; i < num - 5; i++) {
                roman.append("I");
            }
        } else {
            for (int i = 0; i < num; i++) {
                roman.append("I");
            }
        }
        return roman.toString();
    }

    public static void main(String[] args) {
        System.out.println(intToRoman(1997));
    }

}
