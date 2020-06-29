package core.ksv.dao.impl;

import core.ksv.dao.GenericDao;
import core.ksv.exception.DataProcessingException;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public abstract class GenericDaoImpl<T> implements GenericDao<T> {
    private final SessionFactory sessionFactory;

    public GenericDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public T add(T element) {
        return manipulateData(element, "create");
    }

    public T getById(Long id, Class<T> type) {
        try (var session = sessionFactory.openSession()) {
            return session.get(type, id);
        } catch (Exception e) {
            throw new DataProcessingException("Can't retrieve element", e);
        }
    }

    public List<T> getAll(Class<T> type) {
        try (var session = sessionFactory.openSession()) {
            var criteriaBuilder = session.getCriteriaBuilder();
            var query = criteriaBuilder.createQuery(type);
            query.from(type);
            return session.createQuery(query).getResultList();
        } catch (Exception e) {
            throw new DataProcessingException("Can't retrieve elements", e);
        }
    }

    public T update(T element) {
        return manipulateData(element, "update");
    }

    public T delete(T element) {
        return manipulateData(element, "delete");
    }

    private T manipulateData(T element, String action) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            switch (action) {
                case "create":
                    session.save(element);
                    break;
                case "update":
                    session.update(element);
                    break;
                case "delete":
                    session.delete(element);
                    break;
                default:
                    throw new DataProcessingException("Something went wrong");
            }
            transaction.commit();
            return element;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("Can't " + action + " " + element, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
