package com.example.demo.Project.service;

import com.example.demo.Common.bean.User;
import com.example.demo.Common.repository.UserRepository;
import com.example.demo.Common.service.UserService;
import com.example.demo.Project.bean.Project;
import com.example.demo.Project.bean.ProjectItem;
import com.example.demo.Project.repository.ProjectItemRepository;
import com.example.demo.Project.repository.ProjectRepository;
import com.example.demo.Utils.Constant;
import com.example.demo.Utils.DirDeal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.jws.soap.SOAPBinding;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class ProjectItemService {
    private String storeFileByPathAndReturnContextPath(MultipartFile file,String path){
        if (file.isEmpty()) {
            return null;
        }
        String fileName = file.getOriginalFilename();
        logger.info("上传的文件名为：" + fileName);
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        logger.info("上传的后缀名为：" + suffixName);
        String contextPath=path+fileName;
        File dest = new File(Constant.dynamicResoruce+contextPath);
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            file.transferTo(dest);
            logger.info("上传成功");
            return contextPath;
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static final Logger logger= LoggerFactory.getLogger(ProjectItemService.class);
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ProjectItemRepository projectItemRepository;
    @Autowired
    private ProjectRepository projectRepository;
    public ProjectItem createProjectItem(Integer projectPid, Integer uid) {
        List<ProjectItem> projectItems=projectItemRepository.selectLatestItemByProjectId(projectPid);
        if(projectItems!=null&&projectItems.size()!=0)return projectItems.get(0);//已经存在 直接返回
        User user=userRepository.findOne(uid);
        Project project=projectRepository.findOne(projectPid);
        ProjectItem paramProjectItem=new ProjectItem();
        paramProjectItem.setProject(project);
        paramProjectItem.setSubmitPerson(user.getRealname());
        Long time=System.currentTimeMillis();
        paramProjectItem.setTime(String.valueOf(time));
        return projectItemRepository.save(paramProjectItem);
    }

    public ProjectItem selectLatestItemByProjectId(Integer projectId) {
        List<ProjectItem> projectItemList=projectItemRepository.
                selectLatestItemByProjectId(projectId);
        if(projectItemList!=null&&projectItemList.size()!=0)return projectItemList.get(0);
        return null;
    }

    public ProjectItem updateLink(Integer piid, Integer uid, String link) {
        ProjectItem projectItem=projectItemRepository.findOne(piid);
        User user=userRepository.findOne(uid);
        projectItem.setSubmitPerson(user.getRealname());
        projectItem.setLink(link);
        Long time=System.currentTimeMillis();
        projectItem.setTime(String.valueOf(time));
        return projectItemRepository.save(projectItem);
    }


    public ProjectItem updateFunOrNeedFile(MultipartFile file, Integer piid, Integer type,Integer uid ) {
        User user=userRepository.findOne(uid);
        String modelPath="Project"+File.separator+"ProjectItem"+
                File.separator+user.getUid()+File.separator;
        /*项目绝对路径放在常量类中   后面带有/
        创建文件夹   Project是模块  ProjectItem是类名  后期优化的时候再加上用户id
        避免一个文件夹下文件数目过多    同时模块和类的名字一定要对,否则找不到对应的文件*/
        String contextPath=storeFileByPathAndReturnContextPath(file,modelPath);
        String resourcePath=Constant.RESOURCE+contextPath;
        /*存储文件到tomcat容器,同时返回相对路径存储到数据库  资源文件存放在resource下
         */
        ProjectItem projectItem=projectItemRepository.findOne(piid);
        if(type==0) projectItem.setPicture(resourcePath);
        else if(type==1)projectItem.setNeedPath(resourcePath);
        else if(type==2)projectItem.setFunPath(resourcePath);
        return projectItemRepository.save(projectItem);
    }
}
