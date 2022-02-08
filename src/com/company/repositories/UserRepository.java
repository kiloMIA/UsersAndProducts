package com.company.repositories;

import com.company.data.interfaces.DB;
import com.company.entities.User;
import com.company.repositories.interfaces.EntityRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepository implements EntityRepository<User> {
    private final DB db;

    public UserRepository(DB db) {
        this.db = db;
    }

    @Override
    public User get(int id) {
        User user = null;
        Connection conn = db.getConnection();

        try
        {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM users WHERE id = " + id);
            if (rs.next())
            {
                user = new User(rs.getInt("id"), rs.getString("name"), rs.getString("surname"));
            }
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }

        return user;
    }

    @Override
    public List<User> getAll()
    {
        List<User> users = new ArrayList<>();
        Connection conn = db.getConnection();

        try
        {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM users");
            while (rs.next())
            {
                User user = new User(rs.getInt("id"), rs.getString("name"), rs.getString("surname"));
                users.add(user);
            }
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }

        return users;
    }

    @Override
    public boolean create(User user)
    {
        Connection conn = db.getConnection();

        try
        {
            Statement stmt = conn.createStatement();
            stmt.execute("INSERT INTO users(name, surname) " + "VALUES('" + user.getName() + "','" + user.getSurname() + "')");

            return true;
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean delete(int id)
    {
        Connection conn = db.getConnection();

        try
        {
            Statement stmt = conn.createStatement();
            stmt.execute("DELETE FROM users WHERE id = " + id);

            return true;
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
        return false;
    }
}
