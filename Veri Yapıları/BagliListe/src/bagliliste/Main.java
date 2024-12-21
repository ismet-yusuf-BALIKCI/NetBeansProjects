package bagliliste;

public class Main {

    public static void main(String[] args) {

        BagliListe liste = new BagliListe();
        for (int i = 0; i < 10; i++) {
            liste.Ekle();
        }
        liste.print();
        liste.BubbleSort();
        liste.print();
    }
}