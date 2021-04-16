package com.panrui.fundmanage.controller;

import com.panrui.fundmanage.domain.FinanceInfo;
import com.panrui.fundmanage.domain.User;
import com.panrui.fundmanage.service.AdminService;
import com.panrui.fundmanage.service.UserService;
import com.panrui.fundmanage.singleton.ConfigSingleton;
import com.panrui.fundmanage.util.AjaxResult;
import com.panrui.fundmanage.util.JuageNumber;
import com.panrui.fundmanage.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/indexAction")
public class IndexActionController {

    @Autowired
    private AdminService adminService;
    @Autowired
    private UserService userService;

    private static volatile List<User> listUsers = null;
    /*
     * 管理员账户，查询所有User（待定）
     * */
    @GetMapping("/userList")
    public String showUserList(Model model){
        try {
            listUsers = this.userService.findUsersAll();
            model.addAttribute("listUsers",listUsers);
        }
        catch (Exception e){
            e.printStackTrace();
            return "error";//500页面
        }
        return "/list/userlist";
    }

    /*设置页面显示finance列表数据
      select下拉框传值
     */
    @PostMapping("/selects")
    @ResponseBody
    public Object setFinanceListMaxsizeFromSelections(@RequestParam(name = "opt_values")Integer opt_values, Model model){
        AjaxResult ajaxResult = new AjaxResult();
        Map<String, Integer> parameterMap = new HashMap();
        parameterMap.put("pageNum",1);//第几页
        parameterMap.put("pageSize",opt_values);//每页数据条数
        System.out.println(opt_values);
        try{
            PageBean<FinanceInfo> financeInfoPageBean = ConfigSingleton.getInstance().getAllFinanceInfo(parameterMap);
            model.addAttribute("endIndex",financeInfoPageBean.getStartIndex()+opt_values);//当前页面最后一条记录数对应的数据库行数
            model.addAttribute("finance_list_info",financeInfoPageBean.getdataS());//finance信息列表
            model.addAttribute("totalNum",financeInfoPageBean.gettotalNum());//共几页
            JuageNumber.setLopId(1);
            return "/income/Income";
        }catch (Exception exception){
            exception.printStackTrace();
            ajaxResult.setMessage("查询服务异常");
            ajaxResult.setSuccess(false);
            return ajaxResult;
        }
    }

    /*
    模糊查询显示所有员工信息表
    */
    @RequestMapping("/fuzzyUsers")
    @ResponseBody
    public Object getAllUsersList(@RequestParam(value = "page", defaultValue = "1")Integer page,
                                  @RequestParam(value = "rows", defaultValue = "100")Integer rows,
                                  String username,
                                  String from,
                                  HttpSession session){
        return null;
    }
}
