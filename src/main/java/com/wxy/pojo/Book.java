package com.wxy.pojo;

public class Book {
    private String book_id;
    private String book_name;
    private String book_editor;
    private double book_price;
    private int book_num;
    private String pub_id;

    public Book() {
    }

    public Book(String book_id, String book_name, String book_editor, double book_price, int book_num, String pub_id) {
        this.book_id = book_id;
        this.book_name = book_name;
        this.book_editor = book_editor;
        this.book_price = book_price;
        this.book_num = book_num;
        this.pub_id = pub_id;
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
