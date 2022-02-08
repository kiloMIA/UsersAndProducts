package com.company.repositories.interfaces;

import com.company.entities.User;

import java.util.List;

public interface EntityRepository<Entity>
{
    Entity get(int id);
    List<Entity> getAll();
    boolean create(Entity entity);
    boolean delete(int id);
}
