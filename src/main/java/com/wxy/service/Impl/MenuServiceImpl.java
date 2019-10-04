package com.wxy.service.Impl;

import com.wxy.mapper.MenuMapper;
import com.wxy.pojo.Menu;
import com.wxy.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuMapper menuMapper;

    @Override
    public List<Menu> getMenuById(String user_id) {
        return menuMapper.getMenuById(user_id);
    }
}
