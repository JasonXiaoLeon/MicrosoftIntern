-- 通过邮箱创建用户 --
INSERT INTO UserInfo (uid, phone_number, avatar_url, nickname, favorite_list, news_preference, browsing_history, comment_history)
VALUES ('user@gmail.com', '', '', '', '[]', '[]', '[]', '[]');

ALTER TABLE SocialApps.UserInfo
ADD COLUMN password_hash VARCHAR(255) NOT NULL;
-- 用户编辑自己的昵称等账号信息 --
UPDATE SocialApps.UserInfo
SET password_hash='123456', nickname = 'Nickname', phone_number = '123456789', avatar_url = 'icon.jpg'
WHERE uid = 'user@gmail.com';

-- 登录 --
SELECT uid, nickname
FROM SocialApps.UserInfo
WHERE uid = 'user@gmail.com' AND password_hash = '123456';

-- 用户获取主页新闻列表 --
SELECT news_id, title, cover_image_url, release_datetime, author, views_count, favorites_count, shares_count
FROM NewsContent
ORDER BY release_datetime DESC
LIMIT 10;

-- 用户按分区浏览新闻列表 --
SELECT news_id, title, cover_image_url, release_datetime, author, views_count, favorites_count, shares_count
FROM NewsContent
WHERE category = '用户选择的分区'
ORDER BY release_datetime DESC
LIMIT 10;

-- 用户按标题和内容搜索新闻列表 --
SELECT news_id, title, cover_image_url, release_datetime, author, views_count, favorites_count, shares_count
FROM NewsContent
WHERE title LIKE '%用户输入的搜索关键词%' OR news_text LIKE '%用户输入的搜索关键词%'
ORDER BY release_datetime DESC
LIMIT 10;
-- 用户访问新闻，并且加载新闻下对应的评论 --
SELECT news_id, title, cover_image_url, release_datetime, author, news_text, views_count, favorites_count, shares_count
FROM NewsContent
WHERE news_id = '用户访问的新闻ID';
-- 收藏 --
UPDATE NewsContent
SET favorites_count = favorites_count + 1
WHERE news_id = '用户收藏的新闻ID';
-- 分享 --
UPDATE NewsContent
SET shares_count = shares_count + 1
WHERE news_id = '用户分享的新闻ID';

-- 新闻评论 --
INSERT INTO Comments (user_id, news_id, comment_text, comment_time)
VALUES ('用户ID', '新闻ID', '用户评论的内容', CURRENT_TIMESTAMP);

-- 点赞 --
UPDATE Comments
SET likes_count = likes_count + 1
WHERE comment_id = '用户点赞的评论ID';
-- 点踩 --
UPDATE Comments
SET dislikes_count = dislikes_count + 1
WHERE comment_id = '用户点踩的评论ID';

-- 删除自己的评论 --
DELETE FROM Comments
WHERE comment_id = '用户要删除的评论ID' AND user_id = '用户ID';

-- 用户在个人页中观看自己的评论历史 --
SELECT comment_id, news_id, comment_text, comment_time, likes_count, dislikes_count
FROM Comments
WHERE user_id = '用户ID'
ORDER BY comment_time DESC;
-- 用户在个人页中观看自己的浏览历史 --
SELECT nc.news_id, nc.title, nc.cover_image_url, nc.release_datetime, nc.author, nc.news_text, nc.views_count, nc.favorites_count, nc.shares_count
FROM NewsContent nc
JOIN BrowsingHistory bh ON nc.news_id = bh.news_id
WHERE bh.user_id = '用户ID'
ORDER BY bh.view_time DESC;

-- 投放新闻 --
INSERT INTO NewsContent (title, cover_image_url, release_datetime, author, news_text)
VALUES ('新闻标题', '封面图片链接', '发布日期时间', '作者', '新闻正文内容');

-- 安装内容类型获取广告 --
SELECT ad_id, title, content, image_url, placement, advertiser_identifier, start_date, end_date
FROM Advertisements
WHERE placement = '指定的内容类型'
ORDER BY delivery_weight DESC;

-- 投放广告 --
INSERT INTO Advertisements (title, content, image_url, placement, advertiser_identifier, start_date, end_date, region_restrictions, device_restrictions, delivery_weight)
VALUES ('广告标题', '广告内容', '广告图片链接', '投放位置', '广告主标识符', '开始日期', '结束日期', '地区限制', '设备限制', 1);


