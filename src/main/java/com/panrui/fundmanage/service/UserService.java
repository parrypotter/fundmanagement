package com.panrui.fundmanage.service;

import com.panrui.fundmanage.domain.User;
import java.util.List;
import java.util.Map;

/*
 * @ClassName UserService
 * @Description  用户类型操作
 * @Param
 **/
public interface UserService {

    List<Map<Object,Object>> checkUserInfo(User user);//检查用户信息

    User findUser(User user);

    int updatePassword(User user);//修改密码

    int updatePhone(User user);//修改手机号

    int updateUsername(User user);//修改用户名

    int updateIdentity(User user);//修改身份证号码

    int userRegister(User user);//新用户注册

    List<User> findUsersAll();//获取用户列表

}
