package com.panrui.fundmanage.service.Impl;

import com.panrui.fundmanage.domain.FinanceInfo;
import com.panrui.fundmanage.mapper.FinanceMapper;
import com.panrui.fundmanage.service.FinanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class FinanceServiceImpl implements FinanceService {

    private final static String CLAIMER_USER_TEAM = "团队";
    private final static String CLAIMER_USER_PERSON = "个人";
    @Autowired
    private FinanceMapper financeMapper;

    @Override
    public List<FinanceInfo> getAllFinanceInfoList(int startIndex, int pageSize) {
        return financeMapper.getAllFinanceInfoList(startIndex, pageSize);
    }

    @Override
    public Integer getFinancePage(){return financeMapper.getFinancePage();}

    @Override
    public List<FinanceInfo> getFinanceListByFinanceInfo(int startIndex, int pageSize, String[] targetObj) {
        if(targetObj.length>1){
            return financeMapper.getFinanceFromDate(startIndex, pageSize, targetObj[0], targetObj[1]);
        }
        if(targetObj.length==1&&!targetObj[0].equals(CLAIMER_USER_TEAM)&&!targetObj[0].equals(CLAIMER_USER_PERSON)){
            return financeMapper.getFinanceFromReason(startIndex, pageSize, targetObj[0]);
        }else {
            int claimerUserId = targetObj[0].equals(CLAIMER_USER_TEAM)?0:1;
            return financeMapper.getFinanceFromClaimerUserId(startIndex, pageSize, claimerUserId);
        }
    }

    @Override
    public Integer getFinancePageByKeys(String[] targetObj) {
        if(targetObj.length>1){
            return financeMapper.getFinanceListLengthFromDate(targetObj[0], targetObj[1]);
        }
        if(targetObj.length==1&&!targetObj[0].equals(CLAIMER_USER_TEAM)&&!targetObj[0].equals(CLAIMER_USER_PERSON)){
            return financeMapper.getFinanceListLengthFromReason(targetObj[0]);
        }else {
            int claimerId = targetObj[0].equals(CLAIMER_USER_TEAM)?0:1;
            return financeMapper.getFinanceListLengthFromClaimerUserId(claimerId);
        }
    }

    @Override
    public Integer insertFinanceInfo(Integer claimerValue, String reasonValue, Integer recorderValue, String createTime, String updateTime, String sumValue, String typeValue) {
        return financeMapper.insertFinanceInfo(claimerValue, reasonValue, recorderValue, createTime, updateTime, sumValue, typeValue);
    }
}
