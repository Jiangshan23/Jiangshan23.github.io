package com.ygj.bean;

public class ItemType {
    
    private int id;

    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ItemType(int id, String name) {
        super();
        this.id = id;
        this.name = name;
    }

    public ItemType() {
        super();
    }

    @Override
    public String toString() {
        return "ItemType [id=" + id + ", name=" + name + "]";
    }

}
