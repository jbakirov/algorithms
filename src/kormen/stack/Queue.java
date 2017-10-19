package kormen.stack;

/**
 * Created by Baka on 25.03.2016.
 */
public class Queue {

    int[] queue;
    int head = 0;
    int tail = -1;
    int size = 0;
    int n = 0;

    Queue() {
        queue = new int[10];
    }

    Queue(int size) {
        this.size = size;
        queue = new int[size];
    }

    public void enqueue(int x) {
        if (tail == size - 1) {
            tail = -1;
        }
        queue[++tail] = x;
        n++;
    }

    public int dequeue() {
        int t = queue[head++];
        if (head == size) {
            head = 0;
        }
        n--;
        return t;
    }

    public static void main(String[] args) {
        Queue queue1 = new Queue(5);

        queue1.enqueue(4);
        queue1.enqueue(3);
        queue1.enqueue(10);
        queue1.enqueue(11);
        queue1.enqueue(12);
        queue1.enqueue(15);

        System.out.println(queue1.dequeue());
        System.out.println(queue1.dequeue());
        System.out.println(queue1.dequeue());
        System.out.println(queue1.dequeue());
        System.out.println(queue1.dequeue());
    }

}
