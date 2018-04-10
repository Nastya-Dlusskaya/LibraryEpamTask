package by.epam.library.dao;

import by.epam.library.model.exception.DAOException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class AbstractDAO<T> implements DAO {
    private static final String UPDATE_QUERY = "UPDATE ? SET ?=? WHERE id=?";
    private static final String DELETE_QUERY = "DELETE FROM ? WHERE id=?";
    private static final String INSERT_QUERY = "INSERT INTO ? (?) VALUES (?)";
    private static final String FIND_ALL_QUERY = "SELECT * FROM ?";

    protected Connection connection;

    public AbstractDAO() {
    }

    public AbstractDAO(Connection connection) {
        this.connection = connection;
    }

    public Connection getConnection() {
        return connection;
    }

    public abstract T buildEntity(ResultSet resultSet) throws DAOException;


    public T executeObject(String query, Object... parameters) throws DAOException {
        List <T> objects = execute(query, parameters);
        return objects.get(0);
    }

    public List<T> execute(String query, Object... parameters) throws DAOException {
        try (PreparedStatement statement = connection.prepareStatement(query)){
            List<T> entities = new ArrayList<>();

            if(parameters.length > 0){
                insertData(statement, parameters);
            }

            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){
                T order = buildEntity(resultSet);
                entities.add(order);
            }

            return entities;
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    public void change(String query, Object... parameters) throws DAOException {
        try(PreparedStatement statement = connection.prepareStatement(query)) {

            insertData(statement, parameters);

            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException(e.getMessage(), e);
        }
    }

    private void insertData(PreparedStatement statement, Object... parameters) throws DAOException {
            try {
                int countParameters = parameters.length;
                for (int i = 1; i <= countParameters; i++) {
                    statement.setObject(i, parameters[i - 1]);
                }
            } catch (SQLException exception) {
                throw new DAOException(exception.getMessage( ), exception);
            }
    }

}
