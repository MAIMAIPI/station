package com.example.demo.Project.bean;

import org.python.jline.internal.TestAccessible;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "batch")
public class Batch {
    @Id
    @GeneratedValue
    private Integer bid;//自身逐渐
    private Integer year;//年份
    private Integer level;//年级
    private String name;//批次名字


    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Batch{" +
                "bid=" + bid +
                ", year=" + year +
                ", level=" + level +
                ", name='" + name + '\'' +
                '}';
    }
}
