package com.solution.goncharova.dao.exceptions;

/**
 * Class {@code DaoException} in package {@code com.solution.goncharova.dao.exceptions}
 *
 * Create  exception with DB
 *
 * @author  Goncharova Anna
 * @version 1.0
 */
public class DaoException extends RuntimeException {

    public DaoException(Throwable throwable) {
        super(throwable);
    }
}