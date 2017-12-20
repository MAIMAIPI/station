package com.example.demo.Project.controller;

import com.example.demo.Project.bean.Project;
import com.example.demo.Project.service.ProjectService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 后期需要根据是否是url传入进行处理,以及数据完整性校验
 * 所有对数据库的添加或者删除,和需要用户登录的,都需要经过特殊的校验,如token
 */
@Controller
public class ProjectController {
    public static final Logger logger= LoggerFactory.getLogger(ProjectController.class);
    @Autowired
    private ProjectService projectService;
    @RequestMapping("/project/creatProject")
    @ResponseBody
    public Project creatProject(Project paramProject, @Param("bid")Integer bid,
           @RequestParam(name ="uid")List<Integer> uidList, @Param("lid")Integer lid){
        return projectService.save(bid,paramProject,lid,uidList);
    }
    @RequestMapping("/project/selectProjectPageByBatch")
    @ResponseBody
    public Page<Project> selectProjectPageByBatchId(@Param("bid")Integer bid,
                  @RequestParam(defaultValue ="1",name ="page")Integer page){
        return projectService.selectProjectPageByBatchId(bid,page-1);
    }
}
