package com.example.demo.week2;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
public class Ad {
    private int adId;
    private String adIdentifier;
    private String title;
    private String content;
    private String imageUrl;
    private AdPlacement placement;
    private String advertiserIdentifier;
    private String startDate;
    private String endDate;
    private String regionRestrictions;
    private String deviceRestrictions;
    private int clicksCount;
    private int impressionsCount;
    private int deliveryWeight;

    public Ad() {
        super();
    }

    public Ad(int adId, String adIdentifier, String title, String content, String imageUrl, AdPlacement placement,
              String advertiserIdentifier, String startDate, String endDate, String regionRestrictions,
              String deviceRestrictions, int clicksCount, int impressionsCount, int deliveryWeight) {
        super();
        this.adId = adId;
        this.adIdentifier = adIdentifier;
        this.title = title;
        this.content = content;
        this.imageUrl = imageUrl;
        this.placement = placement;
        this.advertiserIdentifier = advertiserIdentifier;
        this.startDate = startDate;
        this.endDate = endDate;
        this.regionRestrictions = regionRestrictions;
        this.deviceRestrictions = deviceRestrictions;
        this.clicksCount = clicksCount;
        this.impressionsCount = impressionsCount;
        this.deliveryWeight = deliveryWeight;
    }

    // Getters and setters
    public int getAdId() {
        return adId;
    }

    public void setAdId(int adId) {
        this.adId = adId;
    }

    public String getAdIdentifier() {
        return adIdentifier;
    }

    public void setAdIdentifier(String adIdentifier) {
        this.adIdentifier = adIdentifier;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public AdPlacement getPlacement() {
        return placement;
    }

    public void setPlacement(AdPlacement placement) {
        this.placement = placement;
    }

    public String getAdvertiserIdentifier() {
        return advertiserIdentifier;
    }

    public void setAdvertiserIdentifier(String advertiserIdentifier) {
        this.advertiserIdentifier = advertiserIdentifier;
    }

    public LocalDate getStartDate() {
        return LocalDate.parse(startDate, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    public LocalDate getEndDate() {
        return LocalDate.parse(endDate, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    public String getRegionRestrictions() {
        return regionRestrictions;
    }

    public void setRegionRestrictions(String regionRestrictions) {
        this.regionRestrictions = regionRestrictions;
    }

    public String getDeviceRestrictions() {
        return deviceRestrictions;
    }

    public void setDeviceRestrictions(String deviceRestrictions) {
        this.deviceRestrictions = deviceRestrictions;
    }

    public int getClicksCount() {
        return clicksCount;
    }

    public void setClicksCount(int clicksCount) {
        this.clicksCount = clicksCount;
    }

    public int getImpressionsCount() {
        return impressionsCount;
    }

    public void setImpressionsCount(int impressionsCount) {
        this.impressionsCount = impressionsCount;
    }

    public int getDeliveryWeight() {
        return deliveryWeight;
    }

    public void setDeliveryWeight(int deliveryWeight) {
        this.deliveryWeight = deliveryWeight;
    }
    public enum AdPlacement {
        SPLASH, POPUP, HOME_LIST, COMMENT_EMBEDDED, ARTICLE_EMBEDDED, ARTICLE_END, RELATED_NEWS_EMBEDDED
    }

    @Override
    public String toString() {
        return "Ad{" +
                "adId=" + adId +
                ", adIdentifier='" + adIdentifier + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", placement=" + placement +
                ", advertiserIdentifier='" + advertiserIdentifier + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", regionRestrictions='" + regionRestrictions + '\'' +
                ", deviceRestrictions='" + deviceRestrictions + '\'' +
                ", clicksCount=" + clicksCount +
                ", impressionsCount=" + impressionsCount +
                ", deliveryWeight=" + deliveryWeight +
                '}';
    }
}
