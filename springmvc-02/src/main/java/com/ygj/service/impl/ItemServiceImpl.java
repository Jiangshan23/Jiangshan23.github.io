package com.ygj.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ygj.bean.Item;
import com.ygj.dao.ItemDao;
import com.ygj.service.ItemService;
import com.ygj.utils.Page;

@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private ItemDao itemDao;

    public List<Item> selectAll() {
        return this.itemDao.selectAll();
    }

    public int additem(Item item) {
        return this.itemDao.additem(item);
    }

    public Item getItemById(String id) {
        return this.itemDao.getItemById(id);
    }

    public void upditem(Item item) {
        this.itemDao.upditem(item);
    }

    public void delItemById(String id) {
        this.itemDao.delItemById(id);
    }

    public Integer count(String mohu) {
        
        return this.itemDao.count(mohu);
    }

    public List<Item> pageList(String mohu, Page page) {
        return this.itemDao.pageList(mohu,page);
    }

}
