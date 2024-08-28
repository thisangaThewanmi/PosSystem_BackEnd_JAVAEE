package lk.ijse.bo;

import lk.ijse.dto.ItemDto;
import lk.ijse.dto.OrderDto;

import java.sql.SQLException;
import java.util.ArrayList;

public interface OrderBo extends SuperBo {

    boolean saveOrder(OrderDto dto ) throws SQLException;


    public boolean updateOrder(String id, OrderDto dto) throws SQLException;

    public boolean deleteOrder(String id) throws SQLException;

    public ArrayList<OrderDto> getAllOrders() throws SQLException;
}
