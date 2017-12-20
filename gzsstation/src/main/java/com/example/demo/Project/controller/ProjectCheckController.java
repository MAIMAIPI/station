package com.example.demo.Project.controller;

import com.example.demo.Project.bean.ProjectCheck;
import com.example.demo.Project.service.ProjectCheckService;
import com.example.demo.Project.service.ProjectService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class ProjectCheckController {
    private static final Logger logger= LoggerFactory.getLogger(ProjectCheckController.class);
    @Autowired
    private ProjectCheckService projectCheckService;

    @RequestMapping("/project/addProjectCheck")
    @ResponseBody
    public ProjectCheck addProjectCheck(@RequestParam("projectId")Integer pid,
            @RequestParam("userId")Integer uid,ProjectCheck paramProjectCheck){
        return projectCheckService.save(pid,uid,paramProjectCheck);
    }
    @RequestMapping("/project/selectProjectCheckPage")//此处需要将最新的内容放在第一页
    @ResponseBody//create后期需要加token
    public Page<ProjectCheck> selectProjectCheckPageByPid(@RequestParam("projectId")Integer pid,
                @RequestParam(name ="page",defaultValue ="1")Integer page){
        return projectCheckService.selectProjectCheckPageByPid(pid,page-1);
   }

}
