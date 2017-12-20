package com.example.demo.Project.controller;

import com.example.demo.Project.bean.Batch;
import com.example.demo.Project.service.BatchService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BatchController {
    private static final Logger logger= LoggerFactory.getLogger(BatchController.class);
    @Autowired
    private BatchService batchService;
    @RequestMapping("/project/addBatch")
    @ResponseBody
    public Batch addBatch(Batch paramBatch){
        return batchService.save(paramBatch);
    }
    @RequestMapping("/project/selectBatchPage")
    @ResponseBody
    public Page<Batch> selectBatchByPage(@RequestParam(defaultValue ="1",name ="page")Integer page){
        Page<Batch> batchPage=batchService.selectBatchByPage(page-1);//实际下标从0开始
        return batchPage;
    }
}
