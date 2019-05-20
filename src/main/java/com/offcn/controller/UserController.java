package com.offcn.controller;

import com.offcn.entity.User;
import com.offcn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.jws.soap.SOAPBinding;
import java.util.List;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    //向数据库增加信息
    public String saveInfo(User user){
        try {
            userService.saveInfo(user);
            return "suceess";
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }

    //显示全部的数据
    @GetMapping("/")
    @ResponseBody
    public List<User> findAll(){
        return userService.findAll();
    }

    //显示全部信息列表 跳转页面
    @RequestMapping("list")
    public String getAll(Model model){
        List<User> list = userService.findAll();
        model.addAttribute("page",list);
        return "list";
    }

//    //分页查询
//    @GetMapping("/{name}/{page}/{size}")
//    public Slice<User> search(@PathVariable("name") String name,@PathVariable("page") int page,@PathVariable("size") int size){
//        return userService.searchUser(name,PageRequest.of(page,size));
//    }

    @GetMapping("search/{name}/{page}/{size}")
    @ResponseBody
    public Slice<User> search(@PathVariable("name") String name,@PathVariable("page") int page,@PathVariable("size") int size){
        page-=1;
        return userService.searchUser(name,PageRequest.of(page, size));
    }
}
