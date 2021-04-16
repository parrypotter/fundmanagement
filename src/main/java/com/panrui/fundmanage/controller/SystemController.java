package com.panrui.fundmanage.controller;
import com.panrui.fundmanage.domain.Admin;
import com.panrui.fundmanage.domain.User;
import com.panrui.fundmanage.service.AdminService;
import com.panrui.fundmanage.service.UserService;
import com.panrui.fundmanage.singleton.ConfigSingleton;
import com.panrui.fundmanage.util.AjaxResult;
import com.panrui.fundmanage.util.CodeUtils;
import com.panrui.fundmanage.util.Const;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;

/*
 * @ClassName SystemController
 * @Description  System层主要承担公用部分
 * @Param
 **/
@Controller
@RequestMapping("/system")
public class SystemController {


    /*service*/
    @Autowired
    private AdminService adminService;
    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String login(){ return "login";}

    /*
    登录验证
    * */
    @PostMapping("/login")
    @ResponseBody
    public AjaxResult submissionLogin(@RequestParam(name = "username")String username, @RequestParam(name = "password")String password,
                                      @RequestParam(name = "code")String code,
                                      @RequestParam(name = "typeId")String typeId, HttpSession httpSession){
        AjaxResult ajaxResult = new AjaxResult();
        if(!code.equalsIgnoreCase((String)httpSession.getAttribute(Const.CODE))){
            ajaxResult.setMessage("验证码错误");
            ajaxResult.setSuccess(false);
            return ajaxResult;
        }
        //登录
        switch (typeId){
            case "1":{//管理员typeId=1
                Admin admin = new Admin();
                admin.setAdminist(username,password);
                Admin adminResult = ConfigSingleton.getInstance().findAdministrator(admin);
                if(adminResult==null){
                    ajaxResult.setMessage("用户名或密码错误");
                    ajaxResult.setSuccess(false);
                    return ajaxResult;
                }
                ajaxResult.setSuccess(true);
                httpSession.setAttribute(Const.ADMIN,adminResult);
                httpSession.setAttribute(Const.TYPEID,"1");
                break;
            }
            case "0":{//普通员工typeId=0
                User user = new User();
                user.setUsername(username);
                user.setPassword(password);
                User userResult = ConfigSingleton.getInstance().findUser(user);
                if(userResult==null){
                    ajaxResult.setMessage("用户名或密码错误");
                    ajaxResult.setSuccess(false);
                    return ajaxResult;
                }else {
                    ajaxResult.setSuccess(true);
                    httpSession.setAttribute(Const.USER,userResult);
                    httpSession.setAttribute(Const.TYPEID,"0");
                }
                break;
            }
        }
        return ajaxResult;

    }
    /*
    * 异步Ajax生成验证码
    * 尺寸设定参数vl,w,h
    * ImageIO字节流写入到前端页面*/
    @GetMapping("/checkcode")
    public void generateCode(HttpServletRequest request, HttpServletResponse response,
                             @RequestParam(value="vl",defaultValue="4",required=false) Integer vl,
                             @RequestParam(value="w",defaultValue="110",required=false) Integer w,
                             @RequestParam(value="h",defaultValue="39",required=false) Integer h){
        CodeUtils codeUtils = new CodeUtils(vl, w, h);
        String verificationCode = codeUtils.generatorVCode();
        request.getSession().setAttribute(Const.CODE,verificationCode);//将验证存入session中
        BufferedImage verificationCodeImage = codeUtils.generatorRotateVCodeImage(verificationCode,true);
        try {
            ImageIO.write(verificationCodeImage, "gif", response.getOutputStream());
        }catch (IOException exception){
            exception.printStackTrace();
        }
    }

    /*
    主要模块跳转
    */
    @GetMapping("/index")
    public String returnMainIndex(Model model){
        return "main/index";
    }

    /*
    公用模块：退出登录
    */
    @GetMapping("/logout")
    public String logOut(HttpSession httpSession){
        httpSession.invalidate();
        return "login";
    }


    /*
    Admin和User编辑密码
    该部分涉及到：（1）原密码验证；（2）新密码写入
    * */
    @PostMapping("/editPassword")
    @ResponseBody
    public AjaxResult editPassword(@RequestParam(name = "oldPassword")String oldPassword, @RequestParam(name = "newPassword")String newPassword,
                                   HttpSession httpSession){
        AjaxResult ajaxResult = new AjaxResult();
        String userType = (String)httpSession.getAttribute(Const.TYPEID);
        //Admin
        if(userType.equals("1")){
            Admin admin = (Admin) httpSession.getAttribute(Const.ADMIN);
            if(!oldPassword.equals(admin.getPassword())){
                ajaxResult.setMessage("原密码错误！");
                ajaxResult.setSuccess(false);
                return ajaxResult;
            }
            admin.setPassword(newPassword);
            try {
                int updateResult = adminService.exitAdminPassword(admin);
                if(updateResult>0){
                    ajaxResult.setMessage("密码重置成功！");
                    ajaxResult.setSuccess(true);
                }else {
                    ajaxResult.setMessage("密码更新出错！");
                    ajaxResult.setSuccess(false);
                }
            }catch (Exception exception){
                exception.printStackTrace();
                ajaxResult.setMessage("密码更新出错！");
                ajaxResult.setSuccess(false);
            }
        }
        //User
        if(userType.equals("0")){
            User user = (User) httpSession.getAttribute(Const.USER);
            if(!oldPassword.equals(user.getPassword())){
                ajaxResult.setMessage("原密码错误！");
                ajaxResult.setSuccess(false);
                return ajaxResult;
            }
            user.setPassword(newPassword);
            try {
                int updateResult = userService.updatePassword(user);
                if(updateResult>0){
                    ajaxResult.setMessage("密码重置成功！");
                    ajaxResult.setSuccess(true);
                }else {
                    ajaxResult.setMessage("密码更新出错！");
                    ajaxResult.setSuccess(false);
                }
            }catch (Exception exception){
                exception.printStackTrace();
                ajaxResult.setMessage("密码更新出错！");
                ajaxResult.setSuccess(false);
            }
        }
        return ajaxResult;
    }




}
