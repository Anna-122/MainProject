package com.solution.goncharova.variant1;

import org.apache.logging.log4j.LogManager;

/**
 * Class {@code Circle}
 * Was created to override methods from abstract class, to generate constructor
 */
public class Circle extends Figure {

    /**
     * org.apache.logging.log4j.Logger
     */
    private static final org.apache.logging.log4j.Logger LOG4j2 = LogManager.getLogger(Circle.class);

    /**
     * PI constant
     */
    public static final float PI = (float) 3.14159;
    int radius;
    int coordinateX;
    int coordinateY;

    /**
     * Creates a Circle with the specified characteristics
     * @param radius a Integer contains the value of radius for circle
     * @param coordinateX   a Integer contains the value of first coordinate X for circle
     * @param coordinateY a Integer contains the value of first coordinate Y for circle
     */
    public Circle( int radius, int coordinateX, int coordinateY ) {
        this.radius = radius;
        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;
    }

    /**
     * Creates a Circle with the specified characteristics
     * @param radius a Integer contains the value of radius for circle
     */
    public Circle( int radius ) {
        this.radius = radius;
        this.coordinateX = 0;
        this.coordinateY = 0;
    }

    /**
     * Creates empty (degenerate) Circle
     */
    public Circle() {
        this.radius = 0;
        this.coordinateX = 0;
        this.coordinateY = 0;
    }

    public int getRadius() {
        return radius;
    }
    public int getCoordinateX() {
        return coordinateX;
    }
    public int getCoordinateY() {
        return coordinateY;
    }

    /**
     * Overrided method finds area of figure (circle)
     *
     * @return s the value which represents area of figure
     */
    @Override
    public int findFigureArea() {
        LOG4j2.info(" call overrided method findFigureArea");
        LOG4j2.info("class Circle");
        float s = PI * this.radius * this.radius;
        System.out.println("The area of the circle is " + s);
        return (int) s;
    }

    /**
     * Overrided method increases or decreases size of figure (circle) according of condition
     *
     * @param coefficient the value which represents how much the user wants to change size of figure
     */
    @Override
    public void changeSize(int coefficient ) {
        LOG4j2.info("call overrided method changeSize");
        LOG4j2.info("class Circle");
        if (coefficient > 0 ) {
            this.radius = this.radius * coefficient;
            System.out.println("New increased radius of circle" + this.radius);
        } else {
            this.radius = this.radius / Math.abs(coefficient);
            System.out.println("New decreased radius of circle" + this.radius);
        }
    }
}

