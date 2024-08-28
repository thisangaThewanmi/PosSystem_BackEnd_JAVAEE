package lk.ijse.dao;

import lk.ijse.entity.Customer;
import lk.ijse.entity.Orders;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OrderDaoImpl implements OrderDao {

 static String SAVE_ORDER  ="INSERT INTO orders (orderId, orderDate, customerId, customerName, total)VALUES (?, ?, ?, ?, ?);";
    static String UPDATE_ORDER= "UPDATE customer SET orderDate=?, customerId=?, customerName=?, total=? WHERE orderId=?";
    static String GET_CUSTOMER = "SELECT * FROM orders WHERE orderId=?";
    static String DELETE_ORDER= "DELETE FROM orders WHERE orderId=?";
    static String GET_ALL_ORDER = "SELECT * FROM orders";
    @Override
    public boolean save(Orders entity) throws SQLException {
        return SQLUtil.execute(SAVE_ORDER, entity.getOrderId(), entity.getOrderDate(), entity.getCustomerId(), entity.getCustomerName(), entity.getTotal());
    }

    @Override
    public boolean update(String id, Orders entity) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(String id) throws SQLException {
        return SQLUtil.execute(DELETE_ORDER, id);
    }

    @Override
    public ArrayList<Orders> getAll() throws SQLException {
        ResultSet resultSet = SQLUtil.execute(GET_ALL_ORDER);

        ArrayList<Orders> orders = new ArrayList<>();

        while (resultSet.next()) {
            Orders order = new Orders(resultSet.getString("orderId"),resultSet.getDate("orderDate"),resultSet.getString("customerId"),resultSet.getString("customerName"),resultSet.getBigDecimal("total"));
            orders.add(order);
        }

        return orders;


    }
}
