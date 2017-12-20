package com.example.demo.Project.bean;

import javax.persistence.*;
import java.util.List;

/**
 * Document
 * ProjectLog
 * ProjectCheck
 * 查看项目的时候需要去查询这些内容,在持久化关联的时候可以自动加载,
 * 但是内容增加的时候，多级关联会影响效率，自己手动查询加载数据，
 * 同时在转化为json数据的时候不需要过滤
 *
 * 异步上传文件和图片
 */
@Entity
@Table(name = "projectitem")
public class ProjectItem {
    @Id
    @GeneratedValue
    private Integer piid;//主键
    @OneToOne
    private Project project;//所属项目
    private String picture;//存放图片路径
    private String  link;//git链接
    private String funPath;//存放功能点文件路径
    private String needPath;//存放需求文件路径

    private String time;//更新时间
    private String submitPerson;//提交人


    public String getSubmitPerson() {
        return submitPerson;
    }

    public void setSubmitPerson(String submitPerson) {
        this.submitPerson = submitPerson;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getFunPath() {
        return funPath;
    }

    public void setFunPath(String funPath) {
        this.funPath = funPath;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getNeedPath() {
        return needPath;
    }

    public void setNeedPath(String needPath) {
        this.needPath = needPath;
    }

    public Integer getPiid() {
        return piid;
    }

    public void setPiid(Integer piid) {
        this.piid = piid;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }


    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }


    @Override
    public String toString() {
        return "ProjectItem{" +
                "piid=" + piid +
                ", project=" + project +
                ", link='" + link + '\'' +
                ", needPath='" + needPath + '\'' +
                ", funPath='" + funPath + '\'' +
                ", picture='" + picture + '\'' +
                ", time='" + time + '\'' +
                ", submitPerson='" + submitPerson + '\'' +
                '}';
    }
}
