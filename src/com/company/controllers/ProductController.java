package com.company.controllers;

import com.company.entities.Product;
import com.company.entities.User;
import com.company.repositories.ProductRepository;
import com.company.repositories.UserRepository;

import java.util.List;

public class ProductController
{
    private final ProductRepository repo;

    public ProductController(ProductRepository repo)
    {
        this.repo = repo;
    }

    public String create(String category, String name,int price)
    {

        Product product = new Product(category, name, price);

        boolean created = repo.create(product);

        return (created ? "Product was added!" : "Product can't be added!");
    }

    public String get(int id) {
        Product product = repo.get(id);

        return (product == null ? "Product was not found!" : product.toString());
    }

    public String getAll() {
        List<Product> products = repo.getAll();

        return products.toString();
    }

    public String delete(int id)
    {
        Product product = repo.get(id);

        if(product == null)
        {
            return "Product with id " + id + "doesn't exist";
        }
        else
        {
            boolean removed = repo.delete(id);
            if (removed)
                return "Product " + product.getName() + " was removed";
            else
                return "Product cannot be removed!";
        }
    }
}
