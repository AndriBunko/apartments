package dao;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Andrew on 01.09.2017.
 */
public interface DaoFactory {

    ApartmentsDao getMysqlDao(Connection connection) throws SQLException;
}
