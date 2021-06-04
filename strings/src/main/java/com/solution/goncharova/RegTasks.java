package com.solution.goncharova;


import org.apache.logging.log4j.LogManager;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * Class for solving tasks using only regular expressions.
 * Solves different task like finding quantity of digits and etc...
 *
 * @author Goncharova Anna
 * @version 1.0
 */

public class RegTasks {

    private static final org.apache.logging.log4j.Logger LOG4j2 = LogManager.getLogger(RegTasks.class);

    /**The function outputs the numbers of characters that match the last character of the string.
     *
     * @param string - given string.
     */
    public static void findNumOfSymbolsTask1(String string) {
        String sb = "";
        Pattern pattern = Pattern.compile(".$");
        Matcher matcher = pattern.matcher(string);
        while (matcher.find()) {
            sb = matcher.group();
        }
        pattern = Pattern.compile(sb);
        matcher = pattern.matcher(string);

        while (matcher.find()) {
            LOG4j2.info(matcher.start());
        }
    }

    /**The function outputs quantity of digits in the string.
     *
     * @param string - given string.
     */
    public static void findQuantityOfDigitsTask2(String string) {
        int count = 0;
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(string);
        while (matcher.find()) {
            count++;
        }
        LOG4j2.info(" Quantity of digits is " + count);
    }

    /**The function outputs quantity of digits from one to five in the string.
     *
     * @param string - given string.
     */
    public static void findQuantityOfDigitsFromOneToFiveTask3 (String string) {
        int count = 0;
        Pattern pattern = Pattern.compile("[1-5]");
        Matcher matcher = pattern.matcher(string);
        while (matcher.find()) {
            count++;
        }
        LOG4j2.info(" Quantity of digits from one to five is " + count);
    }


    /**The function outputs string without "abc" if after that there is a number.
     *
     * @param string - given string.
     */
    public static void deleteLetters(String string) {
        string = string.replaceAll("abc\\d", "");
        LOG4j2.info("String without abc if after that there is a number "+ string);
    }

    /**The function outputs sum of digits of the string.
     *
     * @param string - given string.
     */
    public static void findSumOfDigits(String string) {
        int sum = 0;
        Pattern pattern = Pattern.compile("\\d");
        Matcher matcher = pattern.matcher(string);
        while (matcher.find()) {
            char letter = string.charAt(matcher.start());
            int num = Integer.parseInt(String.valueOf(letter));
            sum+=num;
        }
        LOG4j2.info("Sum of digits " + sum);
    }

    /**The function outputs string without extra geps.
     *
     * @param string - given string.
     */
    public static void removeExtraGeps(String string) {
        LOG4j2.info(string.replaceAll("[\\s]{2,}", " "));
    }

    /**The function outputs modified string .
     *
     * @param string - given string.
     */
    public static void replaceWord(String string) {
        LOG4j2.info(string.replaceAll("word", "letter"));
    }
}
