package com.cafe24.mall.vo;

import java.util.Objects;

public class BucketVo {
    private Long bucketNumber;
    private Long userNumber;
    private Long optionNumber;
    private Long bucketCount;
    private String nonMemberId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BucketVo bucketVo = (BucketVo) o;
        return Objects.equals(bucketNumber, bucketVo.bucketNumber) &&
                Objects.equals(userNumber, bucketVo.userNumber) &&
                Objects.equals(optionNumber, bucketVo.optionNumber) &&
                Objects.equals(bucketCount, bucketVo.bucketCount) &&
                Objects.equals(nonMemberId, bucketVo.nonMemberId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bucketNumber, userNumber, optionNumber, bucketCount, nonMemberId);
    }

    @Override
    public String toString() {
        return "BucketVo{" +
                "bucketNumber=" + bucketNumber +
                ", userNumber=" + userNumber +
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

    public Long getUserNumber() {
        return userNumber;
    }

    public void setUserNumber(Long userNumber) {
        this.userNumber = userNumber;
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