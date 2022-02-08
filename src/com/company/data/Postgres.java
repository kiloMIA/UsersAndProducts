package com.company.data;

import com.company.data.interfaces.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Postgres implements DB
{
    private Connection conn;

    public Postgres() {
        String connectionUrl = "jdbc:postgresql://localhost:5432/SE2112";

        try
        {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(connectionUrl, "postgres", "000");
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("The driver for postgres cannot be found: " + e.getMessage());
        }
    }

    @Override
    public Connection getConnection()
    {
        return conn;
    }

    @Override
    public void close()
    {
        try
        {
            conn.close();
        }
        catch (SQLException e)
        {
            System.out.println("Cannot close the connection: " + e.getMessage());
        }
    }
}
