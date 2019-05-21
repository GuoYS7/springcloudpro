package com.offcn.controller;

import com.offcn.entity.User;
import com.offcn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
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


    //显示全部信息列表 跳转页面
    @RequestMapping("list")
    public String getAll(Model model){
        Map<String,Object> map = userService.findAll();
        model.addAttribute("page",map.get("list"));
        model.addAttribute("version",map.get("version"));
        return "list";
    }

    //查询一条数据

    //修改数据

    //删除数据

}
