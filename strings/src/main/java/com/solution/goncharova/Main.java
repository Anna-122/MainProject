/*
 * StringTasks and Regular tasks
 *
 * Version 1.2
 *
 * Copyright 2020. Anna Goncharova. GPL
 *
 */
package com.solution.goncharova;

/**
 * Class {@code Main}
 * Was created to see difference between String class & Regular expressions
 *
 * @author Goncharova Anna
 * @version 1.2
 */
public class Main {
    public static void main( String[] args ) {

        /**The function outputs the numbers of characters that match the last character of the string.
         *
         * @param string - given string.
         */
        StringTasks.findNumOfSymbolsTask1("ohello");

        /**The function outputs quantity of digits in the string.
         *
         * @param string - given string.
         */
        StringTasks.findQuantityOfDigitsTask2("0uh8yf9f");

        /**The function outputs quantity of digits from one to five in the string.
         *
         * @param string - given string.
         */
        StringTasks.findQuantityOfDigitsFromOneToFiveTask3 ("uh1y5f9f4");

        /**The function outputs string without "abc" if after that there is a number.
         *
         * @param string - given string.
         */
        StringTasks.deleteLettersTask4("abc7hhhh");

        /**The function outputs sum of digits of the string.
         *
         * @param string - given string.
         */
        StringTasks.findSumOfDigitsTask5("abc7hh1hh");

        /**The function outputs the numbers of characters that match the last character of the string.
         *
         * @param string - given string.
         */
        RegTasks.findNumOfSymbolsTask1("hoello");

        /**The function outputs quantity of digits in the string.
         *
         * @param string - given string.
         */
        RegTasks.findQuantityOfDigitsTask2("1jj8j2");

        /**The function outputs quantity of digits from one to five in the string.
         *
         * @param string - given string.
         */
        RegTasks.findQuantityOfDigitsFromOneToFiveTask3("1j61j58j2");

        /**The function outputs string without "abc" if after that there is a number.
         *
         * @param string - given string.
         */
        RegTasks.deleteLetters("abc1j58j2");

        /**The function outputs sum of digits of the string.
         *
         * @param string - given string.
         */
        RegTasks.findSumOfDigits("a1bc1jj2");

        /**The function outputs string without extra geps.
         *
         * @param string - given string.
         */
        RegTasks.removeExtraGeps("a1b   c1jj2 ");

        /**The function outputs modified string .
         *
         * @param string - given string.
         */
        RegTasks.replaceWord("oooowordkkwordkk");
    }
}

