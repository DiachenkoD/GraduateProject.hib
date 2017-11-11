package com.level.interfaces;

import java.sql.SQLException;
import java.util.Set;

public interface CommunDaoInterface<T> {
    void addObject(T object) throws SQLException;
    void updateObject(T object) throws SQLException;
    T getUserByName(String name) throws SQLException;
    void deleteObject(T object) throws SQLException;
    long getObjectIdByName(String name) throws SQLException;
    T getObjectById(long id)throws SQLException;
    Set<T> getObjectsById(T objects) throws SQLException;
}
