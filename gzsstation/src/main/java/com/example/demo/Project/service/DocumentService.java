package com.example.demo.Project.service;

import com.example.demo.Project.repository.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DocumentService {
    @Autowired
    private DocumentRepository documentRepository;
}
