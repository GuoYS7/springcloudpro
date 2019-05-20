package com.offcn.service;

import com.offcn.entity.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

import java.util.List;

public interface UserService {

    //向数据库增加信息
    public void saveInfo(User user);

    //查询全部的数据
    public List<User> findAll();

    //查询一条数据
    public User findOne(Long id);

    //修改数据
    public void updateInfo(User user);

    //删除信息
    public void deleteInfo(Long id);

    //分页查询
    public Slice<User> searchUser(String name,Pageable pageable);
}
