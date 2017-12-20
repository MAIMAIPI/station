package com.example.demo.Project.controller;

import com.example.demo.Project.service.DocumentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DocumentController {
    public static final Logger logger= LoggerFactory.getLogger(DocumentController.class);
    @Autowired
    private DocumentService documentService;
    @RequestMapping("/layui")
    public String layui(){
        return "laypage";
    }
    @RequestMapping("/fileUpload")
    public String fileUpload(){
        return "fileDeal";
    }
}
