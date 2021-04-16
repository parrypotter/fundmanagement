package com.panrui.fundmanage.service;

import com.panrui.fundmanage.domain.Admin;

import java.util.List;

/*
 * @ClassName AdminService
 * @Description （1）管理员登录信息验证；（2）修改管理员密码；（3）批量删除用户；（4）获取用户列表
 * @Param
 **/
public interface AdminService {

    Admin findAdministrator(Admin admin);

    int exitAdminPassword(Admin admin);

    int deleteUsers(List<Integer> ids);//删除用户（批量）



}
