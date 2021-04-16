package com.panrui.fundmanage.domain;

/*
 * @ClassName Admin
 * @Description 管理员信息uid、username、password
 * @Param
 **/

import org.springframework.util.StringUtils;

public class Admin {

    private long uid;
    private String username;
    private String password;

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

    public void setAdminist(String username, String password){
        this.username = username;
        this.password = password;
    }


}
