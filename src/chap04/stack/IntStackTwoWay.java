package chap04.stack;

public class IntStackTwoWay {

    public enum Direction {
        TOP, BOTTOM
    }


    // top and bottom both side max size
    private int max;
    private int ptrTop;
    private int ptrBottom;
    private int[] stk;

    // 스택이 비었을 때
    public class EmptyIntStackTwoWayException extends RuntimeException {
        public EmptyIntStackTwoWayException() {
        }
    }

    // 스택이 가득찼을 때
    public class OverflowIntStackTwoWayException extends RuntimeException {
        public OverflowIntStackTwoWayException() {}
    }

    public IntStackTwoWay(int capacity) {
        ptrBottom = 0;
        ptrTop = capacity - 1;
        max = capacity;
        try {
            stk = new int[max];
        } catch (OutOfMemoryError e) {
            max = 0;
        }
    }

    // 스택 배열에 데이터 삽입
    public int push(Direction dir, int x) throws OverflowIntStackTwoWayException {
        if (ptrBottom >= ptrTop + 1) {
            throw new OverflowIntStackTwoWayException();
        }
        if (dir.equals(Direction.BOTTOM)) {
            // 아래부터 (인덱스 0 시작)
            return stk[ptrBottom++] = x;
        } else {
            // 위 쪽 인덱스부터
            return stk[ptrTop--] = x;
        }
    }

    // 스택 배열에서 데이터 추출
    public int pop(Direction dir) throws EmptyIntStackTwoWayException {
        if (dir.equals(Direction.BOTTOM)) {
            // 아래부터
            if (ptrBottom <= 0) {
                throw new EmptyIntStackTwoWayException();
            }
            return stk[--ptrBottom];
        }
        if (ptrTop >= max - 1) {
            throw new EmptyIntStackTwoWayException();
        }
        return stk[++ptrTop];
    }

    // 꼭대기 값 peek
    public int peek(Direction dir) throws IntStack.EmptyIntStackException {
        if (dir.equals(Direction.BOTTOM)) {
            if (ptrBottom <= 0) {
                throw new EmptyIntStackTwoWayException();
            }
            return stk[ptrBottom - 1];
        }
        if (ptrTop >= max - 1) {
            throw new EmptyIntStackTwoWayException();
        }
        return stk[ptrTop + 1];
    }

    public int indexOf(Direction dir, int x) {
        if (dir.equals(Direction.BOTTOM)) {
            for (int i = ptrBottom - 1; i >= 0; i--) {
                if (stk[i] == x) {
                    return i;
                }
            }
            return -1;
        }
        for (int i = ptrTop + 1; i < max; i++) {
            if (stk[i] == x) {
                return i;
            }
        }
        return -1;
    }

    public void clear(Direction dir) {
        if (dir.equals(Direction.BOTTOM)) {
            ptrBottom = 0;
        }
        if (dir.equals(Direction.TOP)) {
            ptrTop = max - 1;
        }
    }

    public int capacity() {
        return max;
    }

    public int size(Direction dir) {
        if (dir.equals(Direction.BOTTOM)) {
            return ptrBottom;
        }
        return max - ptrTop - 1;
    }

    public boolean isEmpty(Direction dir) {
        if (dir.equals(Direction.BOTTOM)) {
            return ptrBottom <= 0;
        }
        return ptrTop >= max - 1;
    }

    public boolean isFull() {
        return ptrBottom >= ptrTop - 1;
    }

    public void dump(Direction dir) {
        if (dir.equals(Direction.BOTTOM)) {
            // 스택 내 모든 요소 바닥 -> 꼭대기 순으로 출력
            if (ptrBottom <= 0)
                System.out.println("Stack is empty");
            else {
                for (int i = 0; i < ptrBottom; i++) {
                    System.out.print(stk[i] + " ");
                }
                System.out.println();
            }
        }
        if (dir.equals(Direction.TOP)) {
            if (ptrTop >= max - 1)
                System.out.println("Stack is empty");
            else {
                for (int i = max - 1; i > ptrTop; i--) {
                    System.out.print(stk[i] + " ");
                }
                System.out.println();
            }
        }
    }
}
