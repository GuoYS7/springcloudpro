package com.offcn.service.impl;

import com.offcn.entity.User;
import com.offcn.service.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public void saveInfo(User user) {
        System.out.println("创建用户出错");
    }

    @Override
    public Map<String, Object> findAll() {
        Map<String,Object> map = new HashMap<>();
        map.put("list",new ArrayList<>());
        map.put("version", "获取远程调用失败");
        return map;
    }

    @Override
    public User findOne(Long id) {
        System.out.println("获取用户ID"+id+"获取用户出错");
        return null;
    }

    @Override
    public void updateInfo(User user) {
        System.out.println("修改用户出错");
    }

    @Override
    public void deleteInfo(Long id) {
        System.out.println("删除用户出错");
    }
}
