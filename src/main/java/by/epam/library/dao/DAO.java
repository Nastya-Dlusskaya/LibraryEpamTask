package by.epam.library.dao;

import by.epam.library.model.exception.DAOException;

import java.util.List;

public interface DAO<T> {
    void insert(String table, String... params) throws DAOException;
    void updateByID(String table, String column,String param, int id) throws DAOException;
    void deleteByID(String table, int id) throws DAOException;
}
