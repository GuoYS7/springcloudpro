package com.offcn.service;

import com.offcn.entity.User;

import java.util.Map;

public interface UserService {

    //向数据库增加信息
    public void saveInfo(User user);

    //查询全部的数据
    public Map<String,Object> findAll();

    //查询一条数据
    public User findOne(Long id);

    //修改数据
    public void updateInfo(User user);

    //删除信息
    public void deleteInfo(Long id);

}
