package com.mycompany.mavenproject1;

import java.util.Random;

public class NewClass {

    public static void main(String[] args) {
        int[] d = new int[1000];

        Random r = new Random();

        for (int i = 0; i < 1000; i++) {
            d[i] = r.nextInt(1000);
        }

        Mavenproject1 s = new Mavenproject1(d);
        s.yazdir();

        System.out.println("\nBubleshort calısma suresi" + s.BubbleSort());
        s.yazdir();

        System.out.println("\nSelectionSort calısma suresi" + s.SelectionSort());

        s.yazdir();

        System.out.println("\nInsertionSort calısma suresi" + s.InsertionSort());

        s.yazdir();

        System.out.println("\nMergeSort calısma suresi" + s.MergeSort());

        s.yazdir();
    }

}
