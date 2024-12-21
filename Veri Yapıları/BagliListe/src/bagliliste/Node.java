package bagliliste;


public class Node {
    int data;
    Node next;
    
    public Node(int d){
        data = d;
        next=null;
    }
    
    @Override
    public String toString(){
        return "[" + data + ","+ next+'}';
    }
    
}
