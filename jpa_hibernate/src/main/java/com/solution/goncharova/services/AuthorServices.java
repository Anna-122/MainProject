package com.solution.goncharova.services;

import com.solution.goncharova.dao.AuthorDaoImpl;
import com.solution.goncharova.dao.BookDaoImpl;
import com.solution.goncharova.entity.Author;
import com.solution.goncharova.entity.Books;

import java.util.List;

/**
 * Class {@code AuthorServices} in package {@code com.solution.goncharova.services}
 *
 * It is mediator from AuthorDaoImpl and Author
 * This class use all CRUD methods of DAO
 * We use it in business logic
 *
 * @author Goncharova Anna
 * @version 1.0
 *
 */
public class AuthorServices {

    private AuthorDaoImpl authorDao = new AuthorDaoImpl();

    public AuthorServices() {
    }

    public Author findAuthor(int id) {
        return authorDao.find(id);
    }

    public void saveAuthor(Author author) {
        authorDao.create(author);
    }

    public void deleteAuthor(Author author) {
        authorDao.delete(author);
    }

    public void updateAuthor(Author author) {
        authorDao.update(author);
    }

    public List<Author> findAllAuthors() {
        return authorDao.findAll();
    }

}
