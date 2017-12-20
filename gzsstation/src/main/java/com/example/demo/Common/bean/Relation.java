package com.example.demo.Common.bean;

import javax.persistence.*;

@Entity
@Table(name = "relation")
public class Relation {//师徒关系类
    @Id
    @GeneratedValue
    private Integer rid;//主键
    @OneToOne
    private User master;//师傅
    @ManyToOne
    private User apprentice;//徒弟
    @Override
    public String toString() {
        return "Relation{" +
                "rid=" + rid +
                ", master=" + master +
                ", apprentice=" + apprentice +
                '}';
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public User getMaster() {
        return master;
    }

    public void setMaster(User master) {
        this.master = master;
    }

    public User getApprentice() {
        return apprentice;
    }

    public void setApprentice(User apprentice) {
        this.apprentice = apprentice;
    }
}
