package com.panrui.fundmanage.singleton;

import com.panrui.fundmanage.domain.Admin;
import com.panrui.fundmanage.domain.FinanceInfo;
import com.panrui.fundmanage.domain.User;
import com.panrui.fundmanage.service.AdminService;
import com.panrui.fundmanage.service.FinanceService;
import com.panrui.fundmanage.service.UserService;
import com.panrui.fundmanage.util.PageBean;
import com.panrui.fundmanage.util.SpringContextUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/*
 * @ClassName UserSingleton
 * @Description  单例模式创建对象实现线程安全
 * @Param
 **/
public class ConfigSingleton {

    private static volatile ConfigSingleton INSTANCE;
    private UserService userService;
    private FinanceService financeService;
    private AdminService adminService;
    private ConfigSingleton(){
        userService = SpringContextUtils.getBean(UserService.class);
        financeService = SpringContextUtils.getBean(FinanceService.class);
        adminService = SpringContextUtils.getBean(AdminService.class);
    }

    public static ConfigSingleton getInstance(){
        if(null==INSTANCE){
            synchronized (ConfigSingleton.class){
                if(null==INSTANCE){
                    INSTANCE = new ConfigSingleton();
                }
            }
        }
        return INSTANCE;
    }
    /*
     * 使用 SpringContextUtils 获取的 UserService 对象，并从 UserMapper 中获取数据
     * @return
     */
    public int userRegister(User user){ return userService.userRegister(user);}

    public Map<Object,Object> checkUserInfo(User user){
        Map<Object,Object> userInfoMap = new HashMap<>();
        for (Map<Object,Object> listUser:userService.checkUserInfo(user)) {
            listUser.forEach(userInfoMap::put);
        }
        return userInfoMap;
    }

    public Admin findAdministrator(Admin admin){
        return adminService.findAdministrator(admin);
    }

    public User findUser(User user){
        return userService.findUser(user);
    }


    public PageBean<FinanceInfo> getAllFinanceInfo(Map<String, Integer> parameterMap){
        /*pageNum--->第几页;
        * pageSize--->每一页的记录数目
        * totalSize--->总的数据库表tb_finance_info记录数
        * totalNUm--->一共有多少页
        */
        int pageNum = parameterMap.get("pageNum");
        int pageSize = parameterMap.get("pageSize");
        PageBean<FinanceInfo> pageBean = new PageBean<>(pageNum,pageSize);
        int startIndex = pageBean.getStartIndex();
        parameterMap.put("startIndex",startIndex);
        List<FinanceInfo> dataS = financeService.getAllFinanceInfoList(startIndex,pageSize);
        pageBean.setdataS(dataS);
        int totalSize = financeService.getFinancePage();
        pageBean.settotalSize(totalSize);
        int totalNum = totalSize%pageSize==0?totalSize/pageSize:(totalSize/pageSize+1);
        pageBean.settotalNum(totalNum);
        return pageBean;
    }


}
