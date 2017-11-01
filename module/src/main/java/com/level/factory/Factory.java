package com.level.factory;

import com.level.implementation.CommunDaoImplementation;

public class Factory<T> {
    private CommunDaoImplementation<T> userDAO = null;

    private Factory<T> instance = null;

    public synchronized Factory<T> getInstance() {
        if (instance == null) {
            instance = new Factory();
        }
        return instance;
    }

    public CommunDaoImplementation<T> getUserDAO() {
        if (userDAO == null) {
            userDAO = new CommunDaoImplementation<>();
        }
        return userDAO;
    }

}
