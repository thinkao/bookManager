package com.wxy.pojo;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "book")
public class Book {
    @Id
    @GenericGenerator(name = "uuid", strategy = "uuid")
    @GeneratedValue(generator = "uuid")
    @Column(length = 32)
    private String book_id;
    @Column(length = 32)
    private String book_name;
    @Column(length = 32)
    private String book_editor;
    @Column(length = 32)
    private double book_price;
    @Column(length = 32)
    private String book_kind;
    @Column(length = 32)
    private int book_num;
    @Column(length = 32)
    private String pub_id;

    public Book() {
    }

    public Book(String book_name, String book_editor, double book_price, String book_kind, int book_num, String pub_id) {
        this.book_name = book_name;
        this.book_editor = book_editor;
        this.book_price = book_price;
        this.book_kind = book_kind;
        this.book_num = book_num;
        this.pub_id = pub_id;
    }

    public String getBook_kind() {
        return book_kind;
    }

    public void setBook_kind(String book_kind) {
        this.book_kind = book_kind;
    }

    public String getBook_id() {
        return book_id;
    }

    public void setBook_id(String book_id) {
        this.book_id = book_id;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public String getBook_editor() {
        return book_editor;
    }

    public void setBook_editor(String book_editor) {
        this.book_editor = book_editor;
    }

    public double getBook_price() {
        return book_price;
    }

    public void setBook_price(double book_price) {
        this.book_price = book_price;
    }

    public int getBook_num() {
        return book_num;
    }

    public void setBook_num(int book_num) {
        this.book_num = book_num;
    }

    public String getPub_id() {
        return pub_id;
    }

    public void setPub_id(String pub_id) {
        this.pub_id = pub_id;
    }
}
