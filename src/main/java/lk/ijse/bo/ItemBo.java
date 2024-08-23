package lk.ijse.bo;

import lk.ijse.dto.CustomerDto;
import lk.ijse.dto.ItemDto;

import java.io.Serializable;
import java.util.ArrayList;

public interface ItemBo extends SuperBo {

    public boolean saveItem(ItemDto itemDto);

    public boolean updateItem(String id, ItemDto itemDto);

    public boolean deleteItem(String id);

    public ArrayList<CustomerDto> getAllItems();
}
