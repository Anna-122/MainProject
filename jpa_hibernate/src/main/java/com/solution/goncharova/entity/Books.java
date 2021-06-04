package com.solution.goncharova.entity;

import java.util.Date;
import jakarta.validation.constraints.*;
import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Class {@code Books} in package {@code com.solution.goncharova.entity}
 *
 * Create table books with all attributes in DB
 *
 * @author Goncharova Anna
 * @version 1.0
 *
 */

@Entity
@Table(name = "Books", schema = "Book_Store_Hiber")
public class Books implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private int bookId;

    @Column(name = "bookTitle")
    @NotNull
    @Size(min = 2, max = 50)
    private String bookTitle;

    @Column(name = "bookPrice")
    @NotNull
    private BigDecimal bookPrice;

    @Column(name = "countOfPages")
    @NotNull
    private int countOfPages;

    @Column(name = "bookIsbn")
    @NotNull
    private String bookIsbn;


    @Column(name = "bookHide")
    @NotNull
    private Boolean bookHide;

    @Column(name = "bookGenre")
    @NotNull
    private String bookGenre;

    @Column(name = "year_of_publishing")
    @NotNull
    private String yearOfPublishing;

    @Column(name = "publishing_house_id")
    @NotNull
    @Size (max = 1)
    private int publishing_house_id;

    @Column(name = "author_id")
    @NotNull
    @Size (max = 1)
    private int author_id;

//    @ManyToOne (fetch = FetchType.EAGER)
//    @JoinColumn (name = "authorId")
//    private Author author;
//
//    @ManyToOne (fetch = FetchType.EAGER)
//    @JoinColumn (name = "publishingHouseId")
//    private PublishingHouse publishingHouse;

    /*empty constructor*/
    public Books() {

    }

    public Books(int bookId, String bookTitle, BigDecimal bookPrice, int countOfPages, String bookIsbn, Boolean bookHide, String bookGenre, String yearOfPublishing, int publishing_house_id, int author_id) {
        this.bookId = bookId;
        this.bookTitle = bookTitle;
        this.bookPrice = bookPrice;
        this.countOfPages = countOfPages;
        this.bookIsbn = bookIsbn;
        this.bookHide = bookHide;
        this.bookGenre = bookGenre;
        this.yearOfPublishing = yearOfPublishing;
        this.publishing_house_id = publishing_house_id;
        this.author_id = author_id;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public BigDecimal getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(BigDecimal bookPrice) {
        this.bookPrice = bookPrice;
    }

    public int getCountOfPages() {
        return countOfPages;
    }

    public void setCountOfPages(int countOfPages) {
        this.countOfPages = countOfPages;
    }

    public String getBookIsbn() {
        return bookIsbn;
    }

    public void setBookIsbn(String bookIsbn) {
        this.bookIsbn = bookIsbn;
    }

    public Boolean getBookHide() {
        return bookHide;
    }

    public void setBookHide(Boolean bookHide) {
        this.bookHide = bookHide;
    }

    public String getBookGenre() {
        return bookGenre;
    }

    public void setBookGenre(String bookGenre) {
        this.bookGenre = bookGenre;
    }

    public String getYearOfPublishing() {
        return yearOfPublishing;
    }

    public void setYearOfPublishing(String yearOfPublishing) {
        this.yearOfPublishing = yearOfPublishing;
    }

    public int getPublishing_house_id() {
        return publishing_house_id;
    }

    public void setPublishing_house_id(int publishing_house_id) {
        this.publishing_house_id = publishing_house_id;
    }

    public int getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(int author_id) {
        this.author_id = author_id;
    }

    @Override
    public String toString() {
        return "Books{" +
                "bookId=" + bookId +
                ", bookTitle='" + bookTitle + '\'' +
                ", bookPrice=" + bookPrice +
                ", countOfPages=" + countOfPages +
                ", bookIsbn='" + bookIsbn + '\'' +
                ", bookHide=" + bookHide +
                ", bookGenre='" + bookGenre + '\'' +
                ", yearOfPublishing='" + yearOfPublishing + '\'' +
                ", publishing_house_id=" + publishing_house_id +
                ", author_id=" + author_id +
                '}';
    }
}

