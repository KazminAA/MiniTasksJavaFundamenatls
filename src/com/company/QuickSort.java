package com.company;

import java.util.Comparator;
import java.util.Random;

public class QuickSort {
    public static final Random RND = new Random();

    private void swap(Object[] array, int i, int j) {
        Object tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    private int partition(Object[] array, int begin, int end, Comparator cmp) {
        int index = begin + RND.nextInt(end - begin + 1);
        Object pivot = array[index];
        swap(array, index, end);
        for (int i = index = begin; i < end; ++i) {
            if (cmp.compare(array[i], pivot) <= 0) {
                swap(array, index++, i);
            }
        }
        swap(array, index, end);
        return (index);
    }

    private void qsort(Object[] array, int begin, int end, Comparator cmp) {
        if (end > begin) {
            int index = partition(array, begin, end, cmp);
            qsort(array, begin, index - 1, cmp);
            qsort(array, index + 1, end, cmp);
        }
    }

    public void sort(Object[] array, Comparator cmp) {
        qsort(array, 0, array.length - 1, cmp);
    }

    private void qs(Object[] array, Comparator cmp, int begin, int end) {
        int midIndex = begin + end >> 1;
        Object midVal = array[midIndex];
        int innerLeft = begin;
        int innerRight = end;

        while (innerLeft <= innerRight) {
            while (cmp.compare(array[innerLeft], midVal) < 0) innerLeft++;
            while (cmp.compare(array[innerRight], midVal) > 0) innerRight--;
            if (innerLeft <= innerRight) {
                swap(array, innerLeft, innerRight);
                innerLeft++;
                innerRight--;
            }
        }

        if (begin < innerRight) qs(array, cmp, begin, innerRight);
        if (end > innerLeft) qs(array, cmp, innerRight, end);
    }

    public void sort2(Object[] array, Comparator cmp) {
        qs(array, cmp, 0, array.length - 1);
    }
}
