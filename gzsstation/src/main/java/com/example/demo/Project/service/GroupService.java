package com.example.demo.Project.service;

import com.example.demo.Project.repository.GroupRepository;
import com.example.demo.Common.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupService {
    @Autowired
    private GroupRepository groupRepository;

    public List<User> selectGroupMemberByProject(Integer pid) {
        return groupRepository.selectGroupMemberByProject(pid);
    }
}
