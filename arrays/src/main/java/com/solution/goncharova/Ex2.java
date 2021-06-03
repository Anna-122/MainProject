package com.solution.goncharova;

public class Ex2 {
    public static void main( String[] args ) {
        findMinMax();

    }

    private static void findMinMax ( ) {
        int numbers[] = {92, - 1, 2, 12, 89};
        int min, max;
        min = max = numbers[0];

        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] < min)
                min = numbers[i];
            if (numbers[i] > max) {
                max = numbers[i];
            }
        }
        System.out.println("min is: " + min + "; max is: " + max);
                 int newMin = max;
                 int newMax =min;

        System.out.println("new min is: " + newMin + "; new max is: " +newMax);
    }
}
