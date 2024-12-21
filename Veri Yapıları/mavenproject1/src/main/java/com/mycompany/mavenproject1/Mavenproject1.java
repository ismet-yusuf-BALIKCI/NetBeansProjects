package com.mycompany.mavenproject1;

import static java.time.Clock.system;
import static java.time.InstantSource.system;
import java.util.Arrays;

public class Mavenproject1 {

    int[] dizi;
    int n;

    public Mavenproject1(int[] d) {
        dizi = d;
        n = d.length;
    }

    public long BubbleSort() {
        long a = System.currentTimeMillis();
        int tmp = 0;
        boolean isSwapped = true;

        for (int i = 0; i < dizi.length && isSwapped; i++) {
            isSwapped = false;
            for (int j = 0; j < (dizi.length - 1) - i; j++) {
                if (dizi[j] > dizi[j + 1]) {
                    tmp = dizi[j];
                    dizi[j] = dizi[j + 1];
                    dizi[j + 1] = tmp;
                    isSwapped = true;
                }
            }
        }
        long b = System.currentTimeMillis();

        return b - a;
    }

    public long SelectionSort() {
        long a = System.currentTimeMillis();

        int min = 0;
        int tmp = 0;
        int i;
        for (i = 0; i < dizi.length; i++) {
            min = i;

            for (int j = i + 1; j < dizi.length; j++) {
                if (dizi[j] < dizi[min]) {
                    min = j;
                }
            }
            if (min != i) {
                tmp = dizi[min];
                dizi[min] = dizi[i];
                dizi[i] = tmp;
            }
        }
        long b = System.currentTimeMillis();
        return b - a;

    }

    public long InsertionSort() {
        long a = System.currentTimeMillis();

        int t = 0, i = 0, j = 0;

        for (i = 0; i < dizi.length; i++) {
            t = dizi[i];
            for (j = i; j > 0 && dizi[j - 1] > t; j--) {
                dizi[j] = dizi[j - 1];
            }
            dizi[j] = t;
        }
        long b = System.currentTimeMillis();

        return b - a;
    }

    public long MergeSort() {
        long a = System.currentTimeMillis();
        
        mergeSortHelper(dizi, 0, dizi.length - 1);
        long b = System.currentTimeMillis();

        return b - a;
    }

    private void mergeSortHelper(int[] dizi, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;

            mergeSortHelper(dizi, left, mid);
            mergeSortHelper(dizi, mid + 1, right);
            merge(dizi, left, mid, right);
        }
    }

    private void merge(int[] dizi, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        for (int i = 0; i < n1; i++) {
            leftArray[i] = dizi[left + i];
        }
        for (int j = 0; j < n2; j++) {
            rightArray[j] = dizi[mid + 1 + j];
        }

        int i = 0, j = 0, k = left;

        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                dizi[k] = leftArray[i];
                i++;
            } else {
                dizi[k] = rightArray[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            dizi[k] = leftArray[i];
            i++;
            k++;
        }

        while (j < n2) {
            dizi[k] = rightArray[j];
            j++;
            k++;
        }
    }
    
    public void yazdir() {
        System.out.println(Arrays.toString(dizi));
    }

}
