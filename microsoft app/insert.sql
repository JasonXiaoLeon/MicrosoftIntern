use SocialApps;
-- 插入第一条新闻
INSERT INTO NewsContent (title, cover_image_url, release_datetime, author, news_text, views_count, favorites_count, shares_count, paid_promotion_flag)
VALUES ('AU News 1', 'sample_image_url_1', '2024-01-06 12:00:00', 'Author 1', 'This is a sample news text for News 1.', 100, 50, 20, false);

-- 插入第二条新闻
INSERT INTO NewsContent (title, cover_image_url, release_datetime, author, news_text, views_count, favorites_count, shares_count, paid_promotion_flag)
VALUES ('CN News 1', 'sample_image_url_2', '2024-01-06 12:30:00', 'Author 2', 'This is a sample news text for News 2.', 120, 60, 25, true);

-- 插入第三条新闻，以此类推...
INSERT INTO NewsContent (title, cover_image_url, release_datetime, author, news_text, views_count, favorites_count, shares_count, paid_promotion_flag)
VALUES ('AU News 2', 'sample_image_url_3', '2024-01-06 13:00:00', 'Author 3', 'This is a sample news text for News 3.', 80, 40, 15, false);

INSERT INTO NewsContent (title, cover_image_url, release_datetime, author, news_text, views_count, favorites_count, shares_count, paid_promotion_flag)
VALUES ('UK News 1', 'sample_image_url_4', '2024-01-06 13:30:00', 'Author 4', 'This is a sample news text for News 4.', 150, 70, 30, true);

INSERT INTO NewsContent (title, cover_image_url, release_datetime, author, news_text, views_count, favorites_count, shares_count, paid_promotion_flag)
VALUES ('USA News 1', 'sample_image_url_5', '2024-01-06 14:00:00', 'Author 5', 'This is a sample news text for News 5.', 90, 45, 18, false);

-- 插入第一条评论
INSERT INTO Comments (user_id, news_id, comment_text, comment_time, referenced_comment_id, likes_count, dislikes_count)
VALUES ('user@gmail.com', 1, 'This is the first comment for newsId=1.', '2024-01-06 12:00:00', NULL, 10, 2);

-- 插入第二条评论
INSERT INTO Comments (user_id, news_id, comment_text, comment_time, referenced_comment_id, likes_count, dislikes_count)
VALUES ('newuser@gmail.com', 1, 'Another comment for newsId=1.', '2024-01-06 12:30:00', NULL, 8, 1);
