package com.example.demo.Project.repository;

import com.example.demo.Project.bean.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

@Repository
public interface DocumentRepository extends JpaRepository<Document,Integer>{
}
