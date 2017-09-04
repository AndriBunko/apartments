import dao.ApartmentsDao;
import dao.DaoFactory;
import daoImplementations.MysqlDaoFactory;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * Created by Andrew on 01.09.2017.
 */
public class Main {

    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);
        DaoFactory df = new MysqlDaoFactory();
        Connection connection = MysqlDaoFactory.getConnection();
        try {
            ApartmentsDao mysqlDao = df.getMysqlDao(connection);

            while (true) {
                System.out.println("1: add apartment");
                System.out.println("2: delete apartment by id");
                System.out.println("3: get apartment by id");
                System.out.println("4: get apartments by district");
                System.out.println("5: get apartments by adres");
                System.out.println("6: get apartments by area");
                System.out.println("7: get apartments by count of room");
                System.out.println("8: get apartments by price");
                System.out.println("9: view apartments");
                System.out.print("-> ");

                String s = sc.nextLine();
                switch (s) {
                    case "1":
                        mysqlDao.insert(sc);
                        break;
                    case "2":
                        mysqlDao.delete(sc);
                        break;
                    case "3":
                        System.out.println(mysqlDao.getById(sc));
                        break;
                    case "4":
                        System.out.println(mysqlDao.getByDistrict(sc));
                        break;
                    case "5":
                        System.out.println(mysqlDao.getByAdres(sc));
                        break;
                    case "6":
                        System.out.println(mysqlDao.getByArea(sc));
                        break;
                    case "7":
                        System.out.println(mysqlDao.getByNunOfRoom(sc));
                        break;
                    case "8":
                        System.out.println(mysqlDao.getByPrice(sc));
                        break;
                    case "9":
                        mysqlDao.view();
                        break;
                    default:
                        return;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) connection.close();
        }
    }
}