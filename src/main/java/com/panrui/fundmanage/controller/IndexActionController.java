package com.panrui.fundmanage.controller;

import com.panrui.fundmanage.domain.FinanceInfo;
import com.panrui.fundmanage.domain.User;
import com.panrui.fundmanage.service.UserService;
import com.panrui.fundmanage.singleton.ConfigSingleton;
import com.panrui.fundmanage.util.Const;
import com.panrui.fundmanage.util.DateFormatUtil;
import com.panrui.fundmanage.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author panrui
 */
@Controller
@RequestMapping("/indexAction")
public class IndexActionController {

    private static final int USER_INSERT_RETURN = 1;
    @Autowired
    private UserService userService;
    @Autowired
    private DateFormatUtil dateFormatUtil;

    @InitBinder
    public void initBinder(WebDataBinder binder, WebRequest request) {
        //转换日期 注意这里的转化要和传进来的字符串的格式一直 如2015-9-9 就应该为yyyy-MM-dd
        DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
        // CustomDateEditor为自定义日期编辑器
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }
    /** @return 管理员账户，查询所有User（待定）
     */
    @GetMapping("/userList")
    public String showUserList(Model model){
        try {
            List<User> listUsers = this.userService.findUsersAll();
            model.addAttribute("listUsers", listUsers);
        }
        catch (Exception e){
            e.printStackTrace();
            //500页面
            return "error";
        }
        return "/list/userlist";
    }

    /**
     @return 设置页面显示finance列表数据 select下拉框传值
     */
    @PostMapping("/selects")
    @ResponseBody
    public Object setFinanceListMaxsizeFromSelections(@RequestParam(name = "pageSize")Integer pageSize, Model model){
        Map<String, Integer> parameterMap = new HashMap();
        Map<Boolean, Object> listMap = new HashMap();
        //第几页
        parameterMap.put("pageNum",1);
        //每页数据条数
        parameterMap.put("pageSize",pageSize);
        PageBean<FinanceInfo> financeInfoPageBean = ConfigSingleton.getInstance().getAllFinanceInfo(parameterMap);
        //当前页面最后一条记录数对应的数据库行数
        model.addAttribute("endIndex",financeInfoPageBean.getStartIndex()+pageSize);
        //共几页
        model.addAttribute("totalNum",financeInfoPageBean.gettotalNum());
        listMap.put(true,financeInfoPageBean.getdataS());
        return listMap;
    }

    /**
        @return 模糊查询显示所有员工信息表
    */
    @PostMapping("/fuzzyUsers")
    @ResponseBody
    public Object getFuzzyCheck(@RequestParam(name = "pageSize")Integer pageSize,
                                @RequestParam(name = "createTime", required = false)Date createTime,
                                @RequestParam(name = "updateTime", required = false)Date updateTime,
                                @RequestParam(name = "searchText")String searchText) {
        String[] targetObj;
        targetObj = searchText.length()==0?new String[]{dateFormatUtil.getFormatDate(createTime),dateFormatUtil.getFormatDate(updateTime)}:new String[]{searchText};
        Map<String, Integer> parameterMap = new HashMap();
        Map<Boolean, Object> listMap = new HashMap();
        parameterMap.put("pageNum",1);
        parameterMap.put("pageSize",pageSize);
        PageBean<FinanceInfo> financeInfoPageBean = ConfigSingleton.getInstance().getAllFinanceInfo(parameterMap,targetObj);
        listMap.put(true,financeInfoPageBean.getdataS());
        return listMap;
    }

    /**
     * @ClassName IndexActionController
     * @Description  （1）数据库添加，判断返回值success？
     *              （2）刷新页面，显示记录数和页数是否增加？
     *             （3）
     * @Param [claimerValue, reasonValue, createTime, sumValue, typeValue, updateTime]
     * @return HashMap<Boolean, ListM<FinanceInfo> >
     **/
    @GetMapping("/addFinanceInfo")
    @ResponseBody
    public Map<Boolean, Object> appendFinanceInfo(HttpServletRequest request,
                                                             @RequestParam(name = "claimerValue") String claimerValue,
                                                             @RequestParam(name = "reasonValue") String reasonValue,
                                                             @RequestParam(name = "createTime") Date createTime,
                                                             @RequestParam(name = "updateTime") Date updateTime,
                                                             @RequestParam(name = "sumValue") String sumValue,
                                                             @RequestParam(name = "typeValue") String typeValue){
        User userRecorder = (User) request.getSession().getAttribute(Const.USER);
        Map<String, Integer> parameterMap = new HashMap<>();
        Map<Boolean, Object> financeInfoListMap = new HashMap<>();
        parameterMap.put("pageNum",1);
        parameterMap.put("pageSize",8);
        Map<Integer, PageBean<FinanceInfo>> financeInfoMap = ConfigSingleton.getInstance().appendFinanceInfo(
                parameterMap,claimerValue,reasonValue,(int) userRecorder.getUid(),dateFormatUtil.getFormatDate(createTime),
                dateFormatUtil.getFormatDate(updateTime),sumValue,typeValue);
        financeInfoListMap.put(financeInfoMap.containsKey(USER_INSERT_RETURN), financeInfoMap.containsKey(USER_INSERT_RETURN)?financeInfoMap.get(1).getdataS():null);
        return financeInfoListMap;
    }

}
