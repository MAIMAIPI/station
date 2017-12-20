package com.example.demo.Project.controller;

import com.example.demo.Project.service.ProjectLogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ProjectLogController {
    private static final Logger logger= LoggerFactory.getLogger(ProjectCheckController.class);
    @Autowired
    private ProjectLogService projectLogService;
}
