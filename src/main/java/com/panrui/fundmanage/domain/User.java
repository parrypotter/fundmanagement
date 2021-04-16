package com.panrui.fundmanage.domain;
/*
 * @ClassName UserRegister
 * @Description  包含用户注册信息uid、username、password、phone、identity
 * @Param 
 **/
public class User {
    private long uid;//len=11
    private String username;//len=8
    private String name;//len=8
    private String password;//len=16
    private String phone;//len=11
    private String identity;//len=18

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
