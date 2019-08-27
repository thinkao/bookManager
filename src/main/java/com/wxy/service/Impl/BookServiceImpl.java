package com.wxy.service.Impl;

import com.wxy.mapper.BookMapper;
import com.wxy.mapper.BookRepository;
import com.wxy.page.PageQuery;
import com.wxy.pojo.Book;
import com.wxy.pojo.dto.BookQueryDto;
import com.wxy.pojo.dto.UserQueryDto;
import com.wxy.service.BookService;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService<BookQueryDto> {

    @Autowired
    private BookMapper bookMapper;

    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Book> getBookByKind(String kind) {
        return bookMapper.getBookByKind(kind);
    }

    @Override
    public Book getBookByBook_id(String book_id) {
        Optional<Book> o =  bookRepository.findById(book_id);
        return o.orElse(null);
    }

    @Override
    public Book getBookByBook_name(String book_name) {
        return bookMapper.getBookByBook_name(book_name);
    }

    @Override
    public Book addBook(Book book) {
        Book result = null;
        if(book!=null){
            result = bookRepository.save(book);
        }
        return result;
    }

    @Override
    public Book updateBook(Book book) {
        Book result = null;
        if(book!=null){
            result = bookRepository.save(book);
        }
        return result;
    }

    @Override
    public void deleteBook(String book_id) {
        bookMapper.deleteBook(book_id);
    }

    @Override
    public Integer countPage(BookQueryDto query) {
        return bookMapper.countPage(query);
    }
}
