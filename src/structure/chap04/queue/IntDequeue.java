package structure.chap04.queue;

// 양방향 큐 구현
public class IntDequeue {

    int max; // 큐의 용량
    int front; // 프론트 커서
    int rear; // 리어 커서
    int num; // 현재 데이터의 수
    int[] queue; // 본체


    public IntDequeue(int capacity) {
         max = capacity;
         front = rear = num = 0;
         queue = new int[capacity];
    }

    public static class IntDequeueOverflowException extends RuntimeException {
        public IntDequeueOverflowException() {

        }
    }

    public static class IntDequeueEmptyException extends RuntimeException {
        public IntDequeueEmptyException() {}
    }

    public int enqueueFront(int x) {
        if (num >= max) {
            throw new IntDequeueOverflowException();
        }
        num++;
        if (--front < 0)
            front = max - 1;
        queue[front] = x;
        return x;
    }

    public int enqueueRear(int x) {
        if (num >= max) {
            throw new IntDequeueOverflowException();
        }
        queue[rear++] = x;
        num++;
        if (rear == max)
            rear = 0;
        return x;
    }

    public int dequeueFront() {
        if (num <= 0) {
            throw new IntDequeueEmptyException();
        }
        num--;
        int x = queue[front++];
        if (front >= max) {
            front = 0;
        }
        return x;
    }

    public int dequeueRear() {
        if (num <= 0) {
            throw new IntDequeueEmptyException();
        }
        num--;
        if (--rear < 0)
            rear = max - 1;
        return queue[rear];
    }
}
