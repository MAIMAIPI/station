package com.example.demo.Project.repository;

import com.example.demo.Project.bean.ProjectCheck;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

@Repository
public interface ProjectCheckRepository extends JpaRepository<ProjectCheck,Integer>{
    @Query("select pc from ProjectCheck pc inner join pc.project p where p.pid=:pid")
    Page<ProjectCheck> selectProjectCheckPageByPid(Pageable pageable,@Param("pid") Integer pid);
}
