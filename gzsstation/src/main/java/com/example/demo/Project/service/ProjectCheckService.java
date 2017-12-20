package com.example.demo.Project.service;

import com.example.demo.Common.bean.User;
import com.example.demo.Common.repository.UserRepository;
import com.example.demo.Project.bean.Project;
import com.example.demo.Project.bean.ProjectCheck;
import com.example.demo.Project.bean.ProjectCheckDiscuss;
import com.example.demo.Project.repository.GroupRepository;
import com.example.demo.Project.repository.ProjectCheckRepository;
import com.example.demo.Project.repository.ProjectRepository;
import com.example.demo.Utils.Constant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectCheckService {
    private Logger logger= LoggerFactory.getLogger(ProjectCheckService.class);
    @Autowired
    private ProjectRepository projectRepository;
    @Autowired
    private GroupRepository groupRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ProjectCheckRepository projectCheckRepository;
    public ProjectCheck save(Integer pid, Integer uid, ProjectCheck paramProjectCheck) {
        User user=userRepository.findOne(uid);
        //后期 需求可能要对检查人进行拦截和判断
        Project project=projectRepository.findOne(pid);
        paramProjectCheck.setUser(user);
        paramProjectCheck.setProject(project);
        Long time=System.currentTimeMillis();
        paramProjectCheck.setTime(String.valueOf(time));
        return projectCheckRepository.save(paramProjectCheck);
    }

    public Page<ProjectCheck> selectProjectCheckPageByPid(Integer pid, Integer page) {
        Sort.Order order=new Sort.Order(Sort.Direction.DESC,"pcid");
        Sort sort=new Sort(order);
        PageRequest pageable=new PageRequest(page, Constant.six,sort);
        return projectCheckRepository.selectProjectCheckPageByPid(pageable,pid);
    }
}
