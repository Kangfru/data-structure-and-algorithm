package algorithm.inflearn2.section4set;

import java.util.HashSet;
import java.util.Set;

public class Lotto {

    /*
    * 로또 번호 검출기
    문제 설명
    로또복권의 번호는 1에서 45 사이의 값을 가진 6개의 숫자로 구성됩니다.
    로또복권을 신청하는 사용자들은 OMR카드에 숫자를 마킹하여 신청을 하는데, 가끔 잘못 표시하여 신청하는 사용자들이 있습니다.
    로또복권에 등록 가능한 숫자조합인지 확인하는 기능을 작성해 주세요

    입력1: [4, 7, 32, 43, 22, 19]
    출력1: true

    6개의 숫자가 중복없이 1~45사이의 값을 가지고 로또복권 등록이 가능합니다.

    입력2: [3, 19, 34, 39, 39, 20]
    출력2: false

    6개의 숫자 중 39가 중복되어 로또복권 등록이 불가능합니다.

    입출력 예

    입력1: [4, 7, 32, 43, 22, 19]
    출력1: true

    입력2: [3, 19, 34, 39, 39, 20]
    출력2: false
 */

    public boolean solution(int[] arr) {
        Set<Integer> checker = new HashSet<>();
        for (int a : arr) {
            if (a > 45 || a < 1) return false;
            checker.add(a);
        }
        return checker.size() == arr.length;
    }

}
