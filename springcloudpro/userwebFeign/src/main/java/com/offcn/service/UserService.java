package com.offcn.service;

import com.offcn.config.FeignConfig;
import com.offcn.entity.User;
import com.offcn.service.impl.UserServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@FeignClient(value = "USERPROVIDER",configuration = FeignConfig.class,fallback = UserServiceImpl.class)
public interface UserService {

    //向数据库增加信息
    @PostMapping("/users/")
    public void saveInfo(@RequestBody User user);

    //查询全部的数据
    @GetMapping("/users/")
    public Map<String,Object> findAll();

    //查询一条数据
    @GetMapping("/users/{id}")
    public User findOne(@PathVariable("id") Long id);

    //修改数据
    @PutMapping("/")
    public void updateInfo(User user);

    //删除信息
    @DeleteMapping("/")
    public void deleteInfo(Long id);

}
