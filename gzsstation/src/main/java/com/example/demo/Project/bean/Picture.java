package com.example.demo.Project.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "picture")
public class Picture {
    @Id
    @GeneratedValue
    private Integer pid;
    private String path;
    private String name;

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Picture{" +
                "pid=" + pid +
                ", path='" + path + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
