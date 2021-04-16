package com.panrui.fundmanage.controller;

import com.panrui.fundmanage.domain.User;
import com.panrui.fundmanage.service.UserService;
import com.panrui.fundmanage.singleton.ConfigSingleton;
import com.panrui.fundmanage.util.AjaxResult;
import com.panrui.fundmanage.util.Const;
import com.panrui.fundmanage.util.SnowFlakeUid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpSession;
import java.text.ParseException;

/*
 * @ClassName RegisterController
 * @Description  主要实现用户注册
 * @Param
 **/
@Controller
@RequestMapping("/user")
public class RegisterController {

    @Autowired
    private UserService userService;

    @GetMapping("/registerUser")
    public String registerUserAction(){
        return "/register/register";
    }

    @PostMapping("/addUser")
    @ResponseBody
    public AjaxResult addUser(@RequestParam(name = "username")String username, @RequestParam(name = "name")String name,
                              @RequestParam(name = "password")String password, @RequestParam(name = "phone")String phone,
                              @RequestParam(name = "identity")String identity) throws ParseException {
        AjaxResult ajaxResult = new AjaxResult();
        User thisUser = new User();
        thisUser.setUsername(username);
        if(ConfigSingleton.getInstance().checkUserInfo(thisUser).containsValue(username)){
            ajaxResult.setMessage("当前用户已存在");
            ajaxResult.setSuccess(false);
        }else {
            thisUser.notVerifyUserInfo(new SnowFlakeUid().nextId(),name,password,phone,identity);
            if(ConfigSingleton.getInstance().userRegister(thisUser)>0){
                ajaxResult.setMessage("注册成功，即将前往登录界面进行登录");
                ajaxResult.setSuccess(true);
            }
            else {
                ajaxResult.setMessage("注册失败");
                ajaxResult.setSuccess(false);
            }
        }
        return ajaxResult;
    }

    /*
   User功能：修改用户名
   */
    @PostMapping("/editUsername")
    @ResponseBody
    public AjaxResult editUsername(String oldUsername, String newUsername, HttpSession httpSession){
        AjaxResult ajaxResult = new AjaxResult();
        User user = (User) httpSession.getAttribute(Const.USER);
        if(!oldUsername.equals(user.getUsername())){
            ajaxResult.setMessage("原用户名错误");
            ajaxResult.setSuccess(false);
            return ajaxResult;
        }
        user.setUsername(newUsername);
        try {
            int updateResult = userService.updateUsername(user);
            if(updateResult>0){
                ajaxResult.setMessage("用户名更新成功");
                ajaxResult.setSuccess(true);
            }else {
                ajaxResult.setMessage("用户名存在问题，请重新输入");
                ajaxResult.setSuccess(false);
            }
        }catch (Exception exception){
            exception.printStackTrace();
            ajaxResult.setMessage("用户名更新失败，系统错误");
            ajaxResult.setSuccess(false);
        }
        return ajaxResult;
    }

    /*
    User功能：修改手机号
    */
    @PostMapping("/editPhone")
    @ResponseBody
    public AjaxResult editPhone(String oldPhone, String newPhone, HttpSession httpSession){
        AjaxResult ajaxResult = new AjaxResult();
        User user = (User) httpSession.getAttribute(Const.USER);
        if(!oldPhone.equals(user.getPhone())){
            ajaxResult.setMessage("原手机号错误");
            ajaxResult.setSuccess(false);
            return ajaxResult;
        }
        user.setPhone(newPhone);
        try {
            int updateResult = userService.updatePhone(user);
            if(updateResult>0){
                ajaxResult.setMessage("手机号更新成功");
                ajaxResult.setSuccess(true);
            }else {
                ajaxResult.setMessage("手机号存在问题，请重新输入");
                ajaxResult.setSuccess(false);
            }
        }catch (Exception exception){
            exception.printStackTrace();
            ajaxResult.setMessage("手机号更新失败，系统错误");
            ajaxResult.setSuccess(false);
        }
        return ajaxResult;
    }

    /*
    User功能：修改身份证号码
    */
    @PostMapping("/editIdentity")
    @ResponseBody
    public AjaxResult editIdentity(String oldIdentity, String newIdentity, HttpSession httpSession){
        AjaxResult ajaxResult = new AjaxResult();
        User user = (User) httpSession.getAttribute(Const.USER);
        if(!oldIdentity.equals(user.getIdentity())){
            ajaxResult.setMessage("原身份证号码错误");
            ajaxResult.setSuccess(false);
            return ajaxResult;
        }
        user.setIdentity(newIdentity);
        try {
            int updateResult = userService.updateIdentity(user);
            if(updateResult>0){
                ajaxResult.setMessage("身份证号码更新成功");
                ajaxResult.setSuccess(true);
            }else {
                ajaxResult.setMessage("身份证号码存在问题，请重新输入");
                ajaxResult.setSuccess(false);
            }
        }catch (Exception exception){
            exception.printStackTrace();
            ajaxResult.setMessage("身份证号码更新失败，系统错误");
            ajaxResult.setSuccess(false);
        }
        return ajaxResult;
    }

}
