package lk.ijse.bo;

import lk.ijse.dto.ItemCartDto;
import lk.ijse.dto.ItemDto;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ItemCartBo extends SuperBo{

    public boolean saveItemCart(ItemCartDto dto) throws SQLException;

    public boolean updateItemCart(String id, ItemCartDto dto) throws SQLException;

    public boolean deleteItemCart(String id) throws SQLException;

    public ArrayList<ItemDto> getAllItemCarts() throws SQLException;
}
