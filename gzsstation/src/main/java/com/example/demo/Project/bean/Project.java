package com.example.demo.Project.bean;

import javax.persistence.*;

/**
 * ProjectItem 后期扩展的时候可能会对应多个子过程
 *member后期需要替换称user通过group进行关联,
 * 根据gruop判断是否是组内成员只有组内成员才能去提交资料
 */
@Entity
@Table(name = "project")
public class Project {
    @Id
    @GeneratedValue
    private Integer pid;//项目主键
    private String name;//项目名称
   /*@OneToMany
    private List<Group> groups;*/
    private String summary;//项目描序
    private String link;//git链接
    private String startTime;//创建时间
    private String endTime;//截至时间
    private String member;//项目创建人
    @ManyToOne
    private Batch batch;//所属批次


    public Batch getBatch() {
        return batch;
    }

    public void setBatch(Batch batch) {
        this.batch = batch;
    }

    public String getMember() {
        return member;
    }

    public void setMember(String member) {
        this.member = member;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public String getSummary() {
        return summary;
    }

    /*public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }
*/
    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }


    @Override
    public String toString() {
        return "Project{" +
                "pid=" + pid +
                ", name='" + name + '\'' +
                //", groups=" + groups +
                ", summary='" + summary + '\'' +
                ", link='" + link + '\'' +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", member='" + member + '\'' +
                 ", batch='" + batch + '\'' +
                '}';
    }
}
