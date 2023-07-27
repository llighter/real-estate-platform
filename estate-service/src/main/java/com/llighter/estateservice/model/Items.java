package com.llighter.estateservice.model;

import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

public class Items {

    @Id
    private Integer id;
    private String itemName;
    // 가격
    private Integer price;
    // 거래유형(매매:001, 전세:002, 월세:003)
    private String tradeType;
    // 거래상태(거래중:001, 거래완료:002, 거래취소:003)
    private String tradeStatus;
    // 주거형태(아파트:001, 빌라:002, 단독주택:003)
    private String houseType;
    // 거주기간(1년미만:001, 1년이상:002)
    private String residencePeriod;
    // 옵션(없음:001, 풀옵션:002)
    private String option;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;

    public Items(String itemName, Integer price, String tradeType, String tradeStatus, String houseType, String residencePeriod, String option) {
        this.itemName = itemName;
        this.price = price;
        this.tradeType = tradeType;
        this.tradeStatus = tradeStatus;
        this.houseType = houseType;
        this.residencePeriod = residencePeriod;
        this.option = option;
        this.createdDate = LocalDateTime.now();
        this.updatedDate = LocalDateTime.now();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getTradeType() {
        return tradeType;
    }

    public void setTradeType(String tradeType) {
        this.tradeType = tradeType;
    }

    public String getTradeStatus() {
        return tradeStatus;
    }

    public void setTradeStatus(String tradeStatus) {
        this.tradeStatus = tradeStatus;
    }

    public String getHouseType() {
        return houseType;
    }

    public void setHouseType(String houseType) {
        this.houseType = houseType;
    }

    public String getResidencePeriod() {
        return residencePeriod;
    }

    public void setResidencePeriod(String residencePeriod) {
        this.residencePeriod = residencePeriod;
    }

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDateTime getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(LocalDateTime updatedDate) {
        this.updatedDate = updatedDate;
    }

    @Override
    public String toString() {
        return "Items{" +
                "id=" + id +
                ", itemName='" + itemName + '\'' +
                ", price=" + price +
                ", tradeType='" + tradeType + '\'' +
                ", tradeStatus='" + tradeStatus + '\'' +
                ", houseType='" + houseType + '\'' +
                ", residencePeriod='" + residencePeriod + '\'' +
                ", option='" + option + '\'' +
                ", createdDate=" + createdDate +
                ", updatedDate=" + updatedDate +
                '}';
    }
}
