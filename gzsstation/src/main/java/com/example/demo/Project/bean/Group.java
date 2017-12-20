package com.example.demo.Project.bean;

import com.example.demo.Common.bean.User;

import javax.persistence.*;
@Entity
@Table(name = "thegroup")
public class Group {
    @Id
    @GeneratedValue
    private Integer gid;//主键
    @ManyToOne
    private User user;//用户
    @ManyToOne
    private Project project;//项目
    private Integer degree;//身份

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Integer getDegree() {
        return degree;
    }

    public void setDegree(Integer degree) {
        this.degree = degree;
    }

    @Override
    public String toString() {
        return "Group{" +
                "gid=" + gid +
                ", user=" + user +
                ", project=" + project +
                ", degree=" + degree +
                '}';
    }
}
