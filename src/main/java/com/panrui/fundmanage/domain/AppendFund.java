package com.panrui.fundmanage.domain;

import java.util.Date;

/*
 * @ClassName AppendFund
 * @Description  添加经费数据，包含reimbursement（报销人0和1团队和个人）、reason、Intime、InOutmoney（收支金额）、
 * type（0和1收入和支出）、balance（剩余金额）
 * @Param
 **/
public class AppendFund {
    private Integer reimbursement;
    private String reason;
    private Date Intime;
    private Float InOutmoney;
    private Integer type;
    private Float balance;

    public Integer getReimbursement() {
        return reimbursement;
    }

    public void setReimbursement(Integer reimbursement) {
        this.reimbursement = reimbursement;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Date getIntime() {
        return Intime;
    }

    public void setIntime(Date intime) {
        Intime = intime;
    }

    public Float getInmoney() {
        return InOutmoney;
    }

    public void setInmoney(Float inmoney) {
        InOutmoney = inmoney;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Float getBalance() {
        return balance;
    }

    public void setBalance(Float balance) {
        this.balance = balance;
    }


}
