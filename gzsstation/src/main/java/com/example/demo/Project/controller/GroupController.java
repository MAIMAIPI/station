package com.example.demo.Project.controller;

import com.example.demo.Project.service.GroupService;
import com.example.demo.Common.bean.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class GroupController {
    private static final Logger logger= LoggerFactory.getLogger(GroupController.class);
    @Autowired
    private GroupService groupService;

    @RequestMapping("/project/selectGroupMemberByProject")
    @ResponseBody
    public List<User> selectGroupMemberByProject(@Param("pid")Integer pid){
        return groupService.selectGroupMemberByProject(pid);
    }
}
