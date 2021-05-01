package com.panrui.fundmanage.domain;
/**
 * @author panrui
 * @ClassName UserRegister
 * @Description  包含用户注册信息uid、username、password、phone、identity
 **/
public class User {
    private long uid;
    private String username;
    private String name;
    private String password;
    private String phone;
    private String identity;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void notVerifyUserInfo(long uid, String name, String password, String phone, String identity){
        this.uid = uid;
        this.name = name;
        this.password = password;
        this.phone = phone;
        this.identity = identity;
    }


}
