package hesapmakinesi;

import java.util.Scanner;

public class Hesapmakinesi {

    public static void main(String[] args) {
        System.out.println("1. sayiyi giriniz:");
        Scanner scan = new Scanner(System.in);
        int sayı1 = scan.nextInt();
        
        System.out.println("2. sayiyi giriniz:");
        int sayı2 = scan.nextInt();
        System.out.println("Islem seciniz\n toplama icin 1\n cikarma icin 2\n carpma icin 3 \n bolme icin 4 yaziniz");
        int seçenek =scan.nextInt();
        
        
        switch (seçenek) {
            case 1:
            int toplam = sayı1+sayı2;
                System.out.println("toplam ="+toplam);
                break;

        }
    
    
    }

}
