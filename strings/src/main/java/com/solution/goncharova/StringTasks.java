package com.solution.goncharova;

import org.apache.logging.log4j.LogManager;
/**
 * Class for solving tasks using a  String class.
 * Solves different tasks like finding quantity of digits and etc...
 *
 * @author Goncharova Anna
 * @version 1.1
 */

public class StringTasks {

    private static final org.apache.logging.log4j.Logger LOG4j2 = LogManager.getLogger(StringTasks.class);

    /**The function outputs the numbers of characters that match the last character of the string.
     *
     * @param string - given string.
     */
    public static void findNumOfSymbolsTask1(String string) {
        StringBuilder str = new StringBuilder(string);
        int lastSyb = str.charAt(str.length() - 1);
        for (int i = 0; i < str.length(); i++) {
            if (lastSyb == str.charAt(i)) {
                LOG4j2.info("The numbers of characters that match the last character of the string " + i);
            }
        }
    }

    /**The function outputs quantity of digits in the string.
     *
     * @param string - given string.
     */
    public static void findQuantityOfDigitsTask2( String string) {
        int count = 0;
        for (int i = 0; i < string.length(); i++) {
            char evenElement = string.charAt(i);
            if (Character.isDigit(evenElement)) {
                count++;
            }
        }
        LOG4j2.info(" Quantity of digits is " + count);
    }

    /**The function outputs quantity of digits from one to five in the string.
     *
     * @param string - given string.
     */
    public static void findQuantityOfDigitsFromOneToFiveTask3 (String string) {
        int count = 0;
        for (int i = 0; i < string.length(); i++) {
            char evenElement = string.charAt(i);
            if (Character.isDigit(evenElement)) {
                int num = Integer.parseInt(String.valueOf(evenElement));
                if ( num<=5 && num!=0) {
                    count++;
                }
            }
        }
        LOG4j2.info(" Quantity of digits from one to five is " + count);
    }

    /**The function outputs string without "abc" if after that there is a number.
     *
     * @param string - given string.
     */
    public static void deleteLettersTask4(String string) {
        StringBuffer substring = new StringBuffer(string);
        int index = string.indexOf("abc");
        int index2 = index + 3;
        if (Character.isDigit(string.charAt(index2))) {
            substring.delete(index, index2);
            LOG4j2.info("String without abc if after that there is a number "+ substring);
        }
    }

    /**The function outputs sum of digits of the string.
     *
     * @param string - given string.
     */
    public static void findSumOfDigitsTask5(String string) {
        int sum = 0;
        for (int i = 0; i < string.length(); i++) {
            char evenElement = string.charAt(i);
            if (Character.isDigit(evenElement)) {
                int num = Integer.parseInt(String.valueOf(evenElement));
                sum += num;
            }
        }
        LOG4j2.info("Sum of digits " + sum);
    }
}
