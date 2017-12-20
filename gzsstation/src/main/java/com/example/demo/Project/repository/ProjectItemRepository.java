package com.example.demo.Project.repository;

import com.example.demo.Project.bean.ProjectItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@ResponseBody
public interface ProjectItemRepository extends JpaRepository<ProjectItem,Integer>{
    @Query("select pi from ProjectItem pi inner join pi.project p where p.pid=:pid")
    List<ProjectItem> selectLatestItemByProjectId(@Param("pid") Integer projectId);
}
