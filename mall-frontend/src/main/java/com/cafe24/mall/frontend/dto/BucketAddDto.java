package com.cafe24.mall.frontend.dto;

public class BucketAddDto {
    private Long bucketNumber;
    private Long bucKetUserNumber;
    private Long optionNumber;
    private Long bucketCount;
    private String nonMemberId;

    @Override
    public String toString() {
        return "BucketAddDto{" +
                "bucketNumber=" + bucketNumber +
                ", bucKetUserNumber=" + bucKetUserNumber +
                ", optionNumber=" + optionNumber +
                ", bucketCount=" + bucketCount +
                ", nonMemberId='" + nonMemberId + '\'' +
                '}';
    }

    public Long getBucketNumber() {
        return bucketNumber;
    }

    public void setBucketNumber(Long bucketNumber) {
        this.bucketNumber = bucketNumber;
    }

    public Long getBucKetUserNumber() {
        return bucKetUserNumber;
    }

    public void setBucKetUserNumber(Long bucKetUserNumber) {
        this.bucKetUserNumber = bucKetUserNumber;
    }

    public Long getOptionNumber() {
        return optionNumber;
    }

    public void setOptionNumber(Long optionNumber) {
        this.optionNumber = optionNumber;
    }

    public Long getBucketCount() {
        return bucketCount;
    }

    public void setBucketCount(Long bucketCount) {
        this.bucketCount = bucketCount;
    }

    public String getNonMemberId() {
        return nonMemberId;
    }

    public void setNonMemberId(String nonMemberId) {
        this.nonMemberId = nonMemberId;
    }
}
