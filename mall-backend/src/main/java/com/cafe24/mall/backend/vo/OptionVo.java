package com.cafe24.mall.backend.vo;

import java.util.ArrayList;
import java.util.List;

public class OptionVo {
    private Long optionNumber;
    private Long productNumber;
    private String optionDetail;
    private Long parentOptionNumber;

    private List<OptionVo> subOptions;

    public List<OptionVo> getSubOptions() {
        return subOptions;
    }

    public void setSubOptions(List<OptionVo> subOptions) {
        this.subOptions = subOptions;
    }

    public void addChildren(OptionVo childVo){
        if(subOptions == null)
            subOptions = new ArrayList<>();
        subOptions.add(childVo);
    }

    @Override
    public String toString() {
        return "OptionVo{" +
                "optionNumber=" + optionNumber +
                ", productNumber=" + productNumber +
                ", optionDetail='" + optionDetail + '\'' +
                ", parentOptionNumber=" + parentOptionNumber +
                ", subOptions=" + subOptions +
                '}';
    }

    public Long getOptionNumber() {
        return optionNumber;
    }

    public void setOptionNumber(Long optionNumber) {
        this.optionNumber = optionNumber;
    }

    public Long getProductNumber() {
        return productNumber;
    }

    public void setProductNumber(Long productNumber) {
        this.productNumber = productNumber;
    }

    public String getOptionDetail() {
        return optionDetail;
    }

    public void setOptionDetail(String optionDetail) {
        this.optionDetail = optionDetail;
    }

    public Long getParentOptionNumber() {
        return parentOptionNumber;
    }

    public void setParentOptionNumber(Long parentOptionNumber) {
        this.parentOptionNumber = parentOptionNumber;
    }
}
