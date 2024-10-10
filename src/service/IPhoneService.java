package service;

import java.util.List;

public interface IPhoneService <T>{
    void add(T entity);

    List<T> getAllPhone();

    void delete(T entity);

    T findById(int id);

    List<T> findByName(String name);
}
