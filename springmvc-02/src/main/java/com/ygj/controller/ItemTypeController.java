package com.ygj.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ygj.bean.ItemType;
import com.ygj.service.ItemTypeService;

@Controller
@RequestMapping("itemType")
public class ItemTypeController {
    
    @Autowired
    private ItemTypeService itemTypeService;
    
    //下拉列表
    @RequestMapping("getItemType")
    @ResponseBody
    public Map<String,Object> getItemType(){
        Map<String,Object> map = new HashMap<String, Object>();
        List<ItemType> list = this.itemTypeService.getItemType();
        map.put("itemTypeList", list);
        return map;
    }

}
