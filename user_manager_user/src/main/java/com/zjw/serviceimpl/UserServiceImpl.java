package com.zjw.serviceimpl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.zjw.Email;
import com.zjw.User;
import com.zjw.dao.UserMapper;
import com.zjw.service.IEmailService;
import com.zjw.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public int insert(User user) {
        return userMapper.insert(user);
    }

    @Override
    public List<User> queryBy(Map<String,Object> map) {
        return userMapper.selectByMap(map);
    }

    @Override
    public int resetPwd(User user) {

        return userMapper.updateById(user);
    }

}
