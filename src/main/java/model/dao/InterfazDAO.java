package model.dao;

import java.util.List;

public interface InterfazDAO<T> {
    void create(T t);

    List<T> find();

    void update(T t);

    void delete(T t);
}
