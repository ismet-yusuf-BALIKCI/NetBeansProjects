package baglilisteimpl;

public class BagliListe {

    Node head;
    Node tail;
    int es;

    public BagliListe() {
        head = null;
        tail=null;
        es = 0;
    }
    public void basaEkle(Node n){
        if(head ==null){
            tail =n;
        }else{
            n.next = head;
        }
        head =n;
    }
    public void sonaEkle(Node n){
        if(head ==null){
            head =n;
        }else{
            tail.next = n;
        }
        tail =n;
    }
    public void bastanSil(){
        if(head !=null){
            if(head ==tail){
                head =null;
                tail=null;
            }else{
                head = head.next;
            }
        } else{
            System.out.println("Liste Bos");
        }
    }
   
    public void sondanSil(){
        if(head ==null){
            System.out.println("Liste Bos");
        } else {
            if(head == tail){
                head =null;
                tail=null;
            }else{
                Node t = head;
                while(t.next != tail){
                    t=t.next;
                }
                t.next =null;
                tail=t;
            }
        }
    }
    
    
    
    
    
    
    
    
    
/*
    public void AddInOrder(Node n) {
        if (head == null) {
            head = n;
        } else if (head.data > n.data) {
            n.next = head;
            head = n;
        } else {

            Node tmp = head;
            while (tmp.next != null && tmp.next.data < n.data) {
                tmp = tmp.next;
            }
            n.next = tmp.next;
            tmp.next = n;
        }

    }

    public void delete(int d) {
        if (head == null) {
            System.out.println("Liste Bos");
        } else if (head.data == d) {
            head = head.next;
        } else {
            Node tmp = head;
            while (tmp != null) {
                if (tmp.next.data == d) {
                    tmp.next =tmp.next.next;
                }
                tmp = tmp.next;
            }
        }
    }

    public void add(Node n) {

        if (head == null) {
            head = n;
        } else {
            Node tmp = head;
            while (tmp.next != null) {
                tmp = tmp.next;
            }
            tmp.next = n;
        }
    } */

    public void print() {

        Node tmp = head;
        while (tmp != null) {
            System.out.print(tmp.data + " - ");
            tmp = tmp.next;
        }
        System.out.println();
    }
}
