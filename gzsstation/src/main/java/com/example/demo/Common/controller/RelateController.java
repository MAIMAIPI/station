package com.example.demo.Common.controller;
import com.example.demo.Common.bean.Relation;
import com.example.demo.Common.bean.User;
import com.example.demo.Common.service.RelateService;
import org.omg.CORBA.INTERNAL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class RelateController {
    private static final Logger logger= LoggerFactory.getLogger(RelateController.class);
    @Autowired
    private RelateService relateService;
    @RequestMapping("/common/realte/add")//?masterid= &apprenticeid=
    @ResponseBody
    public List<Relation> addRelation(@RequestParam(name="masterid")Integer masterid,
                                @RequestParam(name="apprenticeid")List<Integer> apprenticeid){
        return relateService.addRelation(masterid,apprenticeid);
    }
    @RequestMapping("/common/relate/selectMasterByApprentice")
    @ResponseBody
    public User selectMasterByApprenticeId(@RequestParam("apprenticeid")Integer aid){
        return relateService.selectMasterByApprenticeId(aid);
    }
    @RequestMapping("/common/relate/selectApprenticesByMaster")
    @ResponseBody
    public List<User> selectApprenticesByMaster(@RequestParam(name="masterid")Integer masterid){
        return relateService.selectApprenticesByMaster(masterid);
    }
}
