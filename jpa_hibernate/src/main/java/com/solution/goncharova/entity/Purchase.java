package com.solution.goncharova.entity;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Class {@code Purchase} in package {@code com.solution.goncharova.entity}
 *
 * Create table users with all attributes in DB
 *
 * @author Goncharova Anna
 * @version 1.0
 *
 */
@Entity
@Table(name = "`Purchase`" , schema = "Book_Store_Hiber")
public class Purchase implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "purchaseId")
    private int purchaseId;

    @Column(name = "date_purchaseAdding")
    @NotNull
    private String date_purchaseAdding;

    @Column(name = "date_purchaseDeleting")
    @NotNull
    private String date_purchaseDeleting;

    @Column(name = "date_purchasePayment")
    @NotNull
    private String date_purchasePayment;

    @Column(name = "bookCount")
    @NotNull
    private int bookCount;

    @Column(name = "bookPrice")
    @NotNull
    private BigDecimal bookPrice;

    @Column(name = "bookDeleted")
    @NotNull
    private boolean bookDeleted;

    @Column(name = "bookPaid")
    @NotNull
    private boolean bookPaid;


    @Column(name = "book_id")
    @NotNull
    @Size(max = 1)
    private int book_id;

    @Column(name = "user_id")
    @NotNull
    @Size(max = 1)
    private int user_id;

//    @ManyToOne (fetch = FetchType.EAGER)
//    @JoinColumn (name = "book_id")
//    private Books book;

//    @ManyToOne (fetch = FetchType.EAGER)
//    @JoinColumn (name = "user_id")
//    private User user;

    public Purchase() {

    }

    public Purchase(int purchaseId, String date_purchaseAdding, String date_purchaseDeleting, String date_purchasePayment, int bookCount, BigDecimal bookPrice, boolean bookDeleted, boolean bookPaid, int book_id, int user_id) {
        this.purchaseId = purchaseId;
        this.date_purchaseAdding = date_purchaseAdding;
        this.date_purchaseDeleting = date_purchaseDeleting;
        this.date_purchasePayment = date_purchasePayment;
        this.bookCount = bookCount;
        this.bookPrice = bookPrice;
        this.bookDeleted = bookDeleted;
        this.bookPaid = bookPaid;
        this.book_id = book_id;
        this.user_id = user_id;
    }

    public int getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(int purchaseId) {
        this.purchaseId = purchaseId;
    }

    public String getDate_purchaseAdding() {
        return date_purchaseAdding;
    }

    public void setDate_purchaseAdding(String date_purchaseAdding) {
        this.date_purchaseAdding = date_purchaseAdding;
    }

    public String getDate_purchaseDeleting() {
        return date_purchaseDeleting;
    }

    public void setDate_purchaseDeleting(String date_purchaseDeleting) {
        this.date_purchaseDeleting = date_purchaseDeleting;
    }

    public String getDate_purchasePayment() {
        return date_purchasePayment;
    }

    public void setDate_purchasePayment(String date_purchasePayment) {
        this.date_purchasePayment = date_purchasePayment;
    }

    public int getBookCount() {
        return bookCount;
    }

    public void setBookCount(int bookCount) {
        this.bookCount = bookCount;
    }

    public BigDecimal getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(BigDecimal bookPrice) {
        this.bookPrice = bookPrice;
    }

    public @NotNull boolean getBookDeleted() {
        return bookDeleted;
    }

    public void setBookDeleted(boolean bookDeleted) {
        this.bookDeleted = bookDeleted;
    }

    public @NotNull boolean getBookPaid() {
        return bookPaid;
    }

    public void setBookPaid(boolean bookPaid) {
        this.bookPaid = bookPaid;
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "Purchase{" +
                "purchaseId=" + purchaseId +
                ", date_purchaseAdding='" + date_purchaseAdding + '\'' +
                ", date_purchaseDeleting='" + date_purchaseDeleting + '\'' +
                ", date_purchasePayment='" + date_purchasePayment + '\'' +
                ", bookCount=" + bookCount +
                ", bookPrice=" + bookPrice +
                ", bookDeleted=" + bookDeleted +
                ", bookPaid=" + bookPaid +
                ", book_id=" + book_id +
                ", user_id=" + user_id +
                '}';
    }
}
