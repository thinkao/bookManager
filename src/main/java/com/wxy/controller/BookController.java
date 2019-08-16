package com.wxy.controller;

import com.wxy.pojo.Book;
import com.wxy.service.BookService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api("书籍管理")
@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService bookService;

    @ApiOperation(value = "获取所有书籍信息",notes = "")
    @RequestMapping(value = "/getAll",method = RequestMethod.GET)
    public List<Book> getBookAll(){
        return bookService.getBookAll();
    }

    @ApiOperation(value = "根据书籍编号获取书籍信息",notes = "")
    @RequestMapping(value = "/getBookBy/{book_id}",method = RequestMethod.GET)
    public Book getBookByBook_id(@PathVariable String book_id){
        Book book =  bookService.getBookByBook_id(book_id);
        return book;
    }

    @ApiOperation(value = "修改书籍信息",notes = "")
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public String update(Book book){
        bookService.update(book);
        return "success";
    }

    @ApiOperation(value = "添加新的书籍",notes = "")
    @RequestMapping(value = "/add",method = RequestMethod.GET)
    public String addBook(Book book){
        bookService.addBook(book);
        return "success";
    }

    @ApiOperation(value ="删除书籍",notes = "")
    @RequestMapping(value = "/delete",method = RequestMethod.DELETE)
    public String delete(String book_id){
        bookService.deleteBook(book_id);
        return "success";
    }
}
