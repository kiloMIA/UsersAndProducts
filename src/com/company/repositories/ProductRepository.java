package com.company.repositories;

import com.company.data.interfaces.DB;
import com.company.entities.Product;
import com.company.repositories.interfaces.IProductRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductRepository implements IProductRepository
{

    private final DB db;

    public ProductRepository(DB db)
    {
        this.db = db;
    }
    @Override
    public Product get(int id) {
        Product product = null;

        Connection conn = db.getConnection();

        try
        {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM products WHERE id = " + id);
            if (rs.next())
            {
                product = new Product(rs.getInt("id"),rs.getString("category"), rs.getString("name"),rs.getInt("price") );
            }
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }

        return product;
    }

    @Override
    public List<Product> getAll()
    {
        List<Product> products = new ArrayList<>();
        Connection conn = db.getConnection();

        try
        {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM products");
            while (rs.next())
            {
                Product product = new Product(rs.getInt("id"),rs.getString("category"), rs.getString("name"), rs.getInt("price"));
                products.add(product);
            }
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }

        return products;
    }

    @Override
    public boolean create(Product product) {
        Connection conn = db.getConnection();

        try
        {
            Statement stmt = conn.createStatement();
            stmt.execute("INSERT INTO products(category,name,price) " + "VALUES('" + product.getCategory() + "','" + product.getName() + "',''" + product.getPrice());

            return true;
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        Connection conn = db.getConnection();

        try
        {
            Statement stmt = conn.createStatement();
            stmt.execute("DELETE FROM products WHERE id = " + id);

            return true;
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public List<Product> getProductsByCaterogry(String category) {
        return null;
    }

    @Override
    public List<Product> getProductsByPriceRange(double min, double max) {
        return null;
    }


  //  @Override
   /* public List<Product> getProductsByCaterogry(String category)
    {
        List<Product> products = new ArrayList<>();
        Connection conn = db.getConnection();
        try
        {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT category FROM products");
            if(category == )
            {

            }
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }

        return products;
    }

    @Override
    public List<Product> getProductsByPriceRange(double min, double max)
    {

    }*/
}
