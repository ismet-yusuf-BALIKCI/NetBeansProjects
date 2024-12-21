package baglilisteimpl;


public class BagliListeImpl {

   
    public static void main(String[] args) {
       BagliListe bl =new BagliListe();
       
       Node n1=new Node(5);
       Node n2=new Node(15);
       Node n3=new Node(9);
       Node n4=new Node(18);
       Node n5=new Node(20);
       Node n6=new Node(2);
       
       bl.basaEkle(n1);
       bl.print();
       bl.basaEkle(n2);
       bl.print();
       bl.basaEkle(n3);
       bl.print();
       bl.basaEkle(n4);
       bl.print();
       bl.basaEkle(n5);
       bl.print();
       bl.basaEkle(n6);
       bl.print();
       
       bl.sondanSil();
    }
    
}
