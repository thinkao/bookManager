package com.wxy.mapper;

import com.wxy.pojo.Menu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MenuMapper {

    List<Menu> getMenuById(String user_id);

}
