package com.example.demo.Common.service;

import com.example.demo.Common.bean.User;
import com.example.demo.Common.repository.UserRepository;
import com.example.demo.Project.bean.Project;
import com.example.demo.Project.repository.GroupRepository;
import com.example.demo.Utils.Constant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.SocketHandler;


@Service
public class UserService {
    private Logger logger= LoggerFactory.getLogger(UserService.class);
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private GroupRepository groupRepository;
    public User save(User paramUser) {
        return userRepository.save(paramUser);
    }

    public User login(User paramUser, Integer status) {
        List<User> userList=userRepository.selectByUsernameAndPassword(paramUser.getUsername()
                ,paramUser.getPassword(),status);
        if(userList!=null&&userList.size()!=0)return userList.get(0);
        return null;
    }

    public Page<Project> selectSelfProjectPage(Integer uid, int page) {
        PageRequest pageable=new PageRequest(page, Constant.six);
        return groupRepository.selectSelfProjectPage(uid,page);
    }
}
