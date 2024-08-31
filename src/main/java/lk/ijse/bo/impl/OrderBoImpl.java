package lk.ijse.bo.impl;

import com.mysql.cj.x.protobuf.MysqlxCrud;
import lk.ijse.bo.OrderBo;
import lk.ijse.dao.DaoFactory;
import lk.ijse.dao.OrderDao;
import lk.ijse.dto.OrderDto;
import lk.ijse.entity.Orders;

import java.sql.SQLException;
import java.util.ArrayList;

public class OrderBoImpl implements OrderBo {
    
    OrderDao orderDao = (OrderDao) DaoFactory.getDaoFactory().getDao(DaoFactory.DaoTypes.ORDER);
    @Override
    public boolean saveOrder(OrderDto dto) throws SQLException {
        System.out.println("boimpl ekata awa");
        return  orderDao.save(new Orders(dto.getOrderID(),dto.getOrderDate(), dto.getCustomerId(),dto.getCustomerName(),dto.getTotal(),dto.getDiscount(),dto.getSubTotal()));

    }

    @Override
    public boolean updateOrder(String id, OrderDto dto) throws SQLException {
        return false;
    }

    @Override
    public boolean deleteOrder(String id) throws SQLException {
       return orderDao.delete(id);
    }

    @Override
    public ArrayList<OrderDto> getAllOrders() throws SQLException {
        ArrayList<Orders> allOrders = orderDao.getAll();

        ArrayList<OrderDto> orderDtos = new ArrayList<>();
        for (Orders order : allOrders) {
            OrderDto orderDto = new OrderDto(order.getOrderID(),order.getOrderDate(),order.getCustomerId(),order.getCustomerName(),order.getTotal(),order.getDiscount(),order.getSubtotal());
            orderDtos.add(orderDto);
        }
        return orderDtos;
    }
}
