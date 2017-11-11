package com.level.implementation;

import com.level.factory.HibernateSessionFactory;
import com.level.interfaces.CommunDaoInterface;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class CommunDaoImplementation<T> implements CommunDaoInterface<T> {
    @Override
    public void addObject(T object) throws SQLException {
        Session session = null;
        try {
            session = HibernateSessionFactory.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(object);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
          //  JOptionPane.showMessageDialog(null, e.getMessage(), "Error I/O", JOptionPane.OK_OPTION);
            //MUST be dan
        }finally {
            if (session != null & session.isOpen()){
                session.close();
            }
        }
    }

    @Override
    public void updateObject(T object) throws SQLException {
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.update(object);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            //MUST be dan
        }
    }

    @Override
    public T getUserByName(String name) throws SQLException {
        T object = null;
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            Query query = session.createQuery("FROM Seria WHERE seriaName =:paramName");
            query.setParameter("paramName", name);
            object = (T) query.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
            //MUST be dan
        }
        return object;
    }

    @Override
    public void deleteObject(T object) throws SQLException {
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.delete(object);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public long getObjectIdByName(String name) throws SQLException {
        Long idObject = null;
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            Query query = session.createQuery("SELECT idSeria FROM Seria WHERE seriaName =:paramName");
            query.setParameter("paramName", name);
            idObject = (long) query.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
            //MUST be dan
        }
        return idObject;
    }

    @Override
    public T getObjectById(long id) throws SQLException {
        T object = null;
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            Query query = session.createQuery("FROM Seria WHERE idSeria =:paramId");
            query.setParameter("paramId", id);
            object = (T) query.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return object;
    }
    public Set<T> getObjectsById(T object) throws SQLException{
        Set<T> objectsSet = new HashSet<>();
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()){
            objectsSet = (Set<T>) session.createCriteria(Object.class).add(Restrictions.eq("seria", object)).list();
        } catch (Exception e){
            e.printStackTrace();
        }
        return objectsSet;
    }
}
