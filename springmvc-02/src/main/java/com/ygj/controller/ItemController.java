package com.ygj.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ygj.bean.Item;
import com.ygj.bean.ItemType;
import com.ygj.service.ItemService;
import com.ygj.service.ItemTypeService;
import com.ygj.utils.Page;

@Controller
@RequestMapping("item")
public class ItemController {

    
    @Autowired
    private ItemService itemService;
    
    @Autowired
    private ItemTypeService itemTypeService;
    
    //查询列表
    @RequestMapping("selectAll")
    public ModelAndView selectAll(ModelAndView mv,String currentPage,String mohu){
        if(mohu==null){
            mohu = "";
        }
        Integer count = this.itemService.count(mohu);
        Page<Item> page = new Page<Item>(currentPage,count,"3");  
        List<Item> list = this.itemService.pageList(mohu,page);
        mv.addObject("itemList", list);
        mv.addObject("page", page);
        mv.addObject("mohu", mohu);
        //mv.addObject("itemList", this.itemService.selectAll());
        mv.setViewName("itemList");
        return mv;
    }
    
    //跳转添加商品界面
    @RequestMapping("addItemPage")
    public String addItemPage(){
        return "addItem";
    }
    
    //添加商品
    @RequestMapping("additem")
    public String additem(Item item){
        this.itemService.additem(item);
        return "forward:selectAll.do";
    }
    
    //跳转到修改界面
    @RequestMapping("updItemById")
    public String updItemById(String id){
        return "updItem";
    }
    
    //修改ajax请求
    @RequestMapping("getItemById")
    @ResponseBody
    public Map<String , Object> getItemById(String id){
        Map<String , Object> map = new HashMap<String, Object>();
        Item item = this.itemService.getItemById(id);
        List<ItemType> list = this.itemTypeService.getItemType();
        map.put("item", item);
        map.put("itemType", list);
        return map;
    }
    
    //添加商品
    @RequestMapping("upditem")
    public String upditem(Item item){
        try {
            this.itemService.upditem(item);
            return "forward:selectAll.do";
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return "error";
        }
    }
    
    //删除商品
    @RequestMapping("delItemById")
    public String delItemById(String id){
        this.itemService.delItemById(id);
        return "forward:selectAll.do";
    }
    
    //批量删除
    @RequestMapping("deleteAllItem")
    public String deleteAllItem(String id){
        this.itemService.delItemById(id);
        return "forward:selectAll.do";
    }
    
}
