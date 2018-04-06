package by.epam.library.dao;

import by.epam.library.model.exception.DAOException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConnectionPool {
    private static final int POOL_SIZE = 10;
    private static final String DATABASE_DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/library";
    private static final String USER = "root";
    private static final String PASSWORD = "12345";
    private static final int MAX_TIME = 1;
    private static final Lock LOCK = new ReentrantLock( );
    private static ConnectionPool instance = null;
    private static AtomicBoolean isInstanceExist = new AtomicBoolean(false);
    private final Semaphore semaphore = new Semaphore(POOL_SIZE, true);
    private Queue<Connection> connections = new LinkedList<Connection>( );

    private ConnectionPool() throws SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class.forName(DATABASE_DRIVER).newInstance( );
        initPoolConnection( );
    }

    /**
     * Get connection pool
     *
     * @return instance
     * @throws DAOException
     */
    public static ConnectionPool getInstance() throws DAOException {
        if (!isInstanceExist.get( )) {
            LOCK.lock( );
            try {
                if (instance == null) {
                    instance = new ConnectionPool( );
                    isInstanceExist.set(true);
                }
            } catch (ClassNotFoundException | SQLException | IllegalAccessException | InstantiationException e) {
                throw new DAOException(e);
            } finally {
                LOCK.unlock( );
            }
        }
        return instance;
    }

    /**
     * Initialize connections pool
     *
     * @throws SQLException
     */
    private void initPoolConnection() throws SQLException {
        Connection connection = null;
        for (int i = 0; i < POOL_SIZE; i++) {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            connections.add(connection);
        }
    }

    /**
     * Get and delete connection from pool
     *
     * @return connection
     * @throws DAOException
     */
    public Connection getConnection() throws DAOException {
        try {
            if (semaphore.tryAcquire(MAX_TIME, TimeUnit.MINUTES)) {
                LOCK.lock( );
                Connection connection = connections.poll( );
                return connection;
            }
        } catch (InterruptedException exception) {
            throw new DAOException(exception);
        } finally {
            LOCK.unlock( );
        }
        throw new DAOException("Time is out");
    }

    /**
     * Add connection to pool
     *
     * @param connection
     */
    public void returnConnection(Connection connection) {
        LOCK.lock( );
        connections.add(connection);
        semaphore.release( );
        LOCK.unlock( );
    }

    /**
     * Close all connection in pool
     *
     * @throws DAOException
     */
    public void closePoolConnection() throws DAOException {
        for (Connection connection : connections) {
            try {
                connection.close( );
            } catch (SQLException e) {
                throw new DAOException(e);
            }
        }
    }
}
