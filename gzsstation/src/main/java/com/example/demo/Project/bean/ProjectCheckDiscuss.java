package com.example.demo.Project.bean;

import com.example.demo.Common.bean.User;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;

@Entity
@Table(name = "projectcheckdiscuss")
public class ProjectCheckDiscuss {//检查下的评论
    @Id
    @GeneratedValue
    private Integer pcdid;//主键
    @ManyToOne
    private ProjectCheck projectCheck;//所属的项目检查
    @Column(length = 2550)
    private String Content;//内容
    @OneToOne
    private User send;//发送人
    @OneToOne
    private User accept;//接收人
    private String time;//时间


    public Integer getPcdid() {
        return pcdid;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public ProjectCheck getProjectCheck() {
        return projectCheck;
    }

    public void setProjectCheck(ProjectCheck projectCheck) {
        this.projectCheck = projectCheck;
    }

    public void setPcdid(Integer pcdid) {
        this.pcdid = pcdid;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public User getSend() {
        return send;
    }

    public void setSend(User send) {
        this.send = send;
    }

    public User getAccept() {
        return accept;
    }

    public void setAccept(User accept) {
        this.accept = accept;
    }

    @Override
    public String toString() {
        return "ProjectCheckDiscuss{" +
                "pcdid=" + pcdid +
                ", Content='" + Content + '\'' +
                ", send=" + send +
                ", accept=" + accept +
                ", projectCheck=" + projectCheck+
                ", time=" +time+
                '}';
    }
}

