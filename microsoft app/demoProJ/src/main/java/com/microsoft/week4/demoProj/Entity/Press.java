package com.microsoft.week4.demoProj.Entity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "NewsContent")
public class Press {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "news_id")
    private int newsId;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "cover_image_url")
    private String coverImageUrl;

    @Column(name = "release_datetime")
    private Date releaseDatetime;

    @Column(name = "author")
    private String author;

    @Column(name = "news_text")
    private String newsText;

    @Column(name = "views_count")
    private int viewsCount;

    @Column(name = "favorites_count")
    private int favoritesCount;

    @Column(name = "shares_count")
    private int sharesCount;

    @Column(name = "paid_promotion_flag")
    private boolean paidPromotionFlag;

    // 省略构造函数和其他方法
}
