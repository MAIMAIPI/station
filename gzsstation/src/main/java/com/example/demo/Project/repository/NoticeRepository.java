package com.example.demo.Project.repository;

import com.example.demo.Project.bean.Notice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoticeRepository extends JpaRepository<Notice,Integer>{
}
