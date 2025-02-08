package execution;

import java.io.*;
import java.util.Stack;
import java.util.Scanner;

/*  C:\Users\CASPER\Documents\GitHub\HTML_DERS\Execution\src\dosya1.txt  */
public class Execution {

    int zeroflag = 0, signflag = 0;
    int AX;
    int BX;
    int CX;
    int DX;
    int index;
    int index2;
    String a;

    final String TOP = "TOP";
    final String OKU = "OKU";
    final String YAZ = "YAZ";
    final String CIK = "CIK";
    final String CRP = "CRP";
    final String BOL = "BOL";
    final String HRK = "HRK";
    final String VE = "VE";
    final String VEY = "VEY";
    final String D = "D";
    final String DB = "DB";
    final String DK = "DK";
    final String DBE = "DBE";
    final String DKE = "DKE";
    final String DED = "DED";
    final String DE = "DE";
    final String SON = "SON";
    final String ETIKET1 = "ETIKET1";
    final String ETIKET2 = "ETIKET2";
    final String ETIKET3 = "ETIKET3";
    final String ETIKET4 = "ETIKET4";
    final String ETIKET5 = "ETIKET5";
    final String ETIKET6 = "ETIKET6";
    final String ETIKET7 = "ETIKET7";
    final String ETIKET8 = "ETIKET8";
    final String ETIKET9 = "ETIKET9";
    final String ETIKET10 = "ETIKET10";

    static Stack<String> yıgıt = new Stack<>();

