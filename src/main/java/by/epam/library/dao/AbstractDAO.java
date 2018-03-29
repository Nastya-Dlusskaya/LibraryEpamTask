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

    @Override
    public void insert(String table, String... params) throws DAOException {
        int countColumns = params.length;
        int indexParameters = countColumns / 2 - 1;

        StringBuilder columns = new StringBuilder();
        StringBuilder parameters = new StringBuilder();

        for (int i = 0; i < countColumns / 2; i++) {
            columns.append(params[i]).append(", ");
            parameters.append(params[i + indexParameters]).append(", ");
        }

        int lastIndexInColumn = columns.lastIndexOf(",");
        columns.deleteCharAt(lastIndexInColumn);

        int lastIndexInParameters = parameters.lastIndexOf(",");
        parameters.deleteCharAt(lastIndexInParameters);

        try {
            PreparedStatement statement = connection.prepareStatement(INSERT_QUERY);
            statement.setString(1, table);
            statement.setString(2, columns.toString( ));
            statement.setString(3, Arrays.toString(params));
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException(e);
        }

    }

    @Override
    public void updateByID(String table, String column,String param, int id) throws DAOException {

        try {
            PreparedStatement statement = connection.prepareStatement(UPDATE_QUERY);
            statement.setString(1, table);
            statement.setString(2, column);
            statement.setString(3, param);
            statement.setInt(4, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    @Override
    public void deleteByID(String table, int id) throws DAOException {
        try {
            PreparedStatement statement = connection.prepareStatement(DELETE_QUERY);
            statement.setString(1, table);
            statement.setInt(2, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    public T executeObject(String query) throws DAOException {
        List <T> objects = execute(query);
        return objects.get(0);
    }

    public List<T> execute(String query) throws DAOException {
        try (PreparedStatement statement = connection.prepareStatement(query)){
            List<T> entities = new ArrayList<>();

            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){
                T order =buildEntity(resultSet);
                entities.add(order);
            }

            return entities;
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    public abstract T buildEntity(ResultSet resultSet) throws DAOException;
}
