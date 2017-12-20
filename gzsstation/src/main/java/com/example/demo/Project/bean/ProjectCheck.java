package com.example.demo.Project.bean;

import com.example.demo.Common.bean.User;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;

@Entity
@Table(name = "projectcheck")
public class ProjectCheck {//检查类
    @Id
    @GeneratedValue
    private Integer pcid;//主键
    @OneToOne
    private User user;//检查人
    @ManyToOne
    private Project project;//所检查的项目
    private String time;//检查日期
    @Column(length = 2550)
    private String content;//内容填写
    private String suggest;//建议
    @Value("0")
    private Integer num;//检查讨论数目
    private Double grade;//打分

    public Integer getPcid() {
        return pcid;
    }

    public Integer getNum() {
        return num;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public void setPcid(Integer pcid) {
        this.pcid = pcid;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSuggest() {
        return suggest;
    }

    public void setSuggest(String suggest) {
        this.suggest = suggest;
    }

    public Double getGrade() {
        return grade;
    }

    public void setGrade(Double grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "ProjectCheck{" +
                "pcid=" + pcid +
                ", user=" + user +
                ", time='" + time + '\'' +
                ", content='" + content + '\'' +
                ", suggest='" + suggest + '\'' +
                ", grade=" + grade +
                ", num=" + num +
                ", project=" +project +
                '}';
    }
}
