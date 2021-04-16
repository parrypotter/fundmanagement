package com.panrui.fundmanage.mapper;

import com.panrui.fundmanage.domain.User;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Map;

/*
 * @ClassName UserMapper
 * @Description  
 * @Param 
 **/
@Repository
public interface UserMapper {
    List<Map<Object,Object>> checkUserInfo(User user);//检查用户名

    User findUser(User user);//用户登录验证

    int updatePassword(String password, long uid);//修改密码

    int updatePhone(String phone, long uid);//修改手机号

    int updateUsername(String username, long uid);//修改用户名

    int updateIdentity(String identity, long uid);//修改身份证号码

    int userRegister(User user);//新用户注册

    List<User> findUsersAll();//查询当前所有用户

}
