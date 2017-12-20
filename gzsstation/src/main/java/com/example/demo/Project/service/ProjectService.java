package com.example.demo.Project.service;

import com.example.demo.Project.bean.*;
import com.example.demo.Project.repository.BatchRepository;
import com.example.demo.Project.repository.GroupRepository;
import com.example.demo.Project.repository.ProjectRepository;
import com.example.demo.Utils.Constant;
import com.example.demo.Common.repository.UserRepository;
import com.example.demo.Common.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {
    @Autowired
    private ProjectRepository projectRepository;
    @Autowired
    private BatchRepository batchRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private GroupRepository groupRepository;
    public Project save(Integer bid, Project paramProject, Integer lid, List<Integer> uidList) {

        Batch batch=batchRepository.findOne(bid);
        paramProject.setBatch(batch);
        long l = System.currentTimeMillis();
        paramProject.setStartTime(String.valueOf(l));
        Project project=projectRepository.save(paramProject);
        for(int i=0;i<uidList.size();i++){
            Group group=new Group();
            User user=userRepository.findOne(uidList.get(i));
            group.setDegree(0);//普通成员
            group.setProject(project);
            group.setUser(user);
            groupRepository.save(group);
        }
        User leader=userRepository.findOne(lid);
        if(leader!=null){
            Group group=new Group();
            group.setUser(leader);
            group.setDegree(1);
            group.setProject(project);
            groupRepository.save(group);
        }
        return project;
    }


    public Page<Project> selectProjectPageByBatchId(Integer bid, Integer page) {
        Sort.Order order=new Sort.Order(Sort.Direction.ASC,"pid");
        Sort sort=new Sort(order);
        PageRequest pageable=new PageRequest(page, Constant.mid,sort);
        return projectRepository.selectProjectPageByBatchId(bid,pageable);
    }
}
