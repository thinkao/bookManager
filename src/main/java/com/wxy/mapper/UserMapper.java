package com.wxy.mapper;

import com.wxy.pojo.Users;
import com.wxy.pojo.dto.UserQueryDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface UserMapper {

    List<Users> getUsersAll();

    Users getUserByUser_id(String user_id);

    Users getUserByUser_account(String user_account);

    Users addUser(Users users);

    void deleteUser(String user_id);

    void updateUser(Users users);

    void updateUserRole(Users users);

    Integer countPage(UserQueryDto query);

}
