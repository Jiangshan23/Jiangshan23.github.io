package com.ygj.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ygj.bean.ItemType;
import com.ygj.dao.ItemTypeDao;
import com.ygj.service.ItemTypeService;
@Service
public class ItemTypeServiceImpl implements ItemTypeService {

    @Autowired
    private ItemTypeDao itemTypeDao;
    
    public List<ItemType> getItemType() {
        return this.itemTypeDao.getItemType();
    }

}
