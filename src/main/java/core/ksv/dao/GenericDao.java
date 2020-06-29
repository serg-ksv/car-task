package core.ksv.dao;

import java.util.List;

public interface GenericDao<T> {
    T add(T element);

    T getById(Long id, Class<T> type);

    List<T> getAll(Class<T> type);

    T update(T element);

    T delete(T element);
}
