package Palindromkelime;

import java.util.Scanner;

public class Palindromkelime {

    public static void main(String[] args) {
        System.out.println("Kelime giriniz");
        Scanner scan = new Scanner(System.in);
        String a = scan.nextLine();
        char[] dizi = new char[a.length()];
        for (int i = 0; i < a.length(); i++) {
            dizi[i] = a.charAt(i);
        }
        int son = a.length() - 1;
        boolean isPalindrome = true;

        for (int i = 0; i <= a.length() / 2; i++) {
            if (dizi[son--] != dizi[i]) {
                isPalindrome = false;
                break;
            }
        }

        if (isPalindrome) {
            System.out.println("Girilen kelime bir palindromdur.");
        } else {
            System.out.println("Girilen kelime bir palindrom değildir.");
        }
    }
}
