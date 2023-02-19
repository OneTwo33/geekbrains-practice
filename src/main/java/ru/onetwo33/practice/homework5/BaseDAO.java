package ru.onetwo33.practice.homework5;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class BaseDAO<T> implements IBaseDAO<T> {

    private final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    public void persist(T entity) {
        Transaction transaction = getSession().beginTransaction();
        this.getSession().persist(entity);
        transaction.commit();
    }

    @Override
    public void remove(T persistentInstance) {
        Transaction transaction = getSession().beginTransaction();
        this.getSession().remove(persistentInstance);
        transaction.commit();
    }

    @Override
    public T merge(T detachedInstance) {
        Transaction transaction = getSession().beginTransaction();
        T merge = (T) this.getSession().merge(detachedInstance);
        transaction.commit();
        return merge;
    }

    @Override
    public T findById(Long id, Class<?> persistClass) {
        Transaction transaction = getSession().beginTransaction();
        T find = (T) this.getSession().get(persistClass, id);
        transaction.commit();
        return find;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public Session getSession() {
        if (getSessionFactory().getCurrentSession() == null) {
            return getSessionFactory().openSession();
        } else
            return getSessionFactory().getCurrentSession();
    }

}
