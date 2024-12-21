package dosyaokuyucu;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class DosyaOkuyucu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Okunacak dosyanın yolunu girin: ");
        String dosyaYolu = scanner.nextLine();

        // Geçerli komutlar ve operantlar
        String[] komutlar = {"TOP", "CRP", "CIK", "BOL"};
        String[] operantlar = {"AX", "BX", "CX", "DX"};

        // Dosyayı okuyup satırları kontrol etme
        try (BufferedReader br = new BufferedReader(new FileReader(dosyaYolu))) {
            String satir;
            int satirNumarasi = 1;
            while ((satir = br.readLine()) != null) {
                if (!satirKontrol(satir, komutlar, operantlar)) {
                    System.out.println("Hatalı satır " + satirNumarasi + ": " + satir);
                }
                satirNumarasi++;
            }
        } catch (IOException e) {
            System.out.println("Dosya okunurken bir hata oluştu: " + e.getMessage());
        }
    }

    // Satırın doğru formatta olup olmadığını kontrol eden metod
    public static boolean satirKontrol(String satir, String[] komutlar, String[] operantlar) {
        // Satırı parçalarına ayırma
        String[] parcalar = satir.trim().split("\\s+|,\\s*");
        
        // Komut ve iki operant var mı kontrolü
        if (parcalar.length != 3) {
            return false;
        }

        String komut = parcalar[0];
        String op1 = parcalar[1];
        String op2 = parcalar[2];

        // Komut geçerli mi?
        if (!isInArray(komut, komutlar)) {
            return false;
        }

        // Operantlar geçerli mi?
        if (!isInArray(op1, operantlar) && !isInteger(op1)) {
            return false;
        }
        if (!isInArray(op2, operantlar) && !isInteger(op2)) {
            return false;
        }

        return true;
    }

    // Dizide elemanın olup olmadığını kontrol eden metod
    public static boolean isInArray(String value, String[] array) {
        for (String element : array) {
            if (element.equals(value)) {
                return true;
            }
        }
        return false;
    }

    // Integer olup olmadığını kontrol eden metod
    public static boolean isInteger(String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}