package com.panrui.fundmanage.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.sql.Timestamp;
import java.util.Date;

/*
 * @ClassName Fund
 * @Description 经费列表信息
 * @Param 
 **/
public class FinanceInfo {
    private int uid;//自增uid,len=4
    private int claimer_user_id;//报销人，0代表团队，1代表个人,len=4
    private String reason;//事由，len=30
    private String balance;//余额
    private String recorder_user_id;//记录人，外键映射到User表中的uid,len=10
    private Integer is_deleted;//逻辑删除 0=未删除,1=已删除,len=4
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Timestamp create_time;//创建时间，len=6
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Timestamp update_time;//修改时间，len=6
    private String sum;//报销金额数,len=10
    private int type;//报销类型，1代表支出，2代表收入,len=4
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Timestamp reason_time;//发生事由，len=6

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }
    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getClaimer_user_id() {
        return claimer_user_id;
    }

    public void setClaimer_user_id(int claimer_user_id) {
        this.claimer_user_id = claimer_user_id;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getRecorder_user_id() {
        return recorder_user_id;
    }

    public void setRecorder_user_id(String recorder_user_id) {
        this.recorder_user_id = recorder_user_id;
    }

    public Integer getIs_deleted() {
        return is_deleted;
    }

    public void setIs_deleted(Integer is_deleted) {
        this.is_deleted = is_deleted;
    }

    public Timestamp getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Timestamp create_time) {
        this.create_time = create_time;
    }

    public Timestamp getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time( Timestamp update_time) {
        this.update_time = update_time;
    }

    public String getSum() {
        return sum;
    }

    public void setSum(String sum) {
        this.sum = sum;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Timestamp getReason_time() {
        return reason_time;
    }

    public void setReason_time(Timestamp reason_time) {
        this.reason_time = reason_time;
    }
}
