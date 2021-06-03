/*
 * OOP tasks
 *
 * Version 1.2
 *
 * Copyright 2021. Anna Goncharova. GPL
 *
 */

package com.solution.goncharova.variant1;

/**
 * Class {@code Main}
 * Was created to generate random figures(objects), to call methods and to sort area of figures
 *
 * @author Goncharova Anna
 * @version 1.2
 */

import org.apache.logging.log4j.LogManager;

public class Main {

    /**
     * org.apache.logging.log4j.Logger
     */
    private static final org.apache.logging.log4j.Logger LOG4j2 = LogManager.getLogger(Main.class);

    public static void main( String[] args ) {
        Figure[] figureArr = new Figure[10];
        int circle_count = 0;
        for (int i = 0; i < 10; i++) {
            switch (getRandomIntBetweenRange(1, 3)) {
                case 1: {
                    LOG4j2.info("Create object circle");
                    figureArr[i] = new Circle(getRandomIntBetweenRange(5, 10), getRandomIntBetweenRange(5, 10), getRandomIntBetweenRange(5, 10));
                    break;
                }
                case 2: {
                    LOG4j2.info("Create object square");
                    figureArr[i] = new Square(getRandomIntBetweenRange(5, 10), getRandomIntBetweenRange(5, 10),
                            getRandomIntBetweenRange(5, 10), getRandomIntBetweenRange(5, 10),
                            getRandomIntBetweenRange(5, 10), getRandomIntBetweenRange(5, 10),
                            getRandomIntBetweenRange(5, 10), getRandomIntBetweenRange(5, 10));
                    break;
                }
                case 3: {
                    LOG4j2.info("Create object triangle");
                    figureArr[i] = new Triangle(getRandomIntBetweenRange(5, 10), getRandomIntBetweenRange(5, 10),
                            getRandomIntBetweenRange(5, 10), getRandomIntBetweenRange(5, 10),
                            getRandomIntBetweenRange(5, 10), getRandomIntBetweenRange(5, 10));
                    break;
                }
            }
        }

        for (Figure fig: figureArr) {
            fig.changeSize(getRandomIntBetweenRange(-5, 5));
            if (fig instanceof Circle) {
                LOG4j2.info("change object circle");
                System.out.println("changed radius " + fig.getRadius());
                System.out.println("changed coordinateX " + fig.getCoordinateX());
                System.out.println("changed coordinateY " + fig.getCoordinateX());
            } else if (fig instanceof Triangle) {
                LOG4j2.info("change object triangle");
                System.out.println("changed coordinateX1 " + fig.getCoordinateX1());
                System.out.println("changed coordinateY1 " + fig.getCoordinateY1());
                System.out.println("changed coordinateX2 " + fig.getCoordinateX2());
                System.out.println("changed coordinateY2 " + fig.getCoordinateY2());
                System.out.println("changed coordinateX3 " + fig.getCoordinateX3());
                System.out.println("changed coordinateY3 " + fig.getCoordinateY3());
            } else {
                LOG4j2.info("change object square");
                System.out.println("changed coordinateX1 " + fig.getCoordinateX1());
                System.out.println("changed coordinateY1 " + fig.getCoordinateY1());
                System.out.println("changed coordinateX2 " + fig.getCoordinateX2());
                System.out.println("changed coordinateY2 " + fig.getCoordinateY2());
                System.out.println("changed coordinateX3 " + fig.getCoordinateX3());
                System.out.println("changed coordinateY3 " + fig.getCoordinateY3());
                System.out.println("changed coordinateX4 " + fig.getCoordinateX4());
                System.out.println("changed coordinateY4 " + fig.getCoordinateY4());
            }
        }

        for (int i = 0; i < figureArr.length; i++) {
        /*Предполагаем, что первый элемент (в каждом
           подмножестве элементов) является минимальным */
            int min = figureArr[i].findFigureArea();
            int min_i = i;
        /*В оставшейся части подмножества ищем элемент,
           который меньше предположенного минимума*/
            for (int j = i + 1; j < figureArr.length; j++) {
                //Если находим, запоминаем его индекс
                if (figureArr[j].findFigureArea() < min) {
                    min = figureArr[j].findFigureArea();
                    min_i = j;
                }
            }
        /*Если нашелся элемент, меньший, чем на текущей позиции,
          меняем их местами*/
            if (i != min_i) {
                Figure tmp = figureArr[i];
                figureArr[i] = figureArr[min_i];
                figureArr[min_i] = tmp;
            }
        }

        for (Figure fig: figureArr) {
            if (fig instanceof Circle) {
                System.out.println("area of circle is " + fig.findFigureArea());
            } else if (fig instanceof Triangle) {
                System.out.println("area of triangle is " + fig.findFigureArea());
            } else {
                System.out.println("area of square is " + fig.findFigureArea());
            }
        }
    }

    /**
     * Method returns a random number according to the specified range
     *
     * @param min the value which represents start of range
     * @param max the value which represents end of range
     * @return x the value which represents random number according to the specified range
     */
    public static int getRandomIntBetweenRange( int min, int max ) {
        LOG4j2.info("call method getRandomIntBetweenRange");
        int x = (int) ((Math.random() * ((max - min) + 1)) + min);
        if (x == 0) x++;
        return x;
    }
}

