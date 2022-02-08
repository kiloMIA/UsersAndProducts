package com.company.controllers;

import com.company.entities.User;
import com.company.repositories.UserRepository;

import java.util.List;

public class UserController
{
    private final UserRepository repo;

    public UserController(UserRepository repo)
    {
        this.repo = repo;
    }

    public String create(String name, String surname)
    {

        User user = new User(name, surname);

        boolean created = repo.create(user);

        return (created ? "User was created!" : "User creation was failed!");
    }

    public String get(int id) {
        User user = repo.get(id);

        return (user == null ? "User was not found!" : user.toString());
    }

    public String getAll() {
        List<User> users = repo.getAll();

        return users.toString();
    }

    public String delete(int id)
    {
        User user = repo.get(id);

        if(user == null)
        {
            return "User with id " + id + "doesn't exist";
        }
        else
        {
          boolean removed = repo.delete(id);
            if (removed)
                return "User " + user.getName() + " " + user.getSurname() + " was removed";
            else
                return "User cannot be removed!";
        }
    }
}
