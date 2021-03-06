package com.company;

import com.company.controllers.ProductController;
import com.company.controllers.UserController;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MyApplication
{
    private final UserController controller;
    private final Scanner scanner;

    public MyApplication(UserController controller)
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
            System.out.println("1. Get all users");
            System.out.println("2. Get user by id");
            System.out.println("3. Create user");
            System.out.println("4. Delete user");
            System.out.println("0. Exit");
            System.out.println();
            try
            {
                System.out.print("Enter option (1-4): ");
                int option = scanner.nextInt();
                if (option == 1)
                {
                    getAllUsersMenu();
                }
                else if (option == 2)
                {
                    getUserByIdMenu();
                }
                else if (option == 3)
                {
                    createUserMenu();
                }
                else if( option == 4)
                {
                    deleteUserMenu();
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

    public void getAllUsersMenu()
    {
        String response = controller.getAll();
        System.out.println(response);
    }

    public void getUserByIdMenu()
    {
        System.out.println("Please enter id");

        int id = scanner.nextInt();
        String response = controller.get(id);
        System.out.println(response);
    }

    public void createUserMenu() {
        System.out.println("Please enter name");
        String name = scanner.next();
        System.out.println("Please enter surname");
        String surname = scanner.next();

        String response = controller.create(name, surname);
        System.out.println(response);
    }
    public void deleteUserMenu()
    {
        System.out.println("Please enter id");
        int id = scanner.nextInt();
        String response = controller.delete(id);
        System.out.println(response);
    }

}
