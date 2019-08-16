package com.wxy.mapper;

import com.wxy.pojo.Users;
import com.wxy.pojo.dto.UserQueryDto;

import java.util.List;

public interface UserMapper {

    List<Users> getUsersAll();

    Users getUserByUser_id(String user_id);

    Users getUserByUser_account(String user_account);

    Users addUser(Users users);

    void deleteUser(String user_id);

    void updateUser(Users users);

    Integer countPage(UserQueryDto query);

}
