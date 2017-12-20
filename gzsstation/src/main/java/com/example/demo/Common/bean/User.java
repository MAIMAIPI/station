package com.example.demo.Common.bean;

import org.springframework.beans.factory.annotation.Value;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 用户表中尽量不用添加太多的集合，否则需要设置延迟加载，避免过多的查询导致时间的耗费
 */
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue
    private Integer uid;//主键
    private String username;//用户名
    private String password;//密码
    private String realname;//真实姓名
    private String phone;//电话
    private Integer level;//年级
    private Integer degree;//身份
    @Value("0")
    private Integer status;//状态，  是否通过认可

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getDegree() {
        return degree;
    }

    public void setDegree(Integer degree) {
        this.degree = degree;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", level=" + level +
                ", status=" + status +
                ", degree=" + degree +
                ", realname=" + realname +
                '}';
    }
}
