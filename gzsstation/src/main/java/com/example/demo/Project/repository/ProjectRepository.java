package com.example.demo.Project.repository;

import com.example.demo.Project.bean.Project;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<Project,Integer>{
    @Query("select p from Project p inner join p.batch b  where b.bid=:bid")
    Page<Project> selectProjectPageByBatchId(@Param("bid") Integer bid, Pageable pageable);
}
