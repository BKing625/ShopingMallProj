package com.cafe24.mall.frontend.dto;

import java.util.List;

public class ProductSimpleViewDto {
    private Long bucketNumber;
    private String productName;
    private Long count;
    private Long optionNumber;
    private Integer productPrice;
    private String optionStr;
    private Long productNumber;

    private List<ProductSimpleViewDto> productSimpleViewDtoList;

    public List<ProductSimpleViewDto> getProductSimpleViewDtoList() {
        return productSimpleViewDtoList;
    }

    public void setProductSimpleViewDtoList(List<ProductSimpleViewDto> productSimpleViewDtoList) {
        this.productSimpleViewDtoList = productSimpleViewDtoList;
    }

    public Long getProductNumber() {
        return productNumber;
    }

    public void setProductNumber(Long productNumber) {
        this.productNumber = productNumber;
    }



    public Long getBucketNumber() {
        return bucketNumber;
    }

    public void setBucketNumber(Long bucketNumber) {
        this.bucketNumber = bucketNumber;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public Long getOptionNumber() {
        return optionNumber;
    }

    public void setOptionNumber(Long optionNumber) {
        this.optionNumber = optionNumber;
    }

    public Integer getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Integer productPrice) {
        this.productPrice = productPrice;
    }

    public String getOptionStr() {
        return optionStr;
    }

    public void setOptionStr(String optionStr) {
        this.optionStr = optionStr;
    }
}
