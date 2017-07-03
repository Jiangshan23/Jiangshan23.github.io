package com.ygj.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ygj.bean.Item;
import com.ygj.dao.ItemDao;
import com.ygj.utils.JDBCUtils;
import com.ygj.utils.Page;
@Repository
public class ItemDaoImpl implements ItemDao {

    public List<Item> selectAll() {
        String sql = "SELECT item.id id , item.name name,item.price price,item.ondate ondate,item.downdate downdate , itemType.name type from 1701_item item left join 1701_item_type itemType on item.type = itemType.id";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/goods?useUnicode=true&characterEncoding=utf8", "root", "root");
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<Item> list = new ArrayList<Item>();
            while (rs.next()) {
                list.add(new Item(rs.getInt("id"),rs.getString("name"), rs.getString("price"), rs.getString("type"), rs.getString("ondate"), rs.getString("downdate")));
            }
            return list;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
    }

    public int additem(Item item) {
        String sql = "insert into 1701_item set name = '"+item.getName()+"' ,price ="+item.getPrice()+" , type = "+item.getType()+",ondate= '"+item.getOndate()+"' , downdate='"+item.getDowndate()+"'";
        System.out.println(sql);
        int i = JDBCUtils.executeSql(sql);
        return i;
    }

    public Item getItemById(String id) {
        String sql = "select * from 1701_item where id = "+id;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/goods?useUnicode=true&characterEncoding=utf8", "root", "root");
            PreparedStatement ps = conn.prepareStatement(sql);
            System.out.println(sql);
            ResultSet rs = ps.executeQuery();
            Item item = new Item();
            while(rs.next()){
                item = new Item(rs.getInt("id"), rs.getString("name"), rs.getString("price"), rs.getString("type"), rs.getString("ondate"), rs.getString("downdate"));
            }
            return item;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
    }

    public void upditem(Item item) {
        String sql = "update 1701_item set name = '"+item.getName()+"' ,price ="+item.getPrice()+" , type = "+item.getType()+",ondate= '"+item.getOndate()+"' , downdate='"+item.getDowndate()+"' where id = "+item.getId();
        JDBCUtils.executeSql(sql);
        System.out.println(sql);
    }

    public void delItemById(String id) {
        String sql = "delete from 1701_item where id in ("+id+")";
        JDBCUtils.executeSql(sql);
        System.out.println(sql);
    }

    public Integer count(String mohu) {
        String sql = "select count(1) from 1701_item";
        return JDBCUtils.getCount(sql);
    }

    public List<Item> pageList(String mohu, Page page) {
        String sql = "SELECT item.id id , item.name name,item.price price,item.ondate ondate,item.downdate downdate , itemType.name type from 1701_item item left join 1701_item_type itemType on item.type = itemType.id where item.name like '%"+mohu+"%' limit "+page.getStartRecord()+","+page.getPageSize();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/goods?useUnicode=true&characterEncoding=utf8", "root", "root");
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            System.out.println(sql);
            List<Item> list = new ArrayList<Item>();
            while (rs.next()) {
                list.add(new Item(rs.getInt("id"),rs.getString("name"), rs.getString("price"), rs.getString("type"), rs.getString("ondate"), rs.getString("downdate")));
            }
            return list;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
    }

}
