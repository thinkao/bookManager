package com.wxy.controller;

import com.fasterxml.jackson.databind.ser.Serializers;
import com.wxy.pojo.Book;
import com.wxy.pojo.dto.BookInsertDto;
import com.wxy.pojo.dto.BookUpdateDto;
import com.wxy.response.BaseResult;
import com.wxy.response.HttpStatus;
import com.wxy.service.BookService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@Api("书籍管理")
@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService bookService;

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @ApiOperation(value = "通过种类获取该类所有书籍信息",notes = "")
    @RequestMapping(value = "/getAll/{kind_name}",method = RequestMethod.GET)
    public BaseResult getBookAll(@PathVariable String kind_name){
        BaseResult result = new BaseResult();
        try {
            result.setData(bookService.getBookByKind(kind_name));
        }catch (Exception e){
            result.setCode(org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR.value());
            result.setMessage(e.getMessage());
            logger.error("根据ID查询错误{}", e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    @ApiOperation(value = "根据书籍编号获取书籍信息",notes = "")
    @RequestMapping(value = "/getBookBy/{book_id}",method = RequestMethod.GET)
    public BaseResult getBookByBook_id(@PathVariable String book_id){
        BaseResult result = new BaseResult();
        try {
            result.setData(bookService.getBookByBook_id(book_id));
        }catch (Exception e){
            result.setCode(org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR.value());
            result.setMessage(e.getMessage());
            logger.error("根据ID查询错误{}", e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    @ApiOperation(value = "修改书籍信息",notes = "")
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public BaseResult update(@RequestBody @Validated BookUpdateDto dto, BindingResult bindingResult){

        BaseResult result = new BaseResult();
        /*参数校验*/
        if (bindingResult.hasErrors()) {
            FieldError fieldError = bindingResult.getFieldError();
            logger.error("修改参数错误:{}", fieldError.getDefaultMessage());
            result.setCode(org.springframework.http.HttpStatus.BAD_REQUEST.value());
            result.setMessage(fieldError.getDefaultMessage());
            return result;
        }

        try{
            Book book = bookService.getBookByBook_id(dto.getBook_id());
            if(book != null){
                BeanUtils.copyProperties(dto, book);
                bookService.updateBook(book);
                result.setMessage("修改成功");
            }
        }catch (Exception e){
            result.setCode(org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR.value());
            result.setMessage(e.getMessage());
            logger.error("修改错误{}", e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    @ApiOperation(value = "添加新的书籍",notes = "")
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public BaseResult addBook(@RequestBody @Validated BookInsertDto dto, BindingResult bindingResult){
        BaseResult result = new BaseResult();
        /*校验参数*/
        if(bindingResult.hasErrors()){
            FieldError fieldError =  bindingResult.getFieldError();
            logger.error("新增参数错误：{}",fieldError.getDefaultMessage());
            result.setCode(HttpStatus.BAD_REQUEST.value);
            result.setMessage((fieldError.getDefaultMessage()));
            return result;
        }

        Book book = new Book();
        String book_name = dto.getBook_name();
        try{
            Book book1 = bookService.getBookByBook_name(book_name);
            System.out.println("success2");
            if(book1 != null){
                book1.setBook_num(book1.getBook_num()+1);
                result.setData(book1);
                //BeanUtils.copyProperties(dto,book);
                bookService.updateBook(book1);
                result.setCode(org.springframework.http.HttpStatus.FOUND.value());
                result.setMessage("书籍重复，本数+1");

            }else{
                dto.setBook_num(1);
                BeanUtils.copyProperties(dto,book);
                result.setData(book);
                bookService.addBook(book);
            }

        }catch (Exception e){
            result.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value);
            result.setMessage(e.getMessage());
            logger.error("新增参数错误{}",e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    @ApiOperation(value ="删除书籍",notes = "")
    @RequestMapping(value = "/delete/{book_id}",method = RequestMethod.DELETE)
    public BaseResult delete(@PathVariable String book_id){
        BaseResult result = new BaseResult();
        try {
            bookService.deleteBook(book_id);
            result.setMessage("删除成功");
        }catch (Exception e){
            result.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value);
            result.setMessage(e.getMessage());
            logger.error("根据ID删除错误：{}",e.getMessage());
            e.printStackTrace();
        }
        return result;
    }
}
