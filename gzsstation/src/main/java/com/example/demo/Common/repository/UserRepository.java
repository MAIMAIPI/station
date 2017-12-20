package com.example.demo.Common.repository;

import com.example.demo.Common.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    @Query("select u from User u where u.username=:name and u.password=:pass and u.status=:status")
    List<User> selectByUsernameAndPassword(@Param("name") String username,
                                           @Param("pass") String password, @Param("status") Integer status);
}
