package com.solution.goncharova.variant1;

import org.apache.logging.log4j.LogManager;


/**
 * Class {@code Triangle}
 * Was created to override methods from abstract class, to generate constructor
 */
public class Triangle extends Figure {

    /**
     * org.apache.logging.log4j.Logger
     */
    private static final org.apache.logging.log4j.Logger LOG4j2 = LogManager.getLogger(Triangle.class);

    int coordinateX1;
    int coordinateY1;
    int coordinateX2;
    int coordinateY2;
    int coordinateX3;
    int coordinateY3;

    /**
     * Creates a Triangle with the specified characteristics
     * Constructor checks if coordinates = 0 so triangle does not exist
     * @param coordinateX1 a Integer contains the value of first coordinate X for circle
     * @param coordinateY1 a Integer contains the value of first coordinate Y for circle
     * @param coordinateX2 a Integer contains the value of second coordinate X for circle
     * @param coordinateY2 a Integer contains the value of second coordinate Y for circle
     * @param coordinateX3 a Integer contains the value of third coordinate X for circle
     * @param coordinateY3 a Integer contains the value of third coordinate Y for circle
     */
    public Triangle( int coordinateX1, int coordinateY1, int coordinateX2, int coordinateY2, int coordinateX3, int coordinateY3 ) {
        this.coordinateX1 = coordinateX1;
        this.coordinateY1 = coordinateY1;
        this.coordinateX2 = coordinateX2;
        this.coordinateY2 = coordinateY2;
        this.coordinateX3 = coordinateX3;
        this.coordinateY3 = coordinateY3;
        int a = (int) Math.sqrt((this.coordinateX1 - this.coordinateX2) * (this.coordinateX1 - this.coordinateX2) + (this.coordinateY1 - this.coordinateY2) * (this.coordinateY1 - this.coordinateY2));
        int b = (int) Math.sqrt((this.coordinateX1 - this.coordinateX3) * (this.coordinateX1 - this.coordinateX3) + (coordinateY1 - coordinateY3) * (coordinateY1 - coordinateY3));
        int c = (int) Math.sqrt((this.coordinateX2 - this.coordinateX3) * (this.coordinateX2 - this.coordinateX3) + (coordinateY2 - coordinateY3) * (coordinateY2 - coordinateY3));
        if (a + b <= c || a + c <= b || a + c <= b)
            System.out.println("Triangle does not exist");
    }

    /**
     * Creates empty Square
     */
    public Triangle() {
        this.coordinateX1 = 0;
        this.coordinateY1 = 0;
        this.coordinateX2 = 0;
        this.coordinateY2 = 0;
        this.coordinateX3 = 0;
        this.coordinateY3 = 0;
    }

    public int getCoordinateX1() {
        return coordinateX1;
    }

    public int getCoordinateY1() {
        return coordinateY1;
    }

    public int getCoordinateX2() {
        return coordinateX2;
    }

    public int getCoordinateY2() {
        return coordinateY2;
    }

    public int getCoordinateX3() {
        return coordinateX3;
    }

    public int getCoordinateY3() {
        return coordinateY3;
    }

    /**
     * Overrided method finds area of figure (triangle)
     *
     * @return square the value which represents -1 in case if method is not find area of figure
     */
    @Override
    public int findFigureArea( ) {
        LOG4j2.info(" call overrided method findFigureArea");
        LOG4j2.info(" class Triangle");
        int square = -1;
        int a = (int) Math.sqrt((this.coordinateX1 - this.coordinateX2) * (this.coordinateX1 - this.coordinateX2) + (this.coordinateY1 - this.coordinateY2) * (this.coordinateY1 - this.coordinateY2));
        int b = (int) Math.sqrt((this.coordinateX1 - this.coordinateX3) * (this.coordinateX1 - this.coordinateX3) + (coordinateY1 - coordinateY3) * (coordinateY1 - coordinateY3));
        int c = (int) Math.sqrt((this.coordinateX2 - this.coordinateX3) * (this.coordinateX2 - this.coordinateX3) + (coordinateY2 - coordinateY3) * (coordinateY2 - coordinateY3));
        if (a + b <= c || a + c <= b || a + c <= b) {
            System.out.println("Triangle does not exist");
        } else {
            int p = (a + b + c) / 2;
            square = (int) Math.sqrt(p * (p - a) * (p - b) * (p - c));
            System.out.println(" Area of a triangle: " + square);
        }
        return square;
    }


    /**
     * Overrided method increases or decreases  size of figure (triangle)  according of condition
     *
     * @param coefficient the value which represents how much the user wants to change size of figure
     */
    @Override
    public void changeSize( int coefficient ) {
        LOG4j2.info(" call overrided method changeSize");
        LOG4j2.info(" class Triangle");
        int x0;
        int y0;
        x0 = (this.coordinateX1 + this.coordinateX2 + this.coordinateX3) / 3;
        y0 = (this.coordinateY1 + this.coordinateY2 + this.coordinateY3) / 3;
        if( coefficient > 0) {
            this.coordinateX1 = x0 + coefficient * (this.coordinateX1 - x0);
            this.coordinateX2 = x0 + coefficient * (this.coordinateX2 - x0);
            this.coordinateX3 = x0 + coefficient * (this.coordinateX3 - x0);
            this.coordinateY1 = y0 + coefficient * (this.coordinateY1 - y0);
            this.coordinateY2 = y0 + coefficient * (this.coordinateY2 - y0);
            this.coordinateY3 = y0 + coefficient * (this.coordinateY3 - y0);
        } else {
            this.coordinateX1 = x0 + Math.abs(coefficient) / (this.coordinateX1 - x0);
            this.coordinateX2 = x0 + Math.abs(coefficient) / (this.coordinateX2 - x0);
            this.coordinateX3 = x0 + Math.abs(coefficient) / (this.coordinateX3 - x0);
            this.coordinateY1 = y0 + Math.abs(coefficient) / (this.coordinateY1 - y0);
            this.coordinateY2 = y0 + Math.abs(coefficient) / (this.coordinateY2 - y0);
            this.coordinateY3 = y0 + Math.abs(coefficient) / (this.coordinateY3 - y0);
        }
    }
}

