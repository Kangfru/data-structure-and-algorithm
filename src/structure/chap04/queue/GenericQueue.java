package structure.chap04.queue;

public class GenericQueue<E> {
    private int max; // 큐의 용량
    private int front; // 첫 번째 요소 커서
    private int rear; // 마지막 요소 커서
    private int num; // 현재 데이터 수
    private E[] queue; // 큐 본체

    public static class EmptyGenericQueueException extends RuntimeException {
        public EmptyGenericQueueException() {}
    }

    public static class OverflowGenericQueueException extends RuntimeException {
        public OverflowGenericQueueException() {}
    }

    public GenericQueue(int capacity) {
        num = front = rear = 0;
        max = capacity;
        try {
            queue = (E[]) new Object[max];
        } catch (OutOfMemoryError e) {
            max = 0;
        }
    }

    public E enqueue(E x) throws OverflowGenericQueueException {
        if (num >= max)
            throw new OverflowGenericQueueException();
        queue[rear++] = x;
        num++;
        if (rear == max)
            rear = 0;
        return x;
    }

    public E deque() throws EmptyGenericQueueException {
        if (num <= 0)
            throw new EmptyGenericQueueException();
        E x = queue[front++];
        num--;
        if (front == max)
            front = 0;
        return x;
    }

    public E peek() throws EmptyGenericQueueException {
        if (num <= 0)
            throw new EmptyGenericQueueException();
        return queue[front];
    }

    public int indexOf(E x) {
        for (int i = 0; i < num; i++) {
            int idx = (i + front) % max;
            if (queue[idx] == x)
                return idx;
        }
        return -1;
    }

    public void clear() {
        num = front = rear = 0;
    }

    public int capacity() {
        return max;
    }

    public int size() {
        return num;
    }

    public boolean isEmpty() {
        return num <= 0;
    }

    public boolean isFull() {
        return num >= max;
    }

    public void dump() {
        // 큐안의 모든 데이터를 front -> rear 로 출력.
        if (num <= 0) {
            System.out.println("큐가 비어있습니다.");
        } else {
            for (int i = 0; i < num; i++) {
                System.out.print(queue[(i + front) % max] + " ");
            }
            System.out.println();
        }
    }

    public int search(E x) {
        for (int i = 0; i < num; i++) {
            if (queue[(i + front) % max] == x) {
                return i + 1;
            }
        }
        return -1;
    }

}
