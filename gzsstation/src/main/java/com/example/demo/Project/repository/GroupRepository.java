package com.example.demo.Project.repository;

import com.example.demo.Project.bean.Group;
import com.example.demo.Common.bean.User;
import com.example.demo.Project.bean.Project;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Repository
public interface GroupRepository extends JpaRepository<Group,Integer>{
    @Query("select g.user from Group g inner join g.project p where p.pid=:pid order by g.degree desc ")
    List<User> selectGroupMemberByProject(@Param("pid") Integer pid);
    @Query("select g.user from Group g inner join g.project p where p.pid=:pid order by g.degree desc ")
    List<User> selectGroupLeaderByProjectId(@Param("pid") Integer pid);
    @Query("select g.project from Group g inner join g.user u where u.uid=:uid order by g.degree")
    Page<Project> selectSelfProjectPage(@Param("uid") Integer uid, int page);
}
