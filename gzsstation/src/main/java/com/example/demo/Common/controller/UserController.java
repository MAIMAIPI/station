package com.example.demo.Common.controller;
import com.example.demo.Common.bean.User;
import com.example.demo.Common.service.UserService;
import com.example.demo.Project.bean.Project;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {
    public static final Logger logger= LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserService userService;
    @RequestMapping("/common/user/regist")
    @ResponseBody
    public User regist(User paramUser){
        User user=userService.save(paramUser);
        return user;
    }
    @RequestMapping("common/user/login")
    @ResponseBody
    public User login(User paramUser,
                      @RequestParam(name = "status",defaultValue ="0")Integer status){
        User user=userService.login(paramUser,status);
        return user;
    }
    @RequestMapping("/common/user/selectSelfProjectPage")
    @ResponseBody
    public Page<Project> selectSelfProjectPage(@RequestParam(name ="page",defaultValue ="1")Integer page,
                                               @RequestParam("userId")Integer uid){
        return userService.selectSelfProjectPage(uid,page-1);
    }
}
