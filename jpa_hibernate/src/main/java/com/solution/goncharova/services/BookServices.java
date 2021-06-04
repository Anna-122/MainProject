package com.solution.goncharova.services;

import com.solution.goncharova.dao.BookDaoImpl;
import com.solution.goncharova.entity.Books;

import java.util.List;

/**
 * Class {@code BooksServices} in package {@code com.solution.goncharova.services}
 *
 * It is mediator from BooksDaoImpl and Books
 * This class use all CRUD methods of DAO
 *
 * @author Goncharova Anna
 * @version 1.0
 *
 */
public class BookServices {


    private BookDaoImpl booksDao = new BookDaoImpl();

    public BookServices() {
    }

    public Books findBooks(int id) {
        return booksDao.find(id);
    }

    public void saveBooks(Books book) {
        booksDao.create(book);
    }

    public void deleteBooks(Books book) {
        booksDao.delete(book);
    }

    public void updateBooks(Books book) {
        booksDao.update(book);
    }

    public List<Books> findAllBooks() {
        return booksDao.findAll();
    }


}
