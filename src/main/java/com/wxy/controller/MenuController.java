package com.wxy.controller;

import com.wxy.response.BaseResult;
import com.wxy.service.MenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/menu")
@Api("菜单管理")
public class MenuController {

    private static final Logger logger = LoggerFactory.getLogger(MenuController.class);

    @Autowired
    private MenuService menuService;

    @ApiOperation("根据ID查询")
    @GetMapping("/getMenuById/{user_id}")
    public BaseResult getMenuById(@PathVariable String user_id){
        BaseResult result = new BaseResult();
        try {
            result.setData(menuService.getMenuById(user_id));
        }catch (Exception e){
            result.setCode(org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR.value());
            result.setMessage(e.getMessage());
            logger.error("根据ID查询错误{}", e.getMessage());
            e.printStackTrace();
        }
        return result;
    }
}
