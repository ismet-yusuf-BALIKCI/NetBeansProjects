package bagliliste;

import java.util.Collections;
import java.util.List;
import java.util.Random;

public class BagliListe {

    Node head;
    Node tail;
    int size;

    public BagliListe() {
        head = null;
        tail = null;
        size = 0;
    }

    public void Ekle(Node n) {
        if (head == null) {
            tail = n;
        } else {
            n.next = head;
        }
        head = n;
        size++;
    }

    public void Ekle() {
        Random r = new Random();
        int data = r.nextInt(100);
        Node n = new Node(data);
        if (head == null) {
            tail = n;
        } else {
            n.next = head;
        }
        head = n;
        size++;
    }

    public void Sil() {
        if (head != null) {
            if (head == tail) {
                head = null;
                tail = null;
            } else {
                head = head.next;
            }
            size--;
        } else {
            System.out.println("Liste Bos");
        }
    }

    public void BubbleSort() {
        boolean isSwapped = true;

        for (int i = 0; i < size && isSwapped; i++) {
            isSwapped = false;
            Node current = head;
            Node next = head.next;
            for (int j = 0; j < (size - 1) - i; j++) {
                if (current.data > next.data) {
                    Collections.swap((List<?>) this, j, j + 1);
                    isSwapped = true;
                }
                current = next;
                next = next.next;
            }
        }
    }

    public void print() {
        Node tmp = head;
        while (tmp != null) {
            tmp = tmp.next;
        }
        System.out.println();
    }
}
