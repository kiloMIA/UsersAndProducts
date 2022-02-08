package com.company;

import com.company.controllers.ProductController;


import java.util.InputMismatchException;
import java.util.Scanner;

public class MyApp
{
    private final ProductController controller;
    private final Scanner scanner;

    public MyApp(ProductController controller)
    {
        this.controller = controller;
        scanner = new Scanner(System.in);
    }

    public void start()
    {

        while (true)
        {
            System.out.println();
            System.out.println("Welcome to My Application");
            System.out.println("Select option:");
            System.out.println("1. Get all products");
            System.out.println("2. Get product by id");
            System.out.println("3. Create product");
            System.out.println("4. Delete product");
            System.out.println("0. Exit");
            System.out.println();
            try
            {
                System.out.print("Enter option (1-4): ");
                int option = scanner.nextInt();
                if (option == 1)
                {
                    getAllProductsMenu();
                }
                else if (option == 2)
                {
                    getProductByIdMenu();
                }
                else if (option == 3)
                {
                    createProductMenu();
                }
                else if( option == 4)
                {
                   deleteProductMenu();
                }
                else
                {
                    break;
                }
            }
            catch (InputMismatchException e)
            {
                System.out.println("Input must be integer");
                scanner.nextLine(); // to ignore incorrect input
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
            }
            System.out.println("*************************");

        }
    }

    public void getAllProductsMenu()
    {
        String response = controller.getAll();
        System.out.println(response);
    }

    public void getProductByIdMenu()
    {
        System.out.println("Please enter id");

        int id = scanner.nextInt();
        String response = controller.get(id);
        System.out.println(response);
    }

    public void createProductMenu() {
        System.out.println("Please enter category");
        String category = scanner.next();
        System.out.println("Please enter name");
        String name = scanner.next();
        System.out.println("Please enter price");
        int price = scanner.nextInt();


        String response = controller.create(category, name,price);
        System.out.println(response);
    }
    public void deleteProductMenu()
    {
        System.out.println("Please enter id");
        int id = scanner.nextInt();
        String response = controller.delete(id);
        System.out.println(response);
    }

}
