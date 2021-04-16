package com.panrui.fundmanage.domain;

import java.util.Date;

/*
 * @ClassName IncomeCompared
 * @Description  收支对比，包含type（0和1收入和支出）、startTime（开始时间）、endTime（结束时间）、InOutmoney（收支金额）
 * @Param
 **/
public class IncomeCompared {
    private Integer type;
    private Date startTime;
    private Date endTime;
    private Float InOutmoney;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Float getInOutmoney() {
        return InOutmoney;
    }

    public void setInOutmoney(Float inOutmoney) {
        InOutmoney = inOutmoney;
    }


}
