package com.solution.goncharova;

public class Ex1 {
    public static void main( String[] args ) {
        outputLargerEl();
    }

    private static void outputLargerEl ( ) {
        int[] elements = new int[] { 1,3,2,5,7  };
        for (int i = 1; i < elements.length; i++) {
            if(elements[i] > elements[i-1]){
                System.out.println( "Outputting element that is larger than the previous one "+ elements[i]);
            }

        }
    }
}
