package dao;

import entity.Apartment;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

/**
 * Created by andrew on 01.09.2017.
 */
public interface ApartmentsDao {
    void insert(Scanner sc) throws SQLException;
    void delete(Scanner sc) throws SQLException;
    void view()throws SQLException;
    Apartment getById(Scanner sc) throws SQLException;
    List<Apartment> getByDistrict(Scanner sc) throws SQLException;
    List<Apartment> getByAdres(Scanner sc) throws SQLException;
    List<Apartment> getByArea(Scanner sc) throws SQLException;
    List<Apartment> getByPrice(Scanner sc) throws SQLException;
    List<Apartment> getByNunOfRoom(Scanner sc) throws SQLException;




}
