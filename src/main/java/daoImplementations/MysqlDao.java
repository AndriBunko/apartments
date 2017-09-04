package daoImplementations;

import dao.ApartmentsDao;
import entity.Apartment;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Andrew on 01.09.2017.
 */
public class MysqlDao implements ApartmentsDao {
    private  Connection con;

    public MysqlDao(Connection con) throws SQLException {
        this.con = con;
        initDB();
    }

    public void insert(Scanner sc) throws SQLException {

        System.out.println("Enrter district");
        String district = sc.nextLine();

        System.out.println("Enter adress");
        String adress = sc.nextLine();

        System.out.println("Enter area");
        int area = Integer.valueOf(sc.nextLine());

        System.out.println("Enter count of room");
        int numOfRoom = Integer.valueOf(sc.nextLine());

        System.out.println("Enter price");
        int price = Integer.valueOf(sc.nextLine());

        PreparedStatement ps = con.prepareStatement("INSERT INTO Apartments (district, adres, area, num_of_room, price) " +
                                                        "VALUES (?, ?, ?, ?, ?)");
        try {
            ps.setString(1, district);
            ps.setString(2, adress);
            ps.setInt(3, area);
            ps.setInt(4, numOfRoom);
            ps.setInt(5, price);
            ps.executeUpdate();
        }finally {
            ps.close();
        }
    }

    public void delete(Scanner sc) throws SQLException {
        System.out.println("Enter id of apartment");
        int id = Integer.valueOf(sc.nextLine());

        PreparedStatement ps = con.prepareStatement("DELETE FROM Apartments WHERE id = ?");
        try {
            ps.setInt(1, id);
            ps.executeUpdate();
        } finally {
            ps.close();
        }
    }


    public Apartment getById(Scanner sc) throws SQLException {
        System.out.println("Enter apartments id");
        int id = Integer.valueOf(sc.nextLine());

        Apartment apartment;
        PreparedStatement ps = con.prepareStatement("SELECT * FROM Apartments WHERE id = ?");
        try {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            apartment = new Apartment();
            try {
                rs.next();
                apartment = getApartmentsFromLine(apartment, rs);
            }
            finally {
                rs.close();
            }
        } finally {
            ps.close();
        }
        return apartment;
    }

    public List<Apartment> getByDistrict(Scanner sc) throws SQLException {
        System.out.println("Enter apartment district");
        String district = sc.nextLine();
        List<Apartment> list = new ArrayList<Apartment>();

        PreparedStatement ps = con.prepareStatement("SELECT * FROM Apartments WHERE district = ?");
        try {
            ps.setString(1, district);
            ResultSet rs = ps.executeQuery();
            Apartment apartment = new Apartment();
            try {
                while (rs.next()) {
                    getApartmentsFromLine(apartment, rs);
                    list.add(apartment);
                }

            } finally {
                rs.close();
            }
        } finally {
            ps.close();
        }
        return list;
    }

    public List<Apartment> getByAdres(Scanner sc) throws SQLException {
        System.out.println("Enter apartment adres");
        String adres = sc.nextLine();
        List<Apartment> list = new ArrayList<Apartment>();
        Apartment apartment = new Apartment();

        PreparedStatement ps = con.prepareStatement("SELECT * FROM Apartments WHERE adres = ?");
        try {
            ps.setString(1, adres);
            ResultSet rs = ps.executeQuery();
            try {
                while (rs.next()) {
                    getApartmentsFromLine(apartment, rs);
                    list.add(apartment);
                }

            } finally {
                rs.close();
            }
        } finally {
            ps.close();
        }
        return list;
    }

    public List<Apartment> getByArea(Scanner sc) throws SQLException {
        System.out.println("Enter apartment area");
        int area = Integer.valueOf(sc.nextLine());
        List<Apartment> list = new ArrayList<Apartment>();
        Apartment apartment = new Apartment();

        PreparedStatement ps = con.prepareStatement("SELECT * FROM Apartments WHERE area = ?");
        try {
            ps.setInt(1, area);
            ResultSet rs = ps.executeQuery();
            try {
                while (rs.next()) {
                    getApartmentsFromLine(apartment, rs);
                    list.add(apartment);
                }

            } finally {
                rs.close();
            }
        } finally {
            ps.close();
        }
        return list;
    }

    public List<Apartment> getByPrice(Scanner sc) throws SQLException {
        System.out.println("Enter apartment price");
        int price = Integer.valueOf(sc.nextLine());
        List<Apartment> list = new ArrayList<Apartment>();
        Apartment apartment = new Apartment();

        PreparedStatement ps = con.prepareStatement("SELECT * FROM Apartments WHERE price = ?");
        try {
            ps.setInt(1, price);
            ResultSet rs = ps.executeQuery();
            try {
                while (rs.next()) {
                    getApartmentsFromLine(apartment, rs);
                    list.add(apartment);
                }

            } finally {
                rs.close();
            }
        } finally {
            ps.close();
        }
        return list;
    }

    public List<Apartment> getByNunOfRoom(Scanner sc) throws SQLException {
        System.out.println("Enter apartment count of Room");
        int numOfRoom = Integer.valueOf(sc.nextLine());
        List<Apartment> list = new ArrayList<Apartment>();
        Apartment apartment = new Apartment();

        PreparedStatement ps = con.prepareStatement("SELECT * FROM Apartments WHERE price = ?");
        try {
            ps.setInt(1, numOfRoom);
            ResultSet rs = ps.executeQuery();
            try {
                while (rs.next()) {
                    getApartmentsFromLine(apartment, rs);
                    list.add(apartment);
                }

            } finally {
                rs.close();
            }
        } finally {
            ps.close();
        }
        return list;
    }

    public  void view() throws SQLException {
        List<Apartment> list = new ArrayList<Apartment>();

        PreparedStatement ps = con.prepareStatement("SELECT * FROM Apartments");
        try {
            ResultSet rs = ps.executeQuery();
            Apartment apartment = new Apartment();
            try {
                while (rs.next()) {
                    getApartmentsFromLine(apartment, rs);
                    list.add(apartment);
                }

            } finally {
                rs.close();
            }
        } finally {
            ps.close();
        }
        System.out.println(list);
    }

    private void initDB() throws SQLException {
        Statement st = con.createStatement();
        try {
            st.execute("CREATE TABLE IF NOT EXISTS Apartments (id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, district VARCHAR(56) NOT NULL,"+
                    "adres VARCHAR(125) NOT NULL, area INT NOT NULL,num_of_room INT NOT NULL, price INT NOT NULL)");
        } finally {
            st.close();
        }
    }

    private Apartment getApartmentsFromLine(Apartment apartment, ResultSet rs) throws SQLException {
        apartment.setId(rs.getInt(1));
        apartment.setDistrict(rs.getString(2));
        apartment.setAdres(rs.getString(3));
        apartment.setArea(rs.getInt(4));
        apartment.setNumOfRoom(rs.getInt(5));
        apartment.setPrice(rs.getInt(6));
        return apartment;
    }
}
