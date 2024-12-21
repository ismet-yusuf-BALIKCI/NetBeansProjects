import java.io.*;
import java.util.Scanner;


public class parse {
    public static void main(String[] args) throws Exception {

        String path = "/Users/kocyigit/Desktop/parse/src/programagiris.txt";
        File f1 = new File(path);

        if (f1.exists()) {

            Scanner input = new Scanner(System.in);
            System.out.println("Dosyanın Yeni Adını Giriniz:");
            String name = input.nextLine();
            String path2 = "/Users/kocyigit/Desktop/parse/src/" + name + ".txt";
            f1.renameTo(new File(path2));
            f1 = new File(path2);

            char[] printToChar = new char[(int) f1.length()];

            FileReader fr = new FileReader(path2);
            fr.read(printToChar);
            fr.close();

            String toString = new String(printToChar);

            String[] CS = toString.split("[\\n]");

            String[] CS2 = toString.split("[\\s,\\n]");

            for (String value : CS2) {

                System.out.println(value);

            }

            String[] atama = new String[]{"TOP", "CRP", "BOL", "CIK", "D", "DB", "DK", "DKE", "DBE", "DED", "DE", "HRK", "VE", "VEY", "DEG", "OKU", "YAZ"};
            String[] operand = new String[]{"AX", "BX", "CX", "DX", "ETIKET"};

            for (int i = 0; i < CS.length; i++) {

                //KOMUT KONTROLÜ

                int index = CS[i].indexOf(" ");

                if (index != -1 && index != 0) {

                    if (CS[i].substring(0, index).equals(atama[0]) || CS[i].substring(0, index).equals(atama[1]) ||
                            CS[i].substring(0, index).equals(atama[2]) || CS[i].substring(0, index).equals(atama[3]) ||
                            CS[i].substring(0, index).equals(atama[4]) || CS[i].substring(0, index).equals(atama[5]) ||
                            CS[i].substring(0, index).equals(atama[6]) || CS[i].substring(0, index).equals(atama[7]) ||
                            CS[i].substring(0, index).equals(atama[8]) || CS[i].substring(0, index).equals(atama[9]) ||
                            CS[i].substring(0, index).equals(atama[10]) || CS[i].substring(0, index).equals(atama[11]) ||
                            CS[i].substring(0, index).equals(atama[12]) || CS[i].substring(0, index).equals(atama[13]) ||
                            CS[i].substring(0, index).equals(atama[14]) || CS[i].substring(0, index).equals(atama[15]) ||
                            CS[i].substring(0, index).equals(atama[16])) {


                    } else {

                        System.out.println(i + 1 + ".satırda komut yanlış yazılmıştır. ");

                    }
                }else {

                    System.out.println(i + 1 + ".satırda komut yazılmamıştır.");

                }

                //

                //OPERAND(1.) KONTROLÜ

                if (CS[i].indexOf(" ") != -1) {

                    if (CS[i].contains(",")) {

                        int index2 = CS[i].split("[\\s]")[1].indexOf(",");

                        if (!CS[i].split("\s")[1].substring(0, index2).equals(operand[0])) {

                            if (!CS[i].split("\s")[1].substring(0, index2).equals(operand[1])) {

                                if (!CS[i].split("\s")[1].substring(0, index2).equals(operand[2])) {

                                    if (!CS[i].split("\s")[1].substring(0, index2).equals(operand[3])) {

                                        if (!CS[i].split("\s")[1].substring(0, index2).equals(operand[4])) {


                                            boolean isThere = false;

                                            for (int e = 0; e <= 10; e++) {

                                                if (CS[i].split("\s")[1].substring(0, index2).equals(operand[4] + e)) {

                                                    isThere = true;

                                                    break;
                                                }
                                            }

                                            if (!isThere) {

                                                if (CS[i].split("\s")[1].startsWith(",")) {

                                                    System.out.println(i + 1 + ".satırda 1.operand yazılmamış");

                                                } else {
                                                    System.out.println(i + 1 + ".satırda 1.operand yanlış yazılmış");
                                                }

                                            }
                                        }

                                    }
                                }
                            }
                        }
                    } else {

                        if (!CS[i].split("\s")[1].equals(operand[0])) {

                            if (!CS[i].split("\s")[1].equals(operand[1])) {

                                if (!CS[i].split("\s")[1].equals(operand[2])) {

                                    if (!CS[i].split("\s")[1].equals(operand[3])) {

                                        if (!CS[i].split("\s")[1].equals(operand[4])) {

                                            boolean isThere = false;

                                            for (int e = 0; e <= 10; e++) {

                                                if (CS[i].split("\s")[1].equals(operand[4] + e)) {

                                                    isThere = true;

                                                    break;
                                                }
                                            }
                                            if (!isThere) {

                                                System.out.println(i + 1 + ".satırda 1.operand yanlış yazılmış");

                                            }
                                        }

                                    }
                                }
                            }
                        }
                    }
                } else {

                    if (CS[i].contains(",")) {

                        if (CS[i].startsWith(",")) {

                            System.out.println(i + 1 + ".satırda 1.operand yazılmamış");

                        } else {

                            if (!CS[i].split(",")[0].equals(operand[0])) {

                                if (!CS[i].split(",")[0].equals(operand[1])) {

                                    if (!CS[i].split(",")[0].equals(operand[2])) {

                                        if (!CS[i].split(",")[0].equals(operand[3])) {

                                            if (!CS[i].split(",")[0].equals(operand[4])) {


                                                boolean isThere = false;

                                                for (int e = 0; e <= 10; e++) {

                                                    if (CS[i].split(",")[0].equals(operand[4] + e)) {

                                                        isThere = true;

                                                        break;
                                                    }
                                                }
                                                if (!isThere) {

                                                    System.out.println(i + 1 + ".satırda 1.operand yanlış yazılmış");

                                                }
                                            }

                                        }
                                    }
                                }
                            }

                        }


                    } else {

                        if (!CS[i].equals(operand[0])) {

                            if (!CS[i].equals(operand[1])) {

                                if (!CS[i].equals(operand[2])) {

                                    if (!CS[i].equals(operand[3])) {

                                        if (!CS[i].equals(operand[4])) {

                                            boolean isThere = false;

                                            for (int e = 0; e <= 10; e++) {

                                                if (CS[i].equals(operand[4] + e)) {

                                                    isThere = true;

                                                    break;
                                                }
                                            }
                                            if (!isThere) {

                                                System.out.println(i + 1 + ".satırda 1.operand yanlış yazılmış");

                                            }
                                        }

                                    }
                                }
                            }
                        }
                    }

                }

                //

                //OPERAND(2.) KONTROLÜ

                // EKSİK OPERAND KONTROLÜ

                if (CS[i].endsWith(",")) {

                    System.out.println(i + 1 + ". satırda 2.operand eksik");

                }

                //

                else {

                    if (CS[i].contains(",") && !CS[i].split(",")[1].contains("[") && !CS[i].split(",")[1].contains("]")) {

                        if (!(CS[i].split(",")[1].equals(operand[0]))) {

                            if (!(CS[i].split(",")[1].equals(operand[1]))) {

                                if (!(CS[i].split(",")[1].equals(operand[2]))) {

                                    if (!(CS[i].split(",")[1].equals(operand[3]))) {

                                        if (!(CS[i].split(",")[1].equals(operand[4]))) {

                                            boolean isThere = false;

                                            for (int e = 0; e <= 10; e++) {

                                                if ((CS[i].split(",")[1].equals(operand[4] + e))) {

                                                    isThere = true;

                                                    break;
                                                }
                                            }

                                            if (!isThere) {

                                                try {

                                                    int operand2 = Integer.parseInt(CS[i].split(",")[1]);


                                                } catch (Exception e) {

                                                    System.out.println(i + 1 + ".satırda 2.operand yanlış yazılmış");

                                                }

                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }


                
            }

        }
    }
}
