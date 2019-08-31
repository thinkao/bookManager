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
    private int book_num;
    @Column(length = 32)
    private String kind_name;
    @Column(length = 32)
    private String pub_name;


    public Book() {
    }

    public Book(String book_name, String book_editor, double book_price, int book_num, String kind_name, String pub_name) {
        this.book_name = book_name;
        this.book_editor = book_editor;
        this.book_price = book_price;
        this.book_num = book_num;
        this.kind_name = kind_name;
        this.pub_name = pub_name;
    }

    public String getKind_name() {
        return kind_name;
    }

    public void setKind_name(String kind_name) {
        this.kind_name = kind_name;
    }

    public String getPub_name() {
        return pub_name;
    }

    public void setPub_name(String pub_name) {
        this.pub_name = pub_name;
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

}
