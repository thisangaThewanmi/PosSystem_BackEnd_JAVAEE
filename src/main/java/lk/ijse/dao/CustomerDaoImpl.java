package lk.ijse.dao;

import lk.ijse.entity.Customer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerDaoImpl implements CustomerDao {


    static String SAVE_CUSTOMER = "INSERT INTO customer (id,name,address,phone) VALUES (?,?,?,?)";
    static String UPDATE_CUSTOMER = "UPDATE customer SET name=?, address=?, phone=? WHERE id=?";
    static String GET_CUSTOMER = "SELECT * FROM customer WHERE id=?";
    static String DELETE_CUSTOMER = "DELETE FROM customer WHERE id=?";
    static String GET_ALL_CUSTOMER = "SELECT * FROM customer";


    @Override
    public boolean save(Customer customer) throws SQLException {
       return SQLUtil.execute(SAVE_CUSTOMER,customer.getId(),customer.getName(),customer.getAddress(),customer.getPhone());
    }

    @Override
    public boolean update(String id, Customer customer) throws SQLException {
        return SQLUtil.execute(UPDATE_CUSTOMER,customer.getName(),customer.getAddress(),customer.getPhone(),id);
    }

    @Override
    public boolean delete(String id) throws SQLException {
        return SQLUtil.execute(DELETE_CUSTOMER,id);
    }

    @Override
    public ArrayList<Customer> getAll() throws SQLException {
        ResultSet resultSet = SQLUtil.execute(GET_ALL_CUSTOMER);

        ArrayList<Customer> customers = new ArrayList<>();

        while (resultSet.next()) {
            Customer customer = new Customer(resultSet.getString("id"),resultSet.getString("name"),resultSet.getString("address"),resultSet.getString("phone"));
            customers.add(customer);
        }

        return customers;

    }
}
