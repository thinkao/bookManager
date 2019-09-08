package com.wxy.service;

import com.wxy.mapper.BookMapper;
import com.wxy.page.PageQuery;
import com.wxy.pojo.Book;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookService<T extends PageQuery> {

    List<Book> getBookByKind(String kind_name);

    Book getBookByBook_id(String book_id);

    Book getBookByBook_name(String book_name);

    Book addBook(Book book);

    Book updateBook(Book book);

    void deleteBook(String book_id);

    Integer countPage(T query);

    List<Book> listPage(T query);
}
