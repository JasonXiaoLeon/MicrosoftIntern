package JDBC;

public class News {
    private int newsId;
    private String title;
    private String coverImageUrl;
    private String releaseDatetime;
    private String author;
    private String newsText;
    private int viewsCount;
    private int favoritesCount;
    private int sharesCount;
    private boolean paidPromotionFlag;

    // 构造函数、getter和setter方法

    public News(int newsId, String title, String coverImageUrl, String releaseDatetime, String author, String newsText,
                int viewsCount, int favoritesCount, int sharesCount, boolean paidPromotionFlag) {
        this.newsId = newsId;
        this.title = title;
        this.coverImageUrl = coverImageUrl;
        this.releaseDatetime = releaseDatetime;
        this.author = author;
        this.newsText = newsText;
        this.viewsCount = viewsCount;
        this.favoritesCount = favoritesCount;
        this.sharesCount = sharesCount;
        this.paidPromotionFlag = paidPromotionFlag;
    }
 // Getter 和 Setter 方法
    public int getNewsId() {
        return newsId;
    }

    public void setNewsId(int newsId) {
        this.newsId = newsId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCoverImageUrl() {
        return coverImageUrl;
    }

    public void setCoverImageUrl(String coverImageUrl) {
        this.coverImageUrl = coverImageUrl;
    }

    public String getReleaseDatetime() {
        return releaseDatetime;
    }

    public void setReleaseDatetime(String releaseDatetime) {
        this.releaseDatetime = releaseDatetime;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getNewsText() {
        return newsText;
    }

    public void setNewsText(String newsText) {
        this.newsText = newsText;
    }

    public int getViewsCount() {
        return viewsCount;
    }

    public void setViewsCount(int viewsCount) {
        this.viewsCount = viewsCount;
    }

    public int getFavoritesCount() {
        return favoritesCount;
    }

    public void setFavoritesCount(int favoritesCount) {
        this.favoritesCount = favoritesCount;
    }

    public int getSharesCount() {
        return sharesCount;
    }

    public void setSharesCount(int sharesCount) {
        this.sharesCount = sharesCount;
    }

    public boolean isPaidPromotionFlag() {
        return paidPromotionFlag;
    }

    public void setPaidPromotionFlag(boolean paidPromotionFlag) {
        this.paidPromotionFlag = paidPromotionFlag;
    }
}
