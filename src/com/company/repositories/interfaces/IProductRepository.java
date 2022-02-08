package com.company.repositories.interfaces;

import com.company.entities.Product;

import java.util.List;

public interface IProductRepository  extends EntityRepository<Product>
{
    List<Product> getProductsByCaterogry(String category);
    List<Product> getProductsByPriceRange(double min, double max);
}
