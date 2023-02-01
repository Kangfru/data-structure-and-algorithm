package chap04.queue;

import java.util.Scanner;

public class IntQueueTest {

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        IntQueue queue = new IntQueue(64);

        while (true) {
            System.out.println("현재 데이터 수 : " + queue.size() + " / " + queue.capacity());
            System.out.print("(1) 인큐 (2) 디큐 (3) 피크 (4) 덤프 (0) 종료 : ");
            int menu = stdIn.nextInt();
            if (menu == 0) break;

            int x;
            switch (menu) {
                case 1:
                    System.out.print("데이터 : ");
                    x = stdIn.nextInt();
                    try {
                        queue.enqueue(x);
                    } catch (IntQueue.OverflowIntQueueException e) {
                        System.out.println("큐가 가득 찼습니다.");
                    }
                    break;

                case 2:
                    try {
                        x = queue.deque();
                        System.out.println("디큐 데이터 : [" + x + "]");
                    } catch (IntQueue.EmptyIntQueueException e) {
                        System.out.println("큐가 비었습니다.");
                    }
                    break;

                case 3:
                    try {
                        x = queue.peek();
                        System.out.println("피크한 데이터는 [" + x + "]");
                    } catch (IntQueue.EmptyIntQueueException e) {
                        System.out.println("큐가 비어있습니다");
                    }
                    break;

                case 4:
                    queue.dump();
                    break;

                case 5:
                    System.out.print("찾을 데이터 : ");
                    System.out.println("위치는 : "+ queue.search(stdIn.nextInt()));
                    break;
            }
        }
    }

}
