package com.example.demo.Project.repository;

import com.example.demo.Project.bean.ProjectCheckDiscuss;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectCheckDiscussRepository extends JpaRepository<ProjectCheckDiscuss,Integer>{
    @Query("select pcd from ProjectCheckDiscuss pcd inner join pcd.projectCheck pc where pc.pcid=:pcid")
    List<ProjectCheckDiscuss> selectProjectCheckDiscuss(@Param("pcid") Integer pcid);
}
