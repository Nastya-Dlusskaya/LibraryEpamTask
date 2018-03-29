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

public class PoolConnection {
    private static final int POOL_SIZE = 10;
    private static final String DATABASE_DRIVER = "com.mysql.jdbc.Driver";
    public static final String URL = "jdbc:mysql://localhost:3306/library";
    public static final String USER = "root";
    public static final String PASSWORD = "12345";

    private final Semaphore semaphore = new Semaphore(POOL_SIZE, true);
    private static final int MAX_TIME = 1;
    private static final Lock LOCK = new ReentrantLock();

    private Queue<Connection> poolConnection = new LinkedList<Connection>();

    private static PoolConnection instance = null;
    private static AtomicBoolean isInstanceExist = new AtomicBoolean(false);

    public PoolConnection() throws SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        initPoolConnection();
    }

    /**
     * Initialize connections pool
     *
     * @throws SQLException
     */
    private void initPoolConnection() throws SQLException {
        Connection connection = null;
        for (int i = 0; i < POOL_SIZE; i++) {
            connection = DriverManager.getConnection(URL,USER, PASSWORD);
            poolConnection.add(connection);
        }
    }

    /**
     * Get connection pool
     *
     * @return instance
     *
     * @throws DAOException
     */
    public static PoolConnection getInstance() throws DAOException {
        if(!isInstanceExist.get()){
            LOCK.lock();
            try{
            if(instance == null){
                    instance = new PoolConnection();
                    isInstanceExist.set(true);
            }
            } catch (ClassNotFoundException|SQLException|IllegalAccessException|InstantiationException e) {
                throw new DAOException(e);
            }finally {
                LOCK.unlock();
            }
        }
        return instance;
    }

    /**
     * Get and delete connection from pool
     *
     * @return connection
     *
     * @throws DAOException
     */
    public Connection getConnection() throws DAOException {
        try {
            if(semaphore.tryAcquire(MAX_TIME, TimeUnit.MINUTES)){
                Connection connection = poolConnection.poll();
                return connection;
            }
        } catch (InterruptedException exception) {
            throw new DAOException(exception);
        }
        throw new DAOException("Time is out");
    }

    /**
     * Add connection to pool
     *
     * @param connectionBD
     */
    public void returnConnection(Connection connectionBD){
        poolConnection.add(connectionBD);
        semaphore.release();
    }

    /**
     * Close all connection in pool
     *
     * @throws DAOException
     */
    public void closePoolConnection() throws DAOException {
        for(Connection connection:poolConnection){
            try {
                connection.close();
            } catch (SQLException e) {
                throw new DAOException(e);
            }
        }
    }
}
