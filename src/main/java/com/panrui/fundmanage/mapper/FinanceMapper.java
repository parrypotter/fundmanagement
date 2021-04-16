package com.panrui.fundmanage.mapper;

import com.panrui.fundmanage.domain.FinanceInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface FinanceMapper {

    List<FinanceInfo> getAllFinanceInfoList(@Param("startIndex") int startIndex, @Param("pageSize") int pageSize);

    Integer getFinancePage();

}
