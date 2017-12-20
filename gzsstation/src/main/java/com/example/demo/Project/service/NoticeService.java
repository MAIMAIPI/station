package com.example.demo.Project.service;

import com.example.demo.Project.repository.NoticeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NoticeService {
    @Autowired
    private NoticeRepository noticeRepository;
}
