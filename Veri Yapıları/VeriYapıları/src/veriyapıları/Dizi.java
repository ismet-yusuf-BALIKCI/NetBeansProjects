package veriyapıları;

import java.util.Arrays;

public class Dizi {

    int[] dizi;
    int es;

    public Dizi(int boyut) {
        dizi = new int[boyut];
        es = 0;
    }

    public void ekle(int a) {
        if (es >= dizi.length) {
            System.out.println("Dizi dolu");
        } else {
            dizi[es++] = a;
        }
    }

    public int arama(int a) {
        for (int i = 0; i < es; i++) {
            if (dizi[i] == a) {
                return i;
            }
        }
        return -1;
    }

    public void sil(int a) {
        int indis = this.arama(a);
        if (indis == -1) {
            System.out.println("Silmek istediginiz sayi bulunamadi!");
        } else {
            for (int i = indis; i < es; i++) {
                dizi[i] = dizi[i + 1];
            }
            dizi[es--] = 0;
        }
    }

    public void guncelle(int eski, int yeni) {
        int indis = this.arama(eski);
        if (indis == -1) {
            System.out.println("Güncellemek istediginiz sayi bulunamadi!");
        } else {
            dizi[indis] = yeni;
        }
    }

    public void yazdir() {
        System.out.println(Arrays.toString(dizi));
    }

}
