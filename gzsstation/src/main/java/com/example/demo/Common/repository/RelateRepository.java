package com.example.demo.Common.repository;

import com.example.demo.Common.bean.Relation;
import com.example.demo.Common.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RelateRepository extends JpaRepository<Relation,Integer>{
    @Query("select r.master from Relation r inner join r.apprentice a where a.uid=:aid")
    List<User> selectMasterByApprenticeId(@Param("aid") Integer aid);
    @Query("select r.apprentice from Relation r inner join r.master m where m.uid=:masterid")
    List<User> selectApprenticesByMaster(@Param("masterid") Integer masterid);
}
