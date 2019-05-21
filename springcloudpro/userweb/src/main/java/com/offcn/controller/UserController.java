package com.offcn.controller;

import com.offcn.entity.User;
import com.offcn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    @RequestMapping("/add")
    public String saveInfo(User user){
        userService.saveInfo(user);
        return "redirect:/user/list";
    }

    @RequestMapping("/toAdd")
    public String toAdd(){
        return "userAdd";
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
    @RequestMapping("/toEdit/{id}")
    public String toEdit(@PathVariable("id") Long id,Model model){
          User one = userService.findOne(id);
          model.addAttribute("user",one);
          return "userEdit";
    }

    //修改数据
    @RequestMapping("edit")
     public String Edit(User user){
        userService.updateInfo(user);
        return "redirect:/user/list";
     }
    //删除数据
    @RequestMapping("delete/{id}")
    public String delete(@PathVariable("id") Long id){
        userService.deleteInfo(id);
        return "redirect:/user/list";
    }

}
