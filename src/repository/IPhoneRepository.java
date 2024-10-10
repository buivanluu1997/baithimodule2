package repository;

import java.util.List;

public interface IPhoneRepository<T> {
    void add(T entity);

    void writeFile(List<T> list);

    List<T> getAllPhone();

    void delete(T entity);

    T findById(int id);

    List<T> findByName(String name);
}
