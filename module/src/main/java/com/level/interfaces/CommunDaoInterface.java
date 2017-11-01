package com.level.interfaces;

import java.sql.SQLException;

public interface CommunDaoInterface<T> {
    void addObject(T object) throws SQLException;
    void updateObject(T object) throws SQLException;
    T getUserByName(String name) throws SQLException;
    void deleteObject(T object) throws SQLException;
    Long getObjectIdByName(String name) throws SQLException;
    T getObjectById(long id)throws SQLException;
}
