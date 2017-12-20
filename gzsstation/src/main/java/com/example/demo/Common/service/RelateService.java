package com.example.demo.Common.service;

import com.example.demo.Common.bean.Relation;
import com.example.demo.Common.bean.User;
import com.example.demo.Common.repository.RelateRepository;
import com.example.demo.Common.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RelateService {
    @Autowired
    private RelateRepository relateRepository;
    @Autowired
    private UserRepository userRepository;
    public List<Relation> addRelation(Integer masterUid, List<Integer> apprenticeUid) {
        User master=userRepository.findOne(masterUid);
        List<Relation> relations=new ArrayList<>();
        for(int i=0;i<apprenticeUid.size();i++){
            User apprentice=userRepository.findOne(apprenticeUid.get(i));
            Relation relation=new Relation();
            relation.setApprentice(apprentice);
            relation.setMaster(master);
            Relation result=relateRepository.save(relation);
            relations.add(result);
        }
        return relations;
    }

    public User selectMasterByApprenticeId(Integer aid) {
        List<User> userList=relateRepository.selectMasterByApprenticeId(aid);
        if(userList!=null&&userList.size()!=0) return userList.get(0);
        return null;
    }

    public List<User> selectApprenticesByMaster(Integer masterid) {
        return relateRepository.selectApprenticesByMaster(masterid);
    }
}
