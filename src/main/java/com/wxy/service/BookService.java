package com.wxy.service;

import com.wxy.mapper.BookMapper;
import com.wxy.pojo.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookMapper bookMapper;

    public List<Book> getBookAll(){
        return bookMapper.getBookAll();
    }
    public void addBook(Book book){
        bookMapper.addBook(book);
    }
    public void deleteBook(String book_id){
        bookMapper.deleteBook(book_id);
    }
    public void update(Book book){
        bookMapper.updateBook(book);
    }
    public Book getBookByBook_id(String book_id){
        return bookMapper.getBookByBook_id(book_id);
    }
}
