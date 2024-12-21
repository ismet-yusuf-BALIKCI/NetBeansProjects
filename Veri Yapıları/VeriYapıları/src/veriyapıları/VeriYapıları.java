
package veriyapıları;


public class VeriYapıları {

    
    public static void main(String[] args) {
      Dizi d=new Dizi(5);
      d.yazdir();
      d.ekle(6);
      d.ekle(10);
      d.ekle(1);
      d.ekle(3);
      d.ekle(4);
      d.ekle(12);
      d.yazdir();
      System.out.println(d.arama(8));
    }
    
}
