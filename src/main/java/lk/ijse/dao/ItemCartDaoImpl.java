package lk.ijse.dao;

import lk.ijse.entity.ItemCart;

import java.sql.SQLException;
import java.util.ArrayList;

public class ItemCartDaoImpl implements ItemCartDao {

    static String SAVE_ITEMCART  ="INSERT INTO itemCart (orderId, itemCode, itemName, qty, price,total)VALUES (?, ?, ?, ?, ?,?);";

    @Override
    public boolean save(ItemCart entity) throws SQLException {
        System.out.println(entity.getOrderId());
        System.out.println(entity.getItemCode());
        System.out.println(entity.getItemName());
        System.out.println(entity.getQty());
        System.out.println(entity.getPrice());
        System.out.println("itemCartDaoImpl");
        return SQLUtil.execute(SAVE_ITEMCART,entity.getOrderId(),entity.getItemCode(),entity.getItemName(),entity.getQty(),entity.getPrice(),entity.getTotal());
    }

    @Override
    public boolean update(String id, ItemCart entity) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(String id) throws SQLException {
        return false;
    }

    @Override
    public ArrayList<ItemCart> getAll() throws SQLException {
        return null;
    }
}
