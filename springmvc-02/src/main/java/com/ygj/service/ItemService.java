package com.ygj.service;

import java.util.List;

import com.ygj.bean.Item;
import com.ygj.utils.Page;

public interface ItemService {

    List<Item> selectAll();

    int additem(Item item);

    Item getItemById(String id);

    void upditem(Item item);

    void delItemById(String id);

    Integer count(String mohu);

    List<Item> pageList(String mohu, Page page);

}
