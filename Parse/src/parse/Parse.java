package parse;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class Parse {

    public static void main(String[] args) {
        Scanner tarayici = new Scanner(System.in);
        System.out.print("Dosya adini yolu ile girin: ");
        String dosyaAdi = tarayici.nextLine();
        
        String[] satirlar = new String[100];
        int satirSayisi = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(dosyaAdi))) {
            String satir;
            while ((satir = br.readLine()) != null) {
                satirlar[satirSayisi++] = satir;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (int i = 0; i < satirSayisi; i++) {
            String sonuc = ayrıştır(satirlar[i]);
            System.out.println("Satir " + (i + 1) + ": " + sonuc);
        }
    } 
    
    public static String ayrıştır(String satir) {
        String[] komutlar = {"TOP", "CIK", "BOL", "CRP"};
        String[] operandlar = {"AX", "BX", "CX", "DX"};
        
        String komut = "";
        String operand = "";

        int boslukIndeksi = satir.indexOf(' ');
        if (boslukIndeksi != -1) {
            komut = satir.substring(0, boslukIndeksi);
            operand = satir.substring(boslukIndeksi + 1);
        } else {
            komut = satir;
        }

        if (!gecerliKomutMu(komut, komutlar)) {
            return "Hatali komut formati veya komut bulunamadi: " + satir;
        }
        
        String[] operandlarDizisi = operandlariAyir(operand);
        if (operandlarDizisi.length != 2 || !gecerliOperandMi(operandlarDizisi[0], operandlar) || !gecerliOperandMi(operandlarDizisi[1], operandlar)) {
            return "Hatali operand formaiı: " + satir;
        }
        
        return "Gecerli: " + satir;
    }

    public static boolean gecerliKomutMu(String komut, String[] komutlar) {
        for (String gecerliKomut : komutlar) {
            if (komut.equals(gecerliKomut)) {
                return true;
            }
        }
        return false;
    }

    public static boolean gecerliOperandMi(String operand, String[] operandlar) {
        for (String gecerliOperand : operandlar) {
            if (operand.equals(gecerliOperand)) {
                return true;
            }
        }
        return sayiMi(operand);
    }

    public static String[] operandlariAyir(String operand) {
        int virgulIndeksi = operand.indexOf(',');
        if (virgulIndeksi == -1) {
            return new String[0]; 
        }
        String operand1 = operand.substring(0, virgulIndeksi);
        String operand2 = operand.substring(virgulIndeksi + 1);
        return new String[]{operand1, operand2};
    }

    public static boolean sayiMi(String ifade) {
        if (ifade.isEmpty()) return false;
        for (int i = 0; i < ifade.length(); i++) {
            if (!Character.isDigit(ifade.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
