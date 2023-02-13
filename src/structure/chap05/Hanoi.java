package structure.chap05;

public class Hanoi {

    // no 개의 원반을 x번 기둥에서 y 번 기둥으로 옮김
    static void move(int no, int x, int y) {
        // 기둥을 1, 2, 3 으로 가정.
        if (no > 1) {
            move(no - 1, x, 6 - x - y);
        }
        System.out.println("원반 [" + no + "]을 " + x + "기둥에서 " + y + "기둥으로 옮김");

        if (no > 1)
            move(no - 1, 6 - x - y, y);
    }

}
