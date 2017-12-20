package com.example.demo.Project.service;

import com.example.demo.Project.bean.Batch;
import com.example.demo.Project.repository.BatchRepository;
import com.example.demo.Utils.Constant;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class BatchService {
    @Autowired
    private BatchRepository batchRepository;

    public Batch save(Batch paramBatch) {
        return batchRepository.save(paramBatch);
    }
    public Page<Batch> selectBatchByPage(Integer page) {
        Sort.Order order=new Sort.Order(Sort.Direction.DESC,"bid");
        Sort sort=new Sort(order);
        PageRequest pageable=new PageRequest(page, Constant.small,sort);
        return batchRepository.selectBatchByPage(pageable);
    }
}
