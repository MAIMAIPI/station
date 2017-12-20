package com.example.demo.Project.controller;

import com.example.demo.Project.bean.ProjectCheck;
import com.example.demo.Project.bean.ProjectCheckDiscuss;
import com.example.demo.Project.service.ProjectCheckDiscussService;
import com.example.demo.Project.service.ProjectCheckService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ProjectCheckDiscussController {
    private static final Logger logger=LoggerFactory.getLogger(ProjectCheckDiscussController.class);
    @Autowired
    private ProjectCheckDiscussService projectCheckDiscussService;

    @RequestMapping("/project/addProjectCheckDiscuss")
    @ResponseBody
    public ProjectCheckDiscuss addProjectCheckDiscuss(@RequestParam("projectCheckId")Integer pcid,
                  @RequestParam("sendUid")Integer sendUid, @RequestParam("acceptUid")
                  Integer acceptUid, ProjectCheckDiscuss discuss){
        return projectCheckDiscussService.save(pcid,sendUid,acceptUid,discuss);
    }
    @RequestMapping("/project/selectProjectCheckDiscuss")
    @ResponseBody//将一个检查的全部谈话读取出来,后期更改的时候,需要设置每次下拉加载的条数,和当前下拉次数
    public List<ProjectCheckDiscuss> selectProjectCheckDiscuss(
            @RequestParam("ProjectCheckId") Integer pcid){
        return projectCheckDiscussService.selectProjectCheckDiscuss(pcid);
    }
}
