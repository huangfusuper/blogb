package com.blog.controller;

import com.blog.entrty.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * 测试页面显示类
 * @author 皇甫
 */
@RestController
public class TestUserController {
    private List<User> users = new ArrayList<User>();
    {
     users.add(new User("1","张三","123456"));
     users.add(new User("2","李四","564321"));
     users.add(new User("3","王五","78943432  098"));
     users.add(new User("4","赵柳","098765"));
    }


    @GetMapping("users.html")
    public ModelAndView getUsers(){
        return new ModelAndView("/user/user","userList",users);
    }

}
