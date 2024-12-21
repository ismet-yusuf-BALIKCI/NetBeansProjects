package veriyapıları;

import java.util.Arrays;

public class Stack {

    int[] q;
    int es;

    public Stack(int boyut) {
        q = new int[boyut];
        es = 0;
    }

    public void push(int a) {
        if (es == q.length) {
            System.out.println("Kuyruk dolu");
        } else {
            q[es++] = a;
        }
    }

    public int pop() {
        int r = q[es - 1];
        q[es--] = 0;
        return r;
    }

    public void yazdir() {
        System.out.println(Arrays.toString(q));
    }

}
