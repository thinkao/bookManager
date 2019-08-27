package com.wxy.controller;

import com.google.gson.Gson;
import com.wxy.config.GlobalConfig;
import com.wxy.page.PageResult;
import com.wxy.pojo.Users;
import com.wxy.pojo.dto.UserInsertDto;
import com.wxy.pojo.dto.UserLoginDto;
import com.wxy.pojo.dto.UserQueryDto;
import com.wxy.pojo.dto.UserUpdateDto;
import com.wxy.response.BaseResult;
import com.wxy.response.HttpStatus;
import com.wxy.service.UserService;
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

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
@CrossOrigin
@Api("用户管理")
@RestController
@RequestMapping("/user")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @PostMapping("/addUser")
    @ApiOperation("添加新用户")
    public BaseResult insert(@RequestBody @Validated UserInsertDto dto, BindingResult bindingResult){

        BaseResult result = new BaseResult();

        /*校验参数*/
        if(bindingResult.hasErrors()){
            FieldError fieldError =  bindingResult.getFieldError();
            logger.error("新增参数错误：{}",fieldError.getDefaultMessage());
            result.setCode(HttpStatus.BAD_REQUEST.value);
            result.setMessage((fieldError.getDefaultMessage()));
            return result;
        }

        Users users = new Users();
        String user_account = dto.getUser_account();
        String user_pass = dto.getUser_pass();
        try{
            Users user = userService.getUserByUser_account(user_account);
            if(user != null){
                result.setCode(org.springframework.http.HttpStatus.FOUND.value());
                result.setMessage("该用户已存在");
            }else{
                BeanUtils.copyProperties(dto,users);
                result.setData(users);
                userService.addUser(users);
            }

        }catch (Exception e){
            result.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value);
            result.setMessage(e.getMessage());
            logger.error("新增参数错误{}",e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    @ApiOperation("删除用户")
    @DeleteMapping("/deleteUser/{user_id}")
    public BaseResult deleteUser(@PathVariable String user_id){
        BaseResult result = new BaseResult();

        try {
            userService.deleteUser(user_id);
        }catch (Exception e){
            result.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value);
            result.setMessage(e.getMessage());
            logger.error("根据ID删除错误：{}",e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    @ApiOperation("修改用户信息")
    @PutMapping("/update")
    public BaseResult updateUser(@RequestBody @Validated UserUpdateDto dto, BindingResult bindingResult){
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
            Users users1 = userService.getUserByUser_id(dto.getUser_id());
            if(users1 != null){
                BeanUtils.copyProperties(dto, users1);
                userService.updateUser(users1);
            }
        }catch (Exception e){
            result.setCode(org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR.value());
            result.setMessage(e.getMessage());
            logger.error("修改错误{}", e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    @ApiOperation("分页查询")
    @RequestMapping(value = "/getPageUser",method = RequestMethod.GET)
    public BaseResult getPageUser(UserQueryDto query){

        BaseResult result = new BaseResult();

        PageResult<Users> page =new PageResult<>();

        /*初始化参数分页*/
        query.init();

        try {
            int total = userService.countPage(query);
            System.out.println("共有数据条数为"+total);
            page.setTotal(total);
            if(total>0){
                page.setRows(userService.getUsersAll(query));
            }
        }catch (Exception e){
            result.setCode(org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR.value());
            result.setMessage(e.getMessage());
            logger.error("分页查询错误{}", e.getMessage());
            e.printStackTrace();
        }
        result.setData(page);
        return result;
    }

    @ApiOperation("根据ID查询")
    @GetMapping("/getById")
    public BaseResult getById(@PathVariable String user_id){

        BaseResult result = new BaseResult();

        try {
            result.setData(userService.getUserByUser_id(user_id));
        }catch (Exception e){
            result.setCode(org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR.value());
            result.setMessage(e.getMessage());
            logger.error("根据ID查询错误{}", e.getMessage());
            e.printStackTrace();
        }
        return result;
    }
    @ApiOperation("登录")
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public BaseResult login(@RequestBody @Validated UserLoginDto dto, BindingResult bindingResult){
        BaseResult result = new BaseResult();
        // 校验参数
        if (bindingResult.hasErrors()) {
            FieldError fieldError = bindingResult.getFieldError();
            logger.error("登录参数错误:{}", fieldError.getDefaultMessage());
            result.setCode(org.springframework.http.HttpStatus.BAD_REQUEST.value());
            result.setMessage(fieldError.getDefaultMessage());
            return result;
        }

        // 此处的密码应该是按照后台的加密规则加密过的，不应该传输明文密码
        String user_account = dto.getUser_account();
        String user_pass = dto.getUser_pass();
        System.out.println("用户名"+user_account);
        System.out.println("密码"+user_pass);
        try {
            Users user = userService.getUserByUser_account(user_account);
            if(user == null){
                result.setCode(org.springframework.http.HttpStatus.UNAUTHORIZED.value());
                result.setMessage("用户不存在");

            }else{

                String pass = user.getUser_pass();
                if(pass.equals(user_pass)){

                    Gson gson = new Gson();
                    String userJson = gson.toJson(user);
                    result.setData(userJson);
                    result.setMessage("登录成功");


                }else{
                    result.setCode(org.springframework.http.HttpStatus.UNAUTHORIZED.value());
                    result.setMessage("用户名或密码错误");
                }
            }
        } catch (Exception e) {
            result.setCode(org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR.value());
            result.setMessage("登录错误");
            logger.error("登录错误{}", e.getMessage());
            e.printStackTrace();
        }
        return result;
    }
}
