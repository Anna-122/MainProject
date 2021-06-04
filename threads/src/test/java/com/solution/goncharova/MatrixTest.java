package com.solution.goncharova;

import org.junit.Test;

import static org.junit.Assert.*;

public class MatrixTest {

    Matrix matrix1 = new Matrix();

    @Test
    public void multiplyMatrixTest() {
        int[][] nums1 = { { 1, 2 }, { 3, 4 } };
        int[][] nums2 = { {  1, 2 }, { 3, 4 } };
        int[][] result = { { 7, 10 }, { 15, 22 } };
        assertArrayEquals(result, matrix1.multiplyMatrix(nums1, nums2));
    }
}
