package com.panrui.fundmanage.mapper;


import com.panrui.fundmanage.domain.Admin;
import com.panrui.fundmanage.domain.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/*
 * @ClassName AdminMapper
 * @Description  通过mybatis实习与数据库信息交互
 * @Param
 **/
@Repository
public interface AdminMapper {
    Admin findAdministrator(Admin admin);

    int exitAdminPassword(Admin admin);

    int deleteUsers(List<Integer> ids);//删除用户（批量）


}
