package lk.ijse.bo;

import lk.ijse.dto.ItemDto;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ItemBo extends SuperBo {

    public boolean saveItem(ItemDto itemDto) throws SQLException;

    public boolean updateItem(String id, ItemDto itemDto) throws SQLException;

    public boolean deleteItem(String id) throws SQLException;

    public ArrayList<ItemDto> getAllItems() throws SQLException;
}
