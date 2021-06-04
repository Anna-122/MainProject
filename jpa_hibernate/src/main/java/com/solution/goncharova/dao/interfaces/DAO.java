package com.solution.goncharova.dao.interfaces;
import java.util.List;


/**
 * Interface {@code DAO} in package {@code com.solution.goncharova.dao.interfaces}
 * @param <Entity> instance of table
 * @param <Key> id of instance
 */
public interface DAO<Entity, Key> {
    void create(Entity model);
    List<Entity> findAll();
    Entity find(Key key);
    void update(Entity model);
    void delete(Entity model);
}