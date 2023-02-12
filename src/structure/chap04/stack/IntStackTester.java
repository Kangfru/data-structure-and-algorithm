package structure.chap04.stack;

import java.util.Scanner;

public class IntStackTester {

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        IntStack s = new IntStack(64);

        while (true) {
            System.out.println("현재 데이터 수 : " + s.size() + " / " + s.capacity());
            System.out.print("(1) 푸시 (2) 팝 (3) 피크 (4) 덤프 (0) 종료");

            int select = stdIn.nextInt();
            if (select == 0) break;

            int x;
            switch (select) {
                case 1: // 푸시
                    System.out.println("데이터 : ");
                    x = stdIn.nextInt();
                    try {
                        s.push(x);
                    } catch (IntStack.OverflowIntStackException e) {
                        System.out.println("Stack is full.");
                    }
                    break;

                case 2: // 팝
                    try {
                        x = s.pop();
                        System.out.println("Pop Data is " + x);
                    } catch(IntStack.EmptyIntStackException e) {
                        System.out.println("Stack is empty");
                    }
                    break;

                case 3: // peek
                    try {
                        x = s.peek();
                        System.out.println("피크한 데이터는 " + x);
                    } catch (IntStack.EmptyIntStackException e) {
                        System.out.println("Stack is empty");
                    }
                    break;

                case 4:
                    s.dump();
                    break;
            }
        }

    }

}
