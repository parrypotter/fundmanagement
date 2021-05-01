package com.panrui.fundmanage.mapper;

import com.panrui.fundmanage.domain.FinanceInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;


/**
 * @author Alienware
 */
@Repository
public interface FinanceMapper {

    List<FinanceInfo> getAllFinanceInfoList(@Param("startIndex") int startIndex, @Param("pageSize") int pageSize);

    Integer getFinancePage();

    List<FinanceInfo> getFinanceFromDate(@Param("startIndex")int startIndex, @Param("pageSize")int pageSize, @Param("createTime")String createTime, @Param("updateTime") String updateTime);

    List<FinanceInfo> getFinanceFromReason(@Param("startIndex")int startIndex, @Param("pageSize")int pageSize,@Param("reason")String reason);

    List<FinanceInfo> getFinanceFromClaimerUserId(@Param("startIndex")int startIndex, @Param("pageSize")int pageSize,@Param("claimerUserId") int claimerUserId);

    Integer getFinanceListLengthFromDate(@Param("createTime")String createTime, @Param("updateTime") String updateTime);

    Integer getFinanceListLengthFromReason(@Param("reason")String reason);

    Integer getFinanceListLengthFromClaimerUserId(@Param("claimerUserId") Integer claimerUserId);

    Integer insertFinanceInfo(@Param("claimerValue") Integer claimerValue,
                              @Param("reasonValue") String reasonValue,
                              @Param("recorderValue") Integer recorderValue,
                              @Param("createTime") String createTime,
                              @Param("updateTime") String updateTime,
                              @Param("sumValue") String sumValue,
                              @Param("typeValue") String typeValue);
}
