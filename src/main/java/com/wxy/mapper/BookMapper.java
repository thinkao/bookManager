package com.wxy.mapper;

import com.wxy.pojo.Book;

import java.util.List;

public interface BookMapper {
    List<Book> getBookAll();

    Book getBookByBook_id(String book_id);

    void addBook(Book book);

    void deleteBook(String book_id);

    void updateBook(Book book);
}
