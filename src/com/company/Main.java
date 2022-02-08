package com.company;

import com.company.controllers.ProductController;
import com.company.controllers.UserController;
import com.company.data.Postgres;
import com.company.data.interfaces.DB;
import com.company.entities.Product;
import com.company.repositories.ProductRepository;
import com.company.repositories.UserRepository;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Hello, choose what you want to work with:");
        System.out.println("1.User management ");
        System.out.println("2.Product management ");
        System.out.println("3.Exit ");
        try
        {
            System.out.print("Enter option (1-3): ");
            int option = scanner.nextInt();
         while(true) {
             if (option == 1) {
                 DB db = new Postgres();
                 UserRepository repo = new UserRepository(db);
                 UserController controller = new UserController(repo);
                 MyApplication app = new MyApplication(controller);
                 app.start();
             } else if (option == 2) {
                 DB DB = new Postgres();
                 ProductRepository Repo = new ProductRepository(DB);
                 ProductController controller = new ProductController(Repo);
                 MyApp app = new MyApp(controller);
                 app.start();
             } else {
                 break;
             }
         }

        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}
