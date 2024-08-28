package lk.ijse.dao;

import lk.ijse.entity.Customer;
import lk.ijse.entity.Item;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



public class ItemDaoImpl implements ItemDao {

    static String SAVE_ITEM = "INSERT INTO item (id,name,qty,price) VALUES (?,?,?,?)";
    static String UPDATE_ITEM = "UPDATE item SET name=?, qty=?, price=? WHERE id=?";
    static String DELETE_ITEM = "DELETE FROM item WHERE id=?";
    static String GET_ALL_ITEM = "SELECT * FROM item";



    @Override
    public boolean save(Item item) throws SQLException {
      return   SQLUtil.execute(SAVE_ITEM, item.getId(),item.getName(),item.getQty(),item.getPrice());
    }

    @Override
    public boolean update(String id, Item item) throws SQLException {
        return   SQLUtil.execute(UPDATE_ITEM,item.getName(),item.getQty(),item.getPrice(),item.getId());

    }

    @Override
    public boolean delete(String id) throws SQLException {
        return   SQLUtil.execute(DELETE_ITEM,id);
    }

    @Override
    public ArrayList<Item> getAll() throws SQLException {

        ResultSet resultSet = SQLUtil.execute(GET_ALL_ITEM);

        ArrayList<Item> items = new ArrayList<>();

        while (resultSet.next()) {
            Item item = new Item(resultSet.getString("id"),resultSet.getString("name"),resultSet.getString("qty"),resultSet.getDouble("price"));
            items.add(item);
        }
        return items;
    }
}
