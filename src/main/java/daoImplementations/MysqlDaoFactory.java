package daoImplementations;

import dao.ApartmentsDao;
import dao.DaoFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Andrew on 01.09.2017.
 */
public class MysqlDaoFactory implements DaoFactory {

    private static final String dbConnection = "jdbc:mysql://localhost:3306/Apartments";
    private static final String dbUser = "root";
    private static final String dbPassword = "admin";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(dbConnection, dbUser, dbPassword);
    }

    public ApartmentsDao getMysqlDao(Connection connection) throws SQLException {
        return new MysqlDao(connection);
    }
}
