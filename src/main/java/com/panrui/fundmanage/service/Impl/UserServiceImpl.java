package com.panrui.fundmanage.service.Impl;

import com.panrui.fundmanage.domain.User;
import com.panrui.fundmanage.mapper.UserMapper;
import com.panrui.fundmanage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @ClassName UserServiceImpl
 * @Description
                （1）检查用户名
                （2）检查密码
                （3）修改密码
                （4）修改手机号
                （5）修改用户名
                （6）修改身份证号码
                （7）新用户注册
                （8）删除用户（批量）
                （9）获取用户列表
 * @Param
 **/
@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserMapper userMapper;

    @Override
    public List<Map<Object,Object>> checkUserInfo(User user) {
        return userMapper.checkUserInfo(user);
    }

    @Override
    public User findUser(User user) {
        return userMapper.findUser(user);
    }

    @Override
    public int updatePassword(User user) {
        return userMapper.updatePassword(user.getPassword(),user.getUid());
    }

    @Override
    public int updatePhone(User user) {
        return userMapper.updatePhone(user.getPhone(),user.getUid());
    }

    @Override
    public int updateUsername(User user) {
        return userMapper.updateUsername(user.getUsername(),user.getUid());
    }

    @Override
    public int updateIdentity(User user) {
        return userMapper.updateIdentity(user.getIdentity(),user.getUid());
    }

    @Override
    public int userRegister(User user) {
        return userMapper.userRegister(user);
    }

    @Override
    public List<User> findUsersAll() { return userMapper.findUsersAll(); }


}
