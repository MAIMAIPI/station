package com.example.demo.Project.repository;

import com.example.demo.Project.bean.Batch;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

@Repository
public interface BatchRepository extends JpaRepository<Batch,Integer> {
    @Query("select b from Batch b ")
    Page<Batch> selectBatchByPage(Pageable pageable);
}
