package com.solution.goncharova.entity;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import javax.persistence.*;
import java.io.Serializable;


/**
 * Class {@code Author} in package {@code com.solution.goncharova.entity}
 *
 * Create table users with all attributes in DB
 *
 * @author Goncharova Anna
 * @version 1.0
 *
 */
@Entity
@Table(name = "`Author`" , schema = "Book_Store_Hiber")
public class Author implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "authorId")
    private int authorId;

    @Column(name = "authorName")
    @NotNull
    @Size(min = 2, max = 30)
    private String authorName;

    @Column(name = "authorSurname")
    @NotNull
    @Size(min = 2, max = 30)
    private String authorSurname;


    @Column(name = "authorMiddleName")
    @NotNull
    @Size(min = 2, max = 30)
    private String authorMiddleName;

    @Column(name = "authorBirthday")
    @NotNull
    private String authorBirthday;

    public Author() {

    }
    public Author(int authorId, String authorName, String authorSurname, String authorMiddleName, String authorBirthday) {
        this.authorId = authorId;
        this.authorName = authorName;
        this.authorSurname = authorSurname;
        this.authorMiddleName = authorMiddleName;
        this.authorBirthday = authorBirthday;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getAuthorSurname() {
        return authorSurname;
    }

    public void setAuthorSurname(String authorSurname) {
        this.authorSurname = authorSurname;
    }

    public String getAuthorMiddleName() {
        return authorMiddleName;
    }

    public void setAuthorMiddleName(String authorMiddleName) {
        this.authorMiddleName = authorMiddleName;
    }

    public String getAuthorBirthday() {
        return authorBirthday;
    }

    public void setAuthorBirthday(String authorBirthday) {
        this.authorBirthday = authorBirthday;
    }

    @Override
    public String toString() {
        return "Author{" +
                "authorId=" + authorId +
                ", authorName='" + authorName + '\'' +
                ", authorSurname='" + authorSurname + '\'' +
                ", authorMiddleName='" + authorMiddleName + '\'' +
                ", authorBirthday='" + authorBirthday + '\'' +
                '}';
    }
}
