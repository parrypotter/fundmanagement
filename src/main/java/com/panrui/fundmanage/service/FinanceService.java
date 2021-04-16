package com.panrui.fundmanage.service;

import com.panrui.fundmanage.domain.FinanceInfo;
import com.panrui.fundmanage.util.PageBean;

import java.util.List;

public interface FinanceService {

    List<FinanceInfo> getAllFinanceInfoList(int startIndex, int pageSize);//获取经费信息列表

    Integer getFinancePage();//查询表tb_finance_info中的总记录数

}
