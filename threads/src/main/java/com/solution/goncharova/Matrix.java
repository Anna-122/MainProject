/*
 * Matrix
 *
 * Version 1.0
 *
 * Copyright 2021. Anna Goncharova. GPL
 *
 */

package com.solution.goncharova;

import org.apache.logging.log4j.LogManager;
import java.util.Arrays;

/**
 * Class {@code Matrix} implements {@code Runnable} is class multiplier for 2 matrix
 *
 * @author Anna Goncharova
 * @version 1.0
 */
public class Matrix extends Thread{

    /**
     * org.apache.logging.log4j.Logger
     */
    private static final org.apache.logging.log4j.Logger LOG4j2 = LogManager.getLogger(Matrix.class);

    /**
     * @param firstMatrix value of first Matrix
     * @param secondMatrix value of second Matrix
     * @return result of multiplying two matrices;
     */
    public int[][] multiplyMatrix(int[][] firstMatrix, int[][] secondMatrix) {
        int length = firstMatrix.length;
        int[][] result = new int[length][length];

        for(int i = 0; i < length; i++) {
            for(int j = 0; j < length; j++) {
                for(int k = 0; k < length; k++) {
                    result[i][j] += firstMatrix[i][k] * secondMatrix[k][j];
                }
            }
        }
        return result;
    }

    /**
     * Thread method starts thread
     */
    @Override
    public void run() {
        LOG4j2.info(Arrays.deepToString(
                multiplyMatrix(new int[][]{{8, 9, 4}, {4, 9, 7}}, new int[][] {{9, 2, 4}, {0, 0, 2}})));
    }
}

