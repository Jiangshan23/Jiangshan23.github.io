package com.ygj.bean;

public class Item {
    private Integer id;

    private String name;

    private String price;

    private String type;

    private String ondate;

    private String downdate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

   
    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getOndate() {
        return ondate;
    }

    public void setOndate(String ondate) {
        this.ondate = ondate;
    }

    public String getDowndate() {
        return downdate;
    }

    public void setDowndate(String downdate) {
        this.downdate = downdate;
    }


    public Item(Integer id, String name, String price, String type, String ondate, String downdate) {
        super();
        this.id = id;
        this.name = name;
        this.price = price;
        this.type = type;
        this.ondate = ondate;
        this.downdate = downdate;
    }

    public Item() {
        super();
    }

    @Override
    public String toString() {
        return "Item [id=" + id + ", name=" + name + ", price=" + price + ", type=" + type + ", ondate="
                + ondate + ", downdate=" + downdate + "]";
    }

    

}
