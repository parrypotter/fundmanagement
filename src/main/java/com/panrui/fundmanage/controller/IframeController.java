package com.panrui.fundmanage.controller;

import com.panrui.fundmanage.domain.FinanceInfo;
import com.panrui.fundmanage.service.UserService;
import com.panrui.fundmanage.singleton.ConfigSingleton;
import com.panrui.fundmanage.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.HashMap;
import java.util.Map;

/**
 * @author panrui
 */
@Controller
@RequestMapping("/iframe")
public class IframeController {

    @Autowired
    private UserService userService;

    /*@GetMapping("/income")
    public Object returnIncome(Model model, @RequestParam(value = "pageNum", defaultValue = "1")Integer pageNum,
                               @RequestParam(value = "pageSize", defaultValue = "8")Integer pageSize){
            //走单例模式请求数据库表，只需要一个线程实现该内容
            Map<String, Integer> parameterMap = new HashMap();
            //这里是默认请求，只显示第一页和每页八条finance信息数目
            parameterMap.put("pageNum",pageNum);
            //第几页
            parameterMap.put("pageSize",pageSize);
            //每页数据条数
            PageBean<FinanceInfo> financeInfoPageBean = ConfigSingleton.getInstance().getAllFinanceInfo(parameterMap);
            *//*此时，
             * @Param financeInfoPageBean 中含有起始页信息，数据库查询finance表信息的起始索引数，pageNum、totalSize、totalNum和pageSize
             * 后续优化，setAttributes(List)
             * *//*
            //当前页面第一条记录数对应的数据库行数
            model.addAttribute("startIndex",financeInfoPageBean.getStartIndex());
            //当前页面最后一条记录数对应的数据库行数
            model.addAttribute("endIndex",financeInfoPageBean.getStartIndex()+8);
            //共几页
            model.addAttribute("totalNum",financeInfoPageBean.gettotalNum());
            //有多少条数据
            model.addAttribute("totalSize",financeInfoPageBean.gettotalSize());
            model.addAttribute("finance_list_info",financeInfoPageBean.getdataS());
           return "income/test";


    }*/

    @GetMapping("/income")
    public Object returnIncome(Model model){
        //共几页
        model.addAttribute("totalNum",financeInfoPageBean.gettotalNum());
        //有多少条数据
        model.addAttribute("totalSize",financeInfoPageBean.gettotalSize());
        return "income/test";
    }

    @GetMapping("/Linechart")
    public String returnLinechart(){
        return "charts/Linechart";
    }

    @GetMapping("/Piechart")
    public String returnPiechart(){
        return "charts/Piechart";
    }
}
