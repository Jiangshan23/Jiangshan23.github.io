package com.ygj.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ygj.bean.ItemType;
import com.ygj.dao.ItemTypeDao;
import com.ygj.utils.JDBCUtils;

@Repository
public class ItemTypeDaoImpl implements ItemTypeDao {

    public List<ItemType> getItemType() {
        String sql = "select * from 1701_item_type";
        System.out.println(sql);
        return JDBCUtils.getList(ItemType.class, sql);
    }

}
