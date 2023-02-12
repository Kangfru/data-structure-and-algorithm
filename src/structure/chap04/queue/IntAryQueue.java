package structure.chap04.queue;

public class IntAryQueue {

    private int max;

    private int num;

    private int[] queue;

    public IntAryQueue(int size) {
        this.max = size;
        queue = new int[size];
        num = 0;
    }


}
