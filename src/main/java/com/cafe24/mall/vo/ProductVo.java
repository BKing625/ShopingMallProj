package com.cafe24.mall.vo;


import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ProductVo {
    public enum StockType {
        LIMIT,UNLIMIT
    }


    public List<OptionVo> getOptions() {
        return options;
    }

    public void setOptions(List<OptionVo> options) {
        this.options = options;
    }

    private List<OptionVo> options;
    private Long productNumber;
    @NotEmpty
    private String productName;
    private String productTitle;

    // TODO: 2019-07-27 add validator 
    private StockType productStockType;

    public Long getProductNumber() {
        return productNumber;
    }

    public void setProductNumber(Long productNumber) {
        this.productNumber = productNumber;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductTitle() {
        return productTitle;
    }

    public void setProductTitle(String productTitle) {
        this.productTitle = productTitle;
    }

    public StockType getProductStockType() {
        return productStockType;
    }

    public void setProductStockType(StockType productStockType) {
        this.productStockType = productStockType;
    }

    @Override
    public String toString() {
        return "ProductVo{" +
                "productNumber=" + productNumber +
                ", productName='" + productName + '\'' +
                ", productTitle='" + productTitle + '\'' +
                ", productStockType=" + productStockType +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductVo productVo = (ProductVo) o;
        return Objects.equals(productNumber, productVo.productNumber) &&
                Objects.equals(productName, productVo.productName) &&
                Objects.equals(productTitle, productVo.productTitle) &&
                productStockType == productVo.productStockType;
    }
    public void addOption(OptionVo addOption){
        if(options == null)
            options = new ArrayList<>();
        options.add(addOption);
    }
    @Override
    public int hashCode() {
        return Objects.hash(productNumber, productName, productTitle, productStockType);
    }

}
