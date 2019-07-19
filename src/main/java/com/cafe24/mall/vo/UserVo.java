package com.cafe24.mall.vo;

import java.util.Objects;

public class UserVo {
    public enum UserGender {FEMALE, MALE};
    // TODO : add validator
    private Long userNumber;
    private String userName;
    private String userId;
    private String userPassword;
    private String userJoinDate;
    private UserGender userGender;
    private Integer userTall;
    private String userBirth;
    private String userPostNumber;
    private String userAddr;
    private String userPhone;

    @Override
    public String toString() {
        return "UserVo{" +
                "userNumber=" + userNumber +
                ", userName='" + userName + '\'' +
                ", userId='" + userId + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userJoinDate='" + userJoinDate + '\'' +
                ", userGender=" + userGender +
                ", userTall=" + userTall +
                ", userBirth='" + userBirth + '\'' +
                ", userPostNumber='" + userPostNumber + '\'' +
                ", userAddr='" + userAddr + '\'' +
                ", userPhone='" + userPhone + '\'' +
                '}';
    }

    public Long getUserNumber() {
        return userNumber;
    }

    public void setUserNumber(Long userNumber) {
        this.userNumber = userNumber;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserJoinDate() {
        return userJoinDate;
    }

    public void setUserJoinDate(String userJoinDate) {
        this.userJoinDate = userJoinDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserVo userVo = (UserVo) o;
        return Objects.equals(userNumber, userVo.userNumber) &&
                Objects.equals(userName, userVo.userName) &&
                Objects.equals(userId, userVo.userId) &&
                Objects.equals(userPassword, userVo.userPassword) &&
                Objects.equals(userJoinDate, userVo.userJoinDate) &&
                userGender == userVo.userGender &&
                Objects.equals(userTall, userVo.userTall) &&
                Objects.equals(userBirth, userVo.userBirth) &&
                Objects.equals(userPostNumber, userVo.userPostNumber) &&
                Objects.equals(userAddr, userVo.userAddr) &&
                Objects.equals(userPhone, userVo.userPhone);
    }
    public boolean equalsWithOutJoinDate(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserVo userVo = (UserVo) o;
        return Objects.equals(userNumber, userVo.userNumber) &&
                Objects.equals(userName, userVo.userName) &&
                Objects.equals(userId, userVo.userId) &&
                Objects.equals(userPassword, userVo.userPassword) &&
                userGender == userVo.userGender &&
                Objects.equals(userTall, userVo.userTall) &&
                Objects.equals(userBirth, userVo.userBirth) &&
                Objects.equals(userPostNumber, userVo.userPostNumber) &&
                Objects.equals(userAddr, userVo.userAddr) &&
                Objects.equals(userPhone, userVo.userPhone);
    }
    @Override
    public int hashCode() {
        return Objects.hash(userNumber, userName, userId, userPassword, userJoinDate, userGender, userTall, userBirth, userPostNumber, userAddr, userPhone);
    }

    public UserGender getUserGender() {
        return userGender;
    }

    public void setUserGender(UserGender userGender) {
        this.userGender = userGender;
    }

    public Integer getUserTall() {
        return userTall;
    }

    public void setUserTall(Integer userTall) {
        this.userTall = userTall;
    }

    public String getUserBirth() {
        return userBirth;
    }

    public void setUserBirth(String userBirth) {
        this.userBirth = userBirth;
    }

    public String getUserPostNumber() {
        return userPostNumber;
    }

    public void setUserPostNumber(String userPostNumber) {
        this.userPostNumber = userPostNumber;
    }

    public String getUserAddr() {
        return userAddr;
    }

    public void setUserAddr(String userAddr) {
        this.userAddr = userAddr;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }
}
