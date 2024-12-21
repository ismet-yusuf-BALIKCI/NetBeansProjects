package asansor;

public class Kullanici {
    private String isim;
    private int kilo;
    private int bulunduguKat;
    private int gidilecekKat;

    public Kullanici(String isim, int kilo, int bulunduguKat, int gidilecekKat) {
        this.isim = isim;
        this.kilo = kilo;
        this.bulunduguKat = bulunduguKat;
        this.gidilecekKat = gidilecekKat;
    }

    public String getIsim() {
        return isim;
    }

    public int getKilo() {
        return kilo;
    }

    public int getBulunduguKat() {
        return bulunduguKat;
    }

    public int getGidilecekKat() {
        return gidilecekKat;
    }

    public String getBilgi() {
        return isim + " - Kilo: " + kilo + " kg - Bulundugu Kat: " + bulunduguKat + " - Gidilecek Kat: " + gidilecekKat;
    }
}


