CREATE DATABASE SocialApps;
USE SocialApps;
Drop table UserInfo;
CREATE TABLE UserInfo (
    uid VARCHAR(255) PRIMARY KEY,
    phone_number VARCHAR(20),
    avatar_url VARCHAR(255),
    nickname VARCHAR(50),
    favorite_list TEXT,
    news_preference TEXT,
    browsing_history TEXT,
    comment_history TEXT,
    last_login_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE NewsContent (
    news_id INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(255) NOT NULL,
    cover_image_url VARCHAR(255),
    release_datetime DATETIME,
    author VARCHAR(50),
    news_text TEXT,
    views_count INT DEFAULT 0,
    favorites_count INT DEFAULT 0,
    shares_count INT DEFAULT 0,
    paid_promotion_flag BOOLEAN DEFAULT false
);
CREATE TABLE Comments (
    user_id VARCHAR(255),
    comment_id INT PRIMARY KEY AUTO_INCREMENT,
    news_id INT,
    comment_text TEXT,
    comment_time DATETIME,
    referenced_comment_id INT,
    likes_count INT DEFAULT 0,
    dislikes_count INT DEFAULT 0,
    FOREIGN KEY (user_id) REFERENCES UserInfo(uid),
    FOREIGN KEY (news_id) REFERENCES NewsContent(news_id),
    FOREIGN KEY (referenced_comment_id) REFERENCES Comments(comment_id)
);
CREATE TABLE Advertisements (
    ad_id INT PRIMARY KEY AUTO_INCREMENT,
    ad_identifier VARCHAR(255) UNIQUE,
    title VARCHAR(255) NOT NULL,
    content TEXT,
    image_url VARCHAR(255),
    placement ENUM('splash', 'popup', 'home_list', 'comment_embedded', 'article_embedded', 'article_end', 'related_news_embedded') NOT NULL,
    advertiser_identifier VARCHAR(50),
    start_date DATE,
    end_date DATE,
    region_restrictions VARCHAR(255),
    device_restrictions VARCHAR(255),
    clicks_count INT DEFAULT 0,
    impressions_count INT DEFAULT 0,
    delivery_weight INT DEFAULT 1
);

Drop TABLE Comments;
Drop TABLE NewsContent;
Drop TABLE Advertisements;
Drop Table UserInfo;

