package com.panrui.fundmanage.service.Impl;

import com.panrui.fundmanage.domain.Admin;
import com.panrui.fundmanage.mapper.AdminMapper;
import com.panrui.fundmanage.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*
 * @ClassName AdminServiceImpl
 * @Description 接口实现（1）管理员登录信息验证；（2）修改管理员密码；
 * @Param
 **/
@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;
    
    @Override
    public Admin findAdministrator(Admin admin) {
        return adminMapper.findAdministrator(admin);
    }

    @Override
    public int exitAdminPassword(Admin admin) {
        return adminMapper.exitAdminPassword(admin);
    }

    @Override
    public int deleteUsers(List<Integer> ids) {
        return adminMapper.deleteUsers(ids);
    }



    /*@Override
    public User getAllUser(User user) {
        return adminMapper.getAllUser(user);
    }*/
}
