package com.example.demo.Project.controller;

import com.example.demo.Project.bean.Project;
import com.example.demo.Project.bean.ProjectItem;
import com.example.demo.Project.service.ProjectItemService;
import com.example.demo.Project.service.ProjectService;
import org.omg.PortableInterceptor.INACTIVE;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

/**
 * 上传的过程中直接从session中获取数据更好，但是在url测试的时候，只能从传id 的方式
 * 所有对与他的修改都用异步请求
 */
@Controller
public class ProjectItemController {
    private static final Logger logger= LoggerFactory.getLogger(ProjectItemController.class);
    @Autowired
    private ProjectItemService projectItemService;
    @RequestMapping("/projectItem/createProjectItem")//为空  只创建一个
    @ResponseBody//同时记录创建的人  前期url测试可能插入多条同样的数据
    public ProjectItem createProjectItem(
            @RequestParam(name ="pid")Integer projectPid,@RequestParam("uid")Integer uid){
        return projectItemService.createProjectItem(projectPid,uid);
    }
    @RequestMapping("/projectItem/selectLatestItemByProject")
    @ResponseBody
    public ProjectItem selectLatestItemByProjectId(@RequestParam("pid")Integer projectId){
        return projectItemService.selectLatestItemByProjectId(projectId);
    }
    @RequestMapping("/projectItem/updateLink")//传入链接和 projectitem 的id
    @ResponseBody
    public ProjectItem updateLink(@RequestParam("projectItemId") Integer piid,
          @RequestParam("userId")Integer uid, @RequestParam("link")String link){
        return projectItemService.updateLink(piid,uid,link);
    }

    @RequestMapping("/projectItem/updateFile")//更新文件,根据传入的参数去确定更新哪一个
    @ResponseBody  //0表示跟新图片 1需求文档, 2表示更新功能技术点
    public ProjectItem updateFunOrNeedFile(@RequestParam("file")MultipartFile file,
                                  @RequestParam("projectItemId") Integer piid,
              @RequestParam("userId")Integer uid,@RequestParam("type")Integer type){
        return projectItemService.updateFunOrNeedFile(file,piid,type,uid);
    }

}
