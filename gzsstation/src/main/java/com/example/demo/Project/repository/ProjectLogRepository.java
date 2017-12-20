package com.example.demo.Project.repository;


import com.example.demo.Project.bean.ProjectLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectLogRepository extends JpaRepository<ProjectLog,Integer> {

}
