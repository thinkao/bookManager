package com.wxy.service;

import com.wxy.pojo.Menu;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface MenuService {

    List<Menu> getMenuById(String user_id);

}
