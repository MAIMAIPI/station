package com.example.demo.Project.bean;

import javax.persistence.*;

@Entity
@Table(name = "projectlog")
public class ProjectLog {
    @Id
    @GeneratedValue
    private Integer plid;
    @Column(length = 2550)
    private String content;
    private String time;
    private String title;
    @ManyToOne
    private ProjectItem projectItem;

    public Integer getPlid() {
        return plid;
    }

    public void setPlid(Integer plid) {
        this.plid = plid;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ProjectItem getProjectItem() {
        return projectItem;
    }

    public void setProjectItem(ProjectItem projectItem) {
        this.projectItem = projectItem;
    }

    @Override
    public String toString() {
        return "ProjectLog{" +
                "plid=" + plid +
                ", content='" + content + '\'' +
                ", time='" + time + '\'' +
                ", title='" + title + '\'' +
                ", projectItem=" + projectItem +
                '}';
    }
}
