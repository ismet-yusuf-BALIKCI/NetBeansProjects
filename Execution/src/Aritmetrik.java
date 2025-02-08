import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Aritmetrik {

    static int AX;
    static int BX;
    static int CX;
    static int DX;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Dosya bağlantısı girin: ");
        String dosya = scanner.nextLine();

        try (BufferedReader br = new BufferedReader(new FileReader(dosya))) {
            String satir;
            while ((satir = br.readLine()) != null) {
                dosyayiparcala(satir.trim());
            }
        } catch (IOException e) {
            System.out.println("Dosyadaki veriler okunamadı!");
        }
    }

    public static void dosyayiparcala(String satir) {
        String[] dosyayiparcala = satir.split(" ");
        String islem = dosyayiparcala[0];
        String[] operandlar = dosyayiparcala[1].split(",");

        String operand1 = operandlar[0];
        String operand2 = operandlar[1];

        switch (islem) {
            case "HRK":
                HRK(operand1, operand2);
                break;
            case "TOP":
                TOP(operand1, operand2);
                break;
            case "CIK":
                CIK(operand1, operand2);
                break;
            case "CARP":
                CARP(operand1, operand2);
                break;
            case "BOL":
                BOL(operand1, operand2);
                break;
            default:
                System.out.println("Hatalı komut: " + islem);
        }
    }

    public static void HRK(String operand1, String value) {
        int val = Integer.parseInt(value);
        switch (operand1) {
            case "AX":
                AX = val;
                break;
            case "BX":
                BX = val;
                break;
            case "CX":
                CX = val;
                break;
            case "DX":
                DX = val;
                break;
            default:
                System.out.println("Hatalı operand: " + operand1);
        }
        System.out.println(operand1 + "= " + val);
        bitKontrol(val);
    }

    public static boolean sayikontrol(String satir) {
        try {
            Integer.parseInt(satir);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void bitKontrol(int deger) {
        if (deger < 0 || deger > 255) {
            System.out.println("8-bit'i aştı: " + deger);
            System.exit(1);
        }
    }

    public static void TOP(String operand1, String operand2) {
        int val = getOperandValue(operand2);
        switch (operand1) {
            case "AX":
                AX += val;
                System.out.println("AX= " + AX);
                bitKontrol(AX);
                break;
            case "BX":
                BX += val;
                System.out.println("BX= " + BX);
                bitKontrol(BX);
                break;
            case "CX":
                CX += val;
                System.out.println("CX= " + CX);
                bitKontrol(CX);
                break;
            case "DX":
                DX += val;
                System.out.println("DX= " + DX);
                bitKontrol(DX);
                break;
            default:
                System.out.println("Hatalı operand: " + operand1);
        }
    }

    public static void CIK(String operand1, String operand2) {
        int val = getOperandValue(operand2);
        switch (operand1) {
            case "AX":
                AX -= val;
                System.out.println("AX= " + AX);
                bitKontrol(AX);
                break;
            case "BX":
                BX -= val;
                System.out.println("BX= " + BX);
                bitKontrol(BX);
                break;
            case "CX":
                CX -= val;
                System.out.println("CX= " + CX);
                bitKontrol(CX);
                break;
            case "DX":
                DX -= val;
                System.out.println("DX= " + DX);
                bitKontrol(DX);
                break;
            default:
                System.out.println("Hatalı operand: " + operand1);
        }
    }

    public static void CARP(String operand1, String operand2) {
        int val = getOperandValue(operand2);
        switch (operand1) {
            case "AX":
                AX *= val;
                System.out.println("AX= " + AX);
                bitKontrol(AX);
                break;
            case "BX":
                BX *= val;
                System.out.println("BX= " + BX);
                bitKontrol(BX);
                break;
            case "CX":
                CX *= val;
                System.out.println("CX= " + CX);
                bitKontrol(CX);
                break;
            case "DX":
                DX *= val;
                System.out.println("DX= " + DX);
                bitKontrol(DX);
                break;
            default:
                System.out.println("Hatalı operand: " + operand1);
        }
    }

    public static void BOL(String operand1, String operand2) {
        int val = getOperandValue(operand2);
        if (val == 0) {
            System.out.println("0'a bölme hatası!");
            return;
        }
        switch (operand1) {
            case "AX":
                AX /= val;
                System.out.println("AX= " + AX);
                bitKontrol(AX);
                break;
            case "BX":
                BX /= val;
                System.out.println("BX= " + BX);
                bitKontrol(BX);
                break;
            case "CX":
                CX /= val;
                System.out.println("CX= " + CX);
                bitKontrol(CX);
                break;
            case "DX":
                DX /= val;
                System.out.println("DX= " + DX);
                bitKontrol(DX);
                break;
            default:
                System.out.println("Hatalı operand: " + operand1);
        }
    }

    public static int getOperandValue(String operand) {
        switch (operand) {
            case "AX":
                return AX;
            case "BX":
                return BX;
            case "CX":
                return CX;
            case "DX":
                return DX;
            default:
                return Integer.parseInt(operand);
        }
    }
}
