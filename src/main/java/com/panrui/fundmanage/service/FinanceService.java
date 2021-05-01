package com.panrui.fundmanage.service;

import com.panrui.fundmanage.domain.FinanceInfo;
import com.panrui.fundmanage.util.PageBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FinanceService {

    /**
     * 获取经费信息列表
     * */
    List<FinanceInfo> getAllFinanceInfoList(int startIndex, int pageSize);

    /**
     *查询表tb_finance_info中的总记录数
     */
    Integer getFinancePage();

    /**
     *Finance模糊查询
     */
    List<FinanceInfo> getFinanceListByFinanceInfo(int startIndex, int pageSize, String[] targetObj);

    Integer getFinancePageByKeys(String[] targetObj);

    Integer insertFinanceInfo(Integer claimerValue, String reasonValue, Integer recorderValue, String createTime, String updateTime, String sumValue, String typeValue);

}
