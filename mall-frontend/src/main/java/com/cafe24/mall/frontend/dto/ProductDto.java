package com.cafe24.mall.frontend.dto;

import java.util.List;

public class ProductDto {

    private String name;
    private String detail;
    private Integer price;
    private Integer option_cnt;
    private List<String> optionDetail_0;
    private List<String>  optionDetail_1;
    private List<String>  optionDetail_2;
    private List<String>  optionDetail_3;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getOption_cnt() {
        return option_cnt;
    }

    public void setOption_cnt(Integer option_cnt) {
        this.option_cnt = option_cnt;
    }

    public List<String> getOptionDetail_0() {
        return optionDetail_0;
    }

    public void setOptionDetail_0(List<String> optionDetail_0) {
        this.optionDetail_0 = optionDetail_0;
    }

    public List<String> getOptionDetail_1() {
        return optionDetail_1;
    }

    public void setOptionDetail_1(List<String> optionDetail_1) {
        this.optionDetail_1 = optionDetail_1;
    }

    public List<String> getOptionDetail_2() {
        return optionDetail_2;
    }

    public void setOptionDetail_2(List<String> optionDetail_2) {
        this.optionDetail_2 = optionDetail_2;
    }

    public List<String> getOptionDetail_3() {
        return optionDetail_3;
    }

    public void setOptionDetail_3(List<String> optionDetail_3) {
        this.optionDetail_3 = optionDetail_3;
    }

    @Override
    public String toString() {
        return "ProductDto{" +
                "name='" + name + '\'' +
                ", detail='" + detail + '\'' +
                ", price=" + price +
                ", option_cnt=" + option_cnt +
                ", optionDetail_0='" + optionDetail_0 + '\'' +
                ", optionDetail_1='" + optionDetail_1 + '\'' +
                ", optionDetail_2='" + optionDetail_2 + '\'' +
                ", optionDetail_3='" + optionDetail_3 + '\'' +
                '}';
    }
}
