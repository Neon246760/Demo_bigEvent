package com.neon.demo_big_event.entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
@Table(name = "article")
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 30)
    private String title;

    @Column(length = 10000)
    private String content;

    @Column(name = "cover_img", length = 128)
    private String coverImg;

    @Column(length = 3)
    private String state;

    @Column(name = "category_id")
    private Integer categoryId;

    @Column(name = "create_user")
    private Integer createUser;

    @Column(name = "create_time")
    private LocalDateTime createTime;

    @Column(name = "update_time")
    private LocalDateTime updateTime;

    public Article() {}
    public Article(String title, String content, String coverImg, String state, Integer categoryId, Integer createUser) {
        this.title = title;
        this.content = content;
        this.coverImg = coverImg;
        this.state = state;
        this.categoryId = categoryId;
        this.createUser = createUser;
    }

    // Getter与Setter方法
    public Long getId() { return this.id; }
    public void setId(Long id) { this.id = id; }
    public String getTitle() { return this.title; }
    public void setTitle(String title) { this.title = title; }
    public String getContent() { return this.content; }
    public void setContent(String content) { this.content = content; }
    public String getCoverImg() { return this.coverImg; }
    public void setCoverImg(String coverImg) { this.coverImg = coverImg; }
    public String getState() { return this.state; }
    public void setState(String state) { this.state = state; }
    public Integer getCategoryId() { return this.categoryId; }
    public void setCategoryId(Integer categoryId) { this.categoryId = categoryId; }
    public Integer getCreateUser() { return this.createUser; }
    public void setCreateUser(Integer createUser) { this.createUser = createUser; }
    public LocalDateTime getCreateTime() { return this.createTime; }
    public void setCreateTime(LocalDateTime createTime) { this.createTime = createTime; }
    public LocalDateTime getUpdateTime() { return this.updateTime; }
    public void setUpdateTime(LocalDateTime updateTime) { this.updateTime = updateTime; }

    @Override
    public String toString() {
        return "Article [id=" + id + ", title=" + title + ", content=" + content + ", coverImg=" + coverImg
                + ", state=" + state + ", categoryId=" + categoryId + ", createUser=" + createUser + ", createTime="
                + createTime + ", updateTime=" + updateTime + "]";
    }

    @PrePersist
    protected void onCreate() {
        if (createTime == null) {
            createTime = LocalDateTime.now();
        }
        updateTime = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updateTime = LocalDateTime.now();
    }
}
