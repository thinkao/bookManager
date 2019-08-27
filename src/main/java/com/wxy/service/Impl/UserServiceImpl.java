package com.wxy.service.Impl;
import com.wxy.mapper.UserMapper;
import com.wxy.mapper.UserRepository;
import com.wxy.page.PageQuery;
import com.wxy.pojo.Users;
import com.wxy.pojo.dto.UserQueryDto;
import com.wxy.service.UserService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class UserServiceImpl implements UserService<UserQueryDto>{

    //private static final Logger logger = (Logger) LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<Users> getUsersAll(UserQueryDto query) {
        return userMapper.getUsersAll();
    }

    @Override
    public Users getUserByUser_id(String user_id) {
        Optional<Users> o =  userRepository.findById(user_id);
        return o.orElse(null);
    }

    @Override
    public Users getUserByUser_account(String user_account) {
        return userMapper.getUserByUser_account(user_account);
    }

    @Override
    public Users addUser(Users users) {
        Users result = null;
        if(users!=null){
            result = userRepository.save(users);
        }
        return result;
    }


    @Override
    public void deleteUser(String user_id) {
        userMapper.deleteUser(user_id);
    }

    @Override
    public Users updateUser(Users users) {
        Users result = null;
        if(users!=null){
            result = userRepository.save(users);
        }
        return result;
    }

    @Override
    public Integer countPage(UserQueryDto query) {
        return userMapper.countPage(query);
    }
}
