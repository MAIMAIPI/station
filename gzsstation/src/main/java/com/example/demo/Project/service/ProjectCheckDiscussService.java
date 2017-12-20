package com.example.demo.Project.service;

import com.example.demo.Common.bean.User;
import com.example.demo.Common.repository.UserRepository;
import com.example.demo.Project.bean.ProjectCheck;
import com.example.demo.Project.bean.ProjectCheckDiscuss;
import com.example.demo.Project.repository.ProjectCheckDiscussRepository;
import com.example.demo.Project.repository.ProjectCheckRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectCheckDiscussService {
    @Autowired
    private ProjectCheckDiscussRepository projectCheckDiscussRepository;
    @Autowired
    private ProjectCheckRepository projectCheckRepository;
    @Autowired
    private UserRepository userRepository;
    public ProjectCheckDiscuss save(Integer pcid, Integer sendUid, Integer acceptUid, ProjectCheckDiscuss discuss) {
        ProjectCheck projectCheck=projectCheckRepository.findOne(pcid);
        User send=userRepository.findOne(sendUid);
        User accept=userRepository.findOne(acceptUid);
        discuss.setAccept(accept);
        discuss.setSend(send);
        discuss.setProjectCheck(projectCheck);
        discuss.setTime(System.currentTimeMillis()+"");
        return projectCheckDiscussRepository.save(discuss);
    }

    public List<ProjectCheckDiscuss> selectProjectCheckDiscuss(Integer pcid) {
        return projectCheckDiscussRepository.selectProjectCheckDiscuss(pcid);
    }
}
