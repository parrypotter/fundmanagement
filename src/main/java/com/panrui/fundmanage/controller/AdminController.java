package com.panrui.fundmanage.controller;

import com.panrui.fundmanage.domain.Admin;
import com.panrui.fundmanage.domain.User;
import com.panrui.fundmanage.service.AdminService;
import com.panrui.fundmanage.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;


/*
 * @ClassName AdminController
 * @Description  
 * @Param
 **/
@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    /*
    删除用户
    */
    @PostMapping("/deleteUsers")
    @ResponseBody
    public AjaxResult deleteUsers(Data userIds){
        AjaxResult ajaxResult = new AjaxResult();
        List<Integer> ids = userIds.getIds();
        int count = adminService.deleteUsers(ids);
        if(count > 0){
            ajaxResult.setSuccess(true);
            ajaxResult.setMessage("全部删除成功");
        }else{
            ajaxResult.setSuccess(false);
            ajaxResult.setMessage("删除失败");
        }
        return ajaxResult;
    }

}
