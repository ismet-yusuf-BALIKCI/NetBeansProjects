
import asansor.Kullanici;
import java.util.Random;

public class Asansor {

    private int kat;
    private int kapasite;
    private boolean kapali;
    private int toplamAgirlik;
    private Kullanici[] kullanicilar;
    private boolean sonYolcuIndirilsin;

    public Asansor(int kapasite) {
        this.kat = 0;
        this.kapasite = kapasite;
        this.kapali = true;
        this.toplamAgirlik = 0;
        this.kullanicilar = new Kullanici[10];
        this.sonYolcuIndirilsin = false;
    }

    public void kullaniciEkle(String isim, int bulunduguKat, int gidilecekKat) {
        if (toplamAgirlik + 100 > kapasite) {
            System.out.println("Asansor maksimum agirlik sinirini asti. Yeni bir yolcu eklenemez.");
            return;
        }

        if (bulunduguKat == kat) {
            int minKilo = 80;
            int maxKilo = 100;
            int kilo = new Random().nextInt(maxKilo - minKilo + 1) + minKilo;

            Kullanici yeniKullanici = new Kullanici(isim, kilo, bulunduguKat, gidilecekKat);

            System.out.println("Yolcu Ekleniyor: " + yeniKullanici.getBilgi());

            kullanicilar[toplamAgirlik / 100] = yeniKullanici;
            toplamAgirlik += kilo;
        } else {
            System.out.println("Asansor bulundugu kattaki kullanicıyı alabilir.");
        }
    }

    public void kullanicilariTasi() {
        if (toplamAgirlik > kapasite) {
            System.out.println("Asansor tasima kapasitesi asildi. Kullanicilar tasiniyor...");

            for (int i = 0; i < kullanicilar.length; i++) {
                if (kullanicilar[i] != null) {
                    int gidilecekKat = kullanicilar[i].getGidilecekKat();
                    while (kat != gidilecekKat) {
                        if (kat < gidilecekKat) {
                            goUp();
                        } else {
                            goDown();
                        }
                    }
                    System.out.println("Yolcu iniyor: " + kullanicilar[i].getBilgi());
                    kullanicilar[i] = null;
                    toplamAgirlik -= kullanicilar[i].getAgirlik();

                    if (sonYolcuIndirilsin) {
                        System.out.println("Son yolcu indirildi.");
                        break;
                    }
                }
            }
        } else {
            System.out.println("Asansor tasima kapasitesi asilmadi. Kullanicilar tasima islemi yapilmiyor.");
        }
    }

    public void setSonYolcuIndirilsin(boolean sonYolcuIndirilsin) {
        this.sonYolcuIndirilsin = sonYolcuIndirilsin;
    }

    private void goUp() {
        if (kat < 5) {
            kat++;
            System.out.println("Asansor " + kat + ". kata cikti.");
        } else {
            System.out.println("Asansor maksimum kata ulasti. Daha yukari cikamaz.");
        }
    }

    private void goDown() {
        if (kat > 0) {
            kat--;
            System.out.println("Asansor " + kat + ". kata indi.");
        } else {
            System.out.println("Asansor minimum kata ulasti. Daha asagi inemez.");
        }
    }

    private void openDoor() {
        if (!kapali) {
            System.out.println("Asansorun kapisı zaten acik.");
        } else {
            kapali = false;
            System.out.println("Asansorun kapisı acildi.");
        }
    }

    private void closeDoor() {
        if (kapali) {
            System.out.println("Asansorun kapisı zaten kapali.");
        } else {
            kapali = true;
            System.out.println("Asansorun kapisı kapandi.");
        }
    }

    private void kisiSayisiKontrol() {
        if (toplamAgirlik > kapasite) {
            System.out.println("Asansor tasima kapasitesi asildi.");
            kullanicilariTasi();
        }
    }

    private void bilgiGoster() {
        System.out.println("Asansor Bilgileri:");
        System.out.println("Bulundugu Kat: " + kat);
        System.out.println("Toplam Agirlik: " + toplamAgirlik + " kg");
        System.out.println("Kapali mi: " + kapali);

        System.out.println("\nAsansordeki Kullanicilar:");
        for (Kullanici kullanici : kullanicilar) {
            if (kullanici != null) {
                System.out.println(kullanici.getBilgi());
            }
        }
    }

    public static void main(String[] args) {
        Asansor asansor = new Asansor(1000);

        System.out.println("Asansorde bulunan katlar:");
        for (int i = 0; i <= 5; i++) {
            System.out.println(i + ". Kat");
        }

        while (true) {
            asansor.kullaniciEkle("Ahmet", 0, 3);
            asansor.kullaniciEkle("Ayse", 1, 4);
            asansor.kullaniciEkle("Mehmet", 0, 2);
            asansor.kullaniciEkle("Fatma", 2, 5);
            asansor.kisiSayisiKontrol();
            asansor.goUp();
            asansor.openDoor();
            asansor.closeDoor();
            asansor.kullanicilariTasi();
            boolean hepsiIndiMi = true;
            for (Kullanici kullanici : asansor.kullanicilar) {
                if (kullanici != null) {
                    hepsiIndiMi = false;
                    break;
                }
            }

            if (hepsiIndiMi) {
                asansor.setSonYolcuIndirilsin(true);
                break;
            }
        }
        asansor.bilgiGoster();

    }

}
