package com.offcn.controller;

import com.offcn.entity.User;
import com.offcn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.OverridesAttribute;
import java.util.Map;

//restFull 风格是想controller 用于完成提供者
@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    private UserService userService;

    //查询所有的数据 get
    @GetMapping("/")
    public Map<String,Object> findAll(){
       return userService.findAll();
    }

    //向数据库增加数据
    @PostMapping("/")
    public String saveUser(@RequestBody User user){
        try {
            userService.saveInfo(user);
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }

    //从数据库查询一条数据
    @GetMapping("/{id}")
    public User findUser(@PathVariable("id") Long id){
        User user =null;
        try {
            user = userService.findOne(id);
        } catch (Exception e) {
            e.printStackTrace();
            return user;
        }
        return user;
    }

    //修改数据库一条数据
    @PutMapping("/")
    public String updateUser(@RequestBody User user){
        try {
            userService.updateInfo(user);
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }

    //删除一条数据
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") Long id){
        try {
            userService.deleteInfo(id);
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }

}
