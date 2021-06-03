package com.solution.goncharova.variant1;

import org.apache.logging.log4j.LogManager;


/**
 * Class {@code Square}
 * Was created to override methods from abstract class, to generate constructor
 */
public class Square extends Figure {

    /**
     * org.apache.logging.log4j.Logger
     */
    private static final org.apache.logging.log4j.Logger LOG4j2 = LogManager.getLogger(Square.class);

    int coordinateX1;
    int coordinateY1;
    int coordinateX2;
    int coordinateY2;
    int coordinateX3;
    int coordinateY3;
    int coordinateX4;
    int coordinateY4;
    int lengthOfOneSide;

    /**
     * Creates a Square with the specified characteristics
     * @param coordinateX1 a Integer contains the value of first coordinate X for circle
     * @param coordinateY1 a Integer contains the value of first coordinate Y for circle
     * @param coordinateX2 a Integer contains the value of second coordinate X for circle
     * @param coordinateY2 a Integer contains the value of second coordinate Y for circle
     * @param coordinateX3 a Integer contains the value of third coordinate X for circle
     * @param coordinateY3 a Integer contains the value of third coordinate Y for circle
     * @param coordinateX4 a Integer contains the value of fourth coordinate X for circle
     * @param coordinateY4 a Integer contains the value of fourth coordinate Y for circle
     */
    public Square( int coordinateX1, int coordinateY1, int coordinateX2, int coordinateY2, int coordinateX3, int coordinateY3, int coordinateX4, int coordinateY4) {
        this.coordinateX1 = coordinateX1;
        this.coordinateY1 = coordinateY1;
        this.coordinateX2 = coordinateX2;
        this.coordinateY2 = coordinateY2;
        this.coordinateX3 = coordinateX3;
        this.coordinateY3 = coordinateY3;
        this.coordinateX4 = coordinateX4;
        this.coordinateY4 = coordinateY4;
        findLengthOfOneSide();
    }

    /**
     * Creates empty Square
     */
    public Square() {
        this.coordinateX1 = 0;
        this.coordinateY1 = 0;
        this.coordinateX2 = 0;
        this.coordinateY2 = 0;
        this.coordinateX3 = 0;
        this.coordinateY3 = 0;
        this.coordinateX4 = 0;
        this.coordinateY4 = 0;
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

    public int getCoordinateX4() {
        return coordinateX4;
    }

    public int getCoordinateY4() {
        return coordinateY4;
    }

    /**
     * Overrided method finds area of figure (square)
     *
     * @return s the value which represents area of figure
     */
    @Override
    public int findFigureArea( ) {
        LOG4j2.info(" call overrided method findFigureArea");
        LOG4j2.info(" class Square");
        int s = this.lengthOfOneSide * this.lengthOfOneSide;
        System.out.println("The area of the square is " + s);
        return s;
    }

    /**
     * Overrided method increases or decreases  size of figure (triangle) according of condition
     *
     * @param coefficient the value which represents how much the user wants to change size of figure
     */
    @Override
    public void changeSize( int coefficient ) {
        LOG4j2.info(" call overrided method changeSize ");
        LOG4j2.info(" class Square");
        if (coefficient > 0) {
            LOG4j2.info("increase square ");
            System.out.println(this.coordinateX1 * coefficient);
            System.out.println(this.coordinateX2 * coefficient);
            System.out.println(this.coordinateY2 * coefficient);
            System.out.println(this.coordinateY3 * coefficient);
        } else {
            LOG4j2.info("decrease square ");
            System.out.println(this.coordinateX1 / Math.abs(coefficient));
            System.out.println(this.coordinateX2 / Math.abs(coefficient));
            System.out.println(this.coordinateY2 / Math.abs(coefficient));
            System.out.println(this.coordinateY3 / Math.abs(coefficient));
        }
        this.coordinateX1 = this.coordinateX1 * coefficient;
        this.coordinateX2 = this.coordinateX1 * coefficient;
        this.coordinateY2 = this.coordinateX1 * coefficient;
        this.coordinateY3 = this.coordinateX1 * coefficient;

        this.coordinateX1 = this.coordinateX1 / coefficient;
        this.coordinateX2 = this.coordinateX1 / coefficient;
        this.coordinateY2 = this.coordinateX1 / coefficient;
        this.coordinateY3 = this.coordinateX1 / coefficient;

        findLengthOfOneSide();
    }

    /**
     * Method finds length of one side of figure(square) by coordinates
     *
     */
    public void findLengthOfOneSide() {
        LOG4j2.info(" call method findLengthOfOneSide ");
        LOG4j2.info(" class Square");
        if (this.coordinateX1 < this.coordinateX2){
            this.lengthOfOneSide =  coordinateX2 - coordinateX1;
        } else {
            this.lengthOfOneSide =  coordinateX1 - coordinateX2;
        }
    }
}
