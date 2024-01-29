package com.microsoft.week4.demoProj.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import java.util.Date;

@Data
@Entity
@Table(name = "UserInfo")
public class User {

    @Id
    @Column(name = "uid")
    private String uid;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "avatar_url")
    private String avatarUrl;

    @Column(name = "nickname")
    private String nickname;

    @Column(name = "favorite_list", columnDefinition = "TEXT")
    private String favoriteList;

    @Column(name = "news_preference", columnDefinition = "TEXT")
    private String newsPreference;

    @Column(name = "browsing_history", columnDefinition = "TEXT")
    private String browsingHistory;

    @Column(name = "comment_history", columnDefinition = "TEXT")
    private String commentHistory;

    @Column(name = "last_login_time", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date lastLoginTime;

    @Column(name = "password_hash", nullable = false)
    private String passwordHash;

    // 省略构造函数和其他方法
}