    public static void main(String[] args) {
        Scanner imp = new Scanner(System.in);

        System.out.println("Dosya yolunu giriniz : ");
        String pathName = imp.nextLine();

        try {
            File file = new File(pathName);
            FileReader fileReader = new FileReader(file);
            BufferedReader br = new BufferedReader(fileReader);

            int i = 0;
            String line;
            String[] aktarim;
            String[] CS = new String[100];

            while ((line = br.readLine()) != null) {
                aktarim = line.split("[\\s,:]+");

                for (String word : aktarim) {
                    CS[i] = word;
                    i++;
                }
            }

            for (int j = CS.length - 1; j >= 0; j--) {
                yıgıt.push(CS[j]);
            }

            br.close();
            fileReader.close();
            Execution e = new Execution();
            e.kontrol(yıgıt);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void kontrol(Stack<String> yıgıt) {
        index = yıgıt.size() - 1;
        while (index >= 0) {
            String komut = yıgıt.get(index);

            Scanner input = new Scanner(System.in);
            System.out.println("komut" + komut);
            switch (komut) {

                case OKU:
                    int op1_oku = parseOperand(yıgıt.get(--index));
                    if (op1_oku == AX) {
                        AX = input.nextInt();
                        --index;
                        break;
                    } else if (op1_oku == BX) {
                        BX = input.nextInt();
                        --index;
                        break;
                    } else if (op1_oku == CX) {
                        CX = input.nextInt();
                        --index;
                        break;
                    } else if (op1_oku == DX) {
                        DX = input.nextInt();
                        --index;
                        break;
                    }
                    break;

                case TOP:
                    a = yıgıt.get(--index);
                    int op1_top = parseOperand(yıgıt.get(index));
                    int op2_top = parseOperand(yıgıt.get(--index));
                    index--;
                    op1_top = op1_top + op2_top;
                    controlOperand(op1_top, a);
                    arithmeticConrtol(op1_top);
                    System.out.println(" AX: " + AX + ", BX: " + BX + ", CX: " + CX + ", DX: " + DX);

                    break;

                case YAZ:
                    a = yıgıt.get(--index);
                    int op1_yaz = parseOperand(yıgıt.get(index));
                    controlOperand(op1_yaz, a);
                    System.out.println("operant " + op1_yaz);
                    index--;
                    break;

                case CIK:
                    a = yıgıt.get(--index);
                    int op1_cik = parseOperand(yıgıt.get(index));
                    int op2_cik = parseOperand(yıgıt.get(--index));
                    op1_cik = op1_cik - op2_cik;
                    updateFlags(op1_cik, op2_cik);
                    controlOperand(op1_cik, a);
                    arithmeticConrtol(op1_cik);
                    System.out.println(" AX: " + AX + ", BX: " + BX + ", CX: " + CX + ", DX: " + DX);

                    index--;
                    break;

                case CRP:
                    a = yıgıt.get(--index);
                    int op1_crp = parseOperand(yıgıt.get(index));
                    int op2_crp = parseOperand(yıgıt.get(--index));
                    op1_crp = op1_crp * op2_crp;
                    controlOperand(op1_crp, a);
                    arithmeticConrtol(op1_crp);
                    System.out.println(" AX: " + AX + ", BX: " + BX + ", CX: " + CX + ", DX: " + DX);
                    index--;
                    break;

                case BOL:
                    a = yıgıt.get(--index);
                    int op1_bol = parseOperand(yıgıt.get(index));
                    int op2_bol = parseOperand(yıgıt.get(--index));
                    if (op2_bol == 0) {
                        System.out.println("Tanımsız");
                    }
                    op1_bol = op1_bol / op2_bol;
                    controlOperand(op1_bol, a);
                    arithmeticConrtol(op1_bol);
                    System.out.println(" AX: " + AX + ", BX: " + BX + ", CX: " + CX + ", DX: " + DX);
                    index--;
                    break;

                case HRK:
                    String destOperand = yıgıt.get(--index);
                    int srcValue = parseOperand(yıgıt.get(--index));
                    index--;
                    if (destOperand.equals("AX")) {
                        AX = srcValue;
                    } else if (destOperand.equals("BX")) {
                        BX = srcValue;
                    } else if (destOperand.equals("CX")) {
                        CX = srcValue;
                    } else if (destOperand.equals("DX")) {
                        DX = srcValue;
                    } else {
                        System.err.println("Geçersiz hedef kayıt: " + destOperand);
                    }
                    break;

                case VE:
                    int op1_ve = parseOperand(yıgıt.get(--index));
                    int op2_ve = parseOperand(yıgıt.get(--index));
                    op1_ve = op1_ve & op2_ve;
                    index--;
                    break;

                case VEY:
                    int op1_vey = parseOperand(yıgıt.get(--index));
                    int op2_vey = parseOperand(yıgıt.get(--index));
                    op1_vey = op1_vey | op2_vey;
                    index--;
                    break;

                case D:
                    String etiket_d = yıgıt.get(--index);
                    index--;
                    break;

                case DB:
                    String etiket_db = yıgıt.get(--index);
                    if (signflag == 0 && zeroflag == 0) {
                        index--;
                    } else {
                        jumpToLabel(etiket_db);
                        index--;
                    }
                    break;

                case DK:
                    String etiket_dk = yıgıt.get(--index);
                    if (signflag == 1 && zeroflag == 0) {
                        index--;
                    } else {
                        jumpToLabel(etiket_dk);
                        index--;
                    }
                    break;

                case DBE:
                    String etiket_dbe = yıgıt.get(--index);
                    if (signflag == 1 && zeroflag == 0 || signflag == 1 && zeroflag == 1) {
                        index--;
                    } else {
                        jumpToLabel(etiket_dbe);
                        index--;
                    }
                    break;

                case DKE:
                    String etiket_dke = yıgıt.get(--index);
                    if (signflag == 0 && zeroflag == 0 || signflag == 0 && zeroflag == 1) {
                        index--;
                    } else {
                        jumpToLabel(etiket_dke);
                        index--;
                    }
                    break;

                case DE:
                    String etiket_de = yıgıt.get(--index);
                    if (signflag == 0 && zeroflag == 0 || signflag == 0 && zeroflag == 1) {
                        index--;
                    } else {
                        jumpToLabel(etiket_de);
                        index--;
                    }
                    break;

                case DED:
                    String etiket_ded = yıgıt.get(--index);
                    if (signflag == 0 && zeroflag == 0 || signflag == 1 && zeroflag == 0) {
                        index--;
                    } else {
                        jumpToLabel(etiket_ded);
                        index--;
                    }
                    break;

                case SON:
                    index--;

                case ETIKET1:
                    index--;
                    break;
                case ETIKET2:
                    index--;
                    break;
                case ETIKET3:
                    index--;
                    break;
                case ETIKET4:
                    index--;
                    break;
                case ETIKET5:
                    index--;
                    break;
                case ETIKET6:
                    index--;
                    break;
                case ETIKET7:
                    index--;
                    break;
                case ETIKET8:
                    index--;
                    break;
                case ETIKET9:
                    index--;
                    break;
                case ETIKET10:
                    index--;
                    break;

                default:
                    break;
            }
        }

    }

    public int parseOperand(String operand) {
        if ("OKU".equals(operand)) {
            System.out.println("SAYI GIRINIZ");
            Scanner scanner = new Scanner(System.in);
            return scanner.nextInt();
        }

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

    public void controlOperand(int operand, String value) {
        switch (value) {
            case "AX":
                AX = operand;
                break;
            case "BX":
                BX = operand;
                break;
            case "CX":
                CX = operand;
                break;
            case "DX":
                DX = operand;
                break;
        }
    }

    public void arithmeticConrtol(int value) {
        if (value < -128 || value > 127) {
            System.err.println("Uyarı: Aritmetik sınır aşıldı! Sonuç: " + value);
        }
    }

    private void updateFlags(int op1, int op2) {
        if (op1 < op2) {
            signflag = 1;
            zeroflag = 0;
        } else if (op1 > op2) {
            signflag = 0;
            zeroflag = 0;
        } else if (op1 == op2) {
            signflag = 0;
            zeroflag = 1;
        }
    }

    private void jumpToLabel(String label) {
        int sayac = 0;
        index2 = index;
        while (sayac != 1) {
            String poppedItem = yıgıt.get(++index2);
            if (poppedItem != null && poppedItem.equals(label)) {
                sayac++;
            }
        }
        index = index2;
    }
}
