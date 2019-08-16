package com.wxy.service;

import com.wxy.page.PageQuery;
import com.wxy.pojo.Users;

import java.util.List;

public interface UserService<T extends PageQuery> {

    List<Users> getUsersAll(T query);

    List<Users> getUsersAll();/*测试数据*/

    Users getUserByUser_id(String user_id);

    Users getUserByUser_account(String user_account);

    Users addUser(Users users);

    void deleteUser(String user_id);

    Users updateUser(Users users);

    Integer countPage(T query);

}
