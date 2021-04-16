package com.panrui.fundmanage.domain;

import java.util.Date;

/*
 * @ClassName IncomeHistory
 * @Description  收支历史展示，包含balance（剩余金额）、Retime(报销时间)
 * @Param
 **/
public class IncomeHistory {
    private Float balance;
    private Date Retime;

    public Float getBalance() {
        return balance;
    }

    public void setBalance(Float balance) {
        this.balance = balance;
    }

    public Date getRetime() {
        return Retime;
    }

    public void setRetime(Date retime) {
        Retime = retime;
    }

}
