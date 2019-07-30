package com.cafe24.mall.vo;

import java.util.Objects;

public class OrderVo {
    private Long orderNumber;
    private Long userNumber;
    private String orderState;
    private String orderPostNumber;

    private String orderAddr;
    private String ordererName;
    private String ordererPhone;
    private String orderMessage;
    private String orderDate;

    public Long getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Long orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Long getUserNumber() {
        return userNumber;
    }

    public void setUserNumber(Long userNumber) {
        this.userNumber = userNumber;
    }

    public String getOrderState() {
        return orderState;
    }

    public void setOrderState(String orderState) {
        this.orderState = orderState;
    }

    public String getOrderPostNumber() {
        return orderPostNumber;
    }

    public void setOrderPostNumber(String orderPostNumber) {
        this.orderPostNumber = orderPostNumber;
    }

    public String getOrderAddr() {
        return orderAddr;
    }

    public void setOrderAddr(String orderAddr) {
        this.orderAddr = orderAddr;
    }

    public String getOrdererName() {
        return ordererName;
    }

    public void setOrdererName(String ordererName) {
        this.ordererName = ordererName;
    }

    public String getOrdererPhone() {
        return ordererPhone;
    }

    public void setOrdererPhone(String ordererPhone) {
        this.ordererPhone = ordererPhone;
    }

    public String getOrderMessage() {
        return orderMessage;
    }

    public void setOrderMessage(String orderMessage) {
        this.orderMessage = orderMessage;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    @Override
    public String toString() {
        return "OrderVo{" +
                "orderNumber=" + orderNumber +
                ", userNumber=" + userNumber +
                ", orderState='" + orderState + '\'' +
                ", orderPostNumber='" + orderPostNumber + '\'' +
                ", orderAddr='" + orderAddr + '\'' +
                ", ordererName='" + ordererName + '\'' +
                ", ordererPhone='" + ordererPhone + '\'' +
                ", orderMessage='" + orderMessage + '\'' +
                ", orderDate='" + orderDate + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderNumber, userNumber, orderState, orderPostNumber, orderAddr, ordererName, ordererPhone, orderMessage, orderDate);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderVo orderVo = (OrderVo) o;
        return Objects.equals(orderNumber, orderVo.orderNumber) &&
                Objects.equals(userNumber, orderVo.userNumber) &&
                Objects.equals(orderState, orderVo.orderState) &&
                Objects.equals(orderPostNumber, orderVo.orderPostNumber) &&
                Objects.equals(orderAddr, orderVo.orderAddr) &&
                Objects.equals(ordererName, orderVo.ordererName) &&
                Objects.equals(ordererPhone, orderVo.ordererPhone) &&
                Objects.equals(orderMessage, orderVo.orderMessage) &&
                Objects.equals(orderDate, orderVo.orderDate);
    }
}
