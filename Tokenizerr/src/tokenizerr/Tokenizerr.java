
package tokenizerr;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;


public class Tokenizerr {

    
    public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);
        System.out.print("Dosya yolunu girin: ");
        String dosyaAdi = scanner.nextLine();
        
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
    }
            for (int i = 0; i < satirSayisi; i++) {
            System.out.println(kelimeleştir(satirlar[i]));
        }
    
    
    public void kelimeleştir(String satir){
    char[] karakterler = new char[satir.length() * 2]; 
        int index = 0;
     for (int i = 0; i < satir.length(); i++) {
            char karakter = satir.charAt(i);
            if (karakter == '+' || karakter == '-' || karakter == '*' || karakter == '/' || karakter == '(' || karakter == ')') {
                if (index > 0 && karakterler[index - 1] != ' ') {
                    karakterler[index++] = ' ';
                }
                karakterler[index++] = karakter;
                karakterler[index++] = ' ';
            } else {
                karakterler[index++] = karakter;
            }
        }

        int yeniUzunluk = 0;
        boolean bosluk = false;
        for (int i = 0; i < index; i++) {
            if (karakterler[i] != ' ') {
                karakterler[yeniUzunluk++] = karakterler[i];
                bosluk = false;
            } else if (!bosluk) {
                karakterler[yeniUzunluk++] = ' ';
                bosluk = true;
            }
        }

        if (yeniUzunluk > 0 && karakterler[yeniUzunluk - 1] == ' ') {
            yeniUzunluk--;
        }

        return new String(karakterler, 0, yeniUzunluk);
    }
}