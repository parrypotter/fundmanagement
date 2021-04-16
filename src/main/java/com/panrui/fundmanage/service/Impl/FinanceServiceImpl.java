package com.panrui.fundmanage.service.Impl;

import com.panrui.fundmanage.domain.FinanceInfo;
import com.panrui.fundmanage.mapper.FinanceMapper;
import com.panrui.fundmanage.service.FinanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class FinanceServiceImpl implements FinanceService {


    @Autowired
    private FinanceMapper financeMapper;

    @Override
    public List<FinanceInfo> getAllFinanceInfoList(int startIndex, int pageSize) {
        return financeMapper.getAllFinanceInfoList(startIndex, pageSize);
    }

    @Override
    public Integer getFinancePage(){return financeMapper.getFinancePage();}
}
