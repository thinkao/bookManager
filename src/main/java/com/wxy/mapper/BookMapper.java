package com.wxy.mapper;

import com.wxy.pojo.Book;
import com.wxy.pojo.dto.BookQueryDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.poi.ss.formula.functions.T;

import java.util.List;
@Mapper
public interface BookMapper {

    List<Book> getBookByKind(String kind_name);

    Book getBookByBook_id(String book_id);

    Book getBookByBook_name(String book_name);

    void addBook(Book book);

    void deleteBook(String book_id);

    void updateBook(Book book);

    Integer countPage(BookQueryDto query);

    List<Book> listPage(BookQueryDto query);
}
