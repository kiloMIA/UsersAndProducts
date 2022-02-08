package com.company.entities;

public class Product
{
  private int id;
  private String category;
  private String name;
  private int price;



    public Product(String category,String name, int price) {
        setName(name);
        setCategory(category);
        setPrice(price);
    }

    public Product(int id,String category, String name, int price) {
        this(category,name , price);
        setId(id);
    }
    public String getName() {
        return name;
    }
    public int getId() {
        return id;
    }
    public int getPrice() {
        return price;
    }
    public String getCategory() {
        return category;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return id + " " + category + " " + name + " " + price;
    }
}
