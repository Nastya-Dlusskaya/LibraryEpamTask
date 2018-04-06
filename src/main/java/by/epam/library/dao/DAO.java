package by.epam.library.dao;

import by.epam.library.model.exception.DAOException;

import java.util.List;

public interface DAO<T> {
    void save(T entity) throws DAOException;
    T findById(int id) throws DAOException;
    List<T> findAll() throws DAOException;
}
