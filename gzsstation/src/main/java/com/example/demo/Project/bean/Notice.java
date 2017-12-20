package com.example.demo.Project.bean;

import com.example.demo.Common.bean.User;

import javax.persistence.*;

@Entity
@Table(name = "notice")
public class Notice {
    @Id
    @GeneratedValue
    private Integer nid;
    private String title;
    @Column(length = 2550)
    private String content;
    private String time;
    @OneToOne
    private User user;
    private Integer type;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getNid() {
        return nid;
    }

    public void setNid(Integer nid) {
        this.nid = nid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Notice{" +
                "nid=" + nid +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", time='" + time + '\'' +
                ", user=" + user +
                ", type=" + type +
                '}';
    }
}
