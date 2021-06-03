package com.solution.goncharova;

//import org.apache.logging.log4j.LogManager;

public class Ex3 {
    //private static final org.apache.logging.log4j.Logger LOG4j2 = LogManager.getLogger(Ex3.class);

    public static void main( String[] args ) {
       findSumOfEvenNegNum();
    }

    private static void findSumOfEvenNegNum ( ) {
        int numbers[] = {92,  -4, -1, 89,-2};
        int result = 0;
        for(int x : numbers){
            if(x % 2 == 0 && x < 0){
                result += x;
            }
        }
       // LOG4j2.info(result);
        System.out.println(result);

    }
}
