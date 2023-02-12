package structure.chap04.stack;

public class GenericStack<E> {

    private int max;
    private int ptr;
    private E[] stk;

    // 스택이 비었을 때
    public static class EmptyGenericStackException extends RuntimeException {
        public EmptyGenericStackException() {
        }
    }

    // 실행할 때 예외：스택이 가득 참
    public static class OverflowGenericStackException extends RuntimeException {
        public OverflowGenericStackException() {
        }
    }

    public GenericStack(int capacity) {
        ptr = 0;
        max = capacity;
        try {
            stk = (E[]) new Object[max];
        } catch (OutOfMemoryError e) {
            max = 0;
        }
    }

    // 스택 배열에 데이터 삽입
    public E push(E x) throws OverflowGenericStackException {
        if (ptr >= max) {
            throw new OverflowGenericStackException();
        }
        return stk[ptr++] = x;
    }

    // 스택 배열에서 데이터 추출
    public E pop() throws EmptyGenericStackException {
        if (ptr <= 0) {
            throw new EmptyGenericStackException();
        }
        return stk[--ptr];
    }

    // 꼭대기 값 peek
    public E peek() throws EmptyGenericStackException {
        if (ptr <= 0) {
            throw new EmptyGenericStackException();
        }
        return stk[ptr - 1];
    }

    public int indexOf(E x) {
        for (int i = ptr - 1; i >= 0; i--) {
            if (stk[i].equals(x)) {
                return i;
            }
        }
        return -1;
    }

    public void clear() {
        ptr = 0;
    }

    public int capacity() {
        return max;
    }

    public int size() {
        return ptr;
    }

    public boolean isEmpty() {
        return ptr <= 0;
    }

    public boolean isFull() {
        return ptr >= max;
    }

    public void dump() {
        // 스택 내 모든 요소 바닥 -> 꼭대기 순으로 출력
        if (ptr <= 0)
            System.out.println("Stack is empty");
        else {
            for (int i = 0; i < ptr; i++) {
                System.out.print(stk[i] + " ");
            }
            System.out.println();
        }
    }

}
