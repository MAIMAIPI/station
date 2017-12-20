package com.example.demo.Project.bean;
import javax.persistence.*;

/**
 *
 */
@Entity
@Table(name = "document")
public class Document {
    @Id
    @GeneratedValue
    private Integer did;
    private Integer type;
    @Column(length = 2550)
    private String content;
    private String link;
   /* @ManyToOne
    private ProjectItem projectItem;*/
    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    /*public ProjectItem getProjectItem() {
        return projectItem;
    }

    public void setProjectItem(ProjectItem projectItem) {
        this.projectItem = projectItem;
    }
*/
    @Override
    public String toString() {
        return "Document{" +
                "did=" + did +
                ", type=" + type +
                ", content='" + content + '\'' +
                ", link='" + link + '\'' +
               // ", projectItem=" + projectItem +
                '}';
    }
}
