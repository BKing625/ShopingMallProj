package com.cafe24.mall.frontend.vo;

import java.util.List;
import java.util.Objects;

public class OrderDetailsVo {
    private Long orderDetailsNumber;
    private Long orderNumber;
    private Long optionNumber;
    private Long orderDetailsCount;

    private List<OrderDetailsVo> orderDetailsVoList;

    public List<OrderDetailsVo> getOrderDetailsVoList() {
        return orderDetailsVoList;
    }

    public void setOrderDetailsVoList(List<OrderDetailsVo> orderDetailsVoList) {
        this.orderDetailsVoList = orderDetailsVoList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderDetailsVo that = (OrderDetailsVo) o;
        return Objects.equals(orderDetailsNumber, that.orderDetailsNumber) &&
                Objects.equals(orderNumber, that.orderNumber) &&
                Objects.equals(optionNumber, that.optionNumber) &&
                Objects.equals(orderDetailsCount, that.orderDetailsCount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderDetailsNumber, orderNumber, optionNumber, orderDetailsCount);
    }

    @Override
    public String toString() {
        return "OrderDetailsVo{" +
                "orderDetailsNumber=" + orderDetailsNumber +
                ", orderNumber=" + orderNumber +
                ", optionNumber=" + optionNumber +
                ", orderDetailsCount=" + orderDetailsCount +
                '}';
    }

    public Long getOrderDetailsNumber() {
        return orderDetailsNumber;
    }

    public void setOrderDetailsNumber(Long orderDetailsNumber) {
        this.orderDetailsNumber = orderDetailsNumber;
    }

    public Long getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Long orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Long getOptionNumber() {
        return optionNumber;
    }

    public void setOptionNumber(Long optionNumber) {
        this.optionNumber = optionNumber;
    }

    public Long getOrderDetailsCount() {
        return orderDetailsCount;
    }

    public void setOrderDetailsCount(Long orderDetailsCount) {
        this.orderDetailsCount = orderDetailsCount;
    }
}
