package com.neon.demo_big_event.entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "category_name", length = 32)
    private String categoryName;

    @Column(name = "category_alias", length = 32)
    private String categoryAlias;

    @Column(name = "create_user")
    private Integer createUser;

    @Column(name = "create_time")
    private LocalDateTime createTime;

    @Column(name = "update_time")
    private LocalDateTime updateTime;

    public Category() {}
    public Category(String categoryName, String categoryAlias, Integer createUser) {
        this.categoryName = categoryName;
        this.categoryAlias = categoryAlias;
        this.createUser = createUser;
    }

    // Getters and Setters
    public Long getId() { return this.id; }
    public void setId(Long id) { this.id = id; }
    public String getCategoryName() { return this.categoryName; }
    public void setCategoryName(String categoryName) { this.categoryName = categoryName; }
    public String getCategoryAlias() { return this.categoryAlias; }
    public void setCategoryAlias(String categoryAlias) { this.categoryAlias = categoryAlias; }
    public Integer getCreateUser() { return this.createUser; }
    public void setCreateUser(Integer createUser) { this.createUser = createUser; }
    public LocalDateTime getCreateTime() { return this.createTime; }
    public void setCreateTime(LocalDateTime createTime) { this.createTime = createTime; }
    public LocalDateTime getUpdateTime() { return this.updateTime; }
    public void setUpdateTime(LocalDateTime updateTime) { this.updateTime = updateTime; }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", categoryName='" + categoryName + '\'' +
                ", categoryAlias='" + categoryAlias + '\'' +
                ", createUser=" + createUser +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
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
