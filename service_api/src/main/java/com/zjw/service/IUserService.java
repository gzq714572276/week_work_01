package com.zjw.service;

import com.zjw.Email;
import com.zjw.User;

import java.util.List;
import java.util.Map;

public interface IUserService {
    int insert(User user);

    List<User> queryBy(Map<String,Object> map);

    int resetPwd(User user);

}
