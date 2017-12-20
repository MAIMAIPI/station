package com.example.demo.Project.service;

import com.example.demo.Project.repository.ProjectLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectLogService {
    @Autowired
    private ProjectLogRepository projectLogRepository;
}
