package lk.ijse.bo.impl;

import lk.ijse.bo.ItemBo;
import lk.ijse.bo.SuperBo;
import lk.ijse.dto.CustomerDto;
import lk.ijse.dto.ItemDto;

import java.util.ArrayList;

public class ItemBoImpl implements ItemBo {
    @Override
    public boolean saveItem(ItemDto itemDto) {
        return false;
    }

    @Override
    public boolean updateItem(String id, ItemDto itemDto) {
        return false;
    }

    @Override
    public boolean deleteItem(String id) {
        return false;
    }

    @Override
    public ArrayList<CustomerDto> getAllItems() {
        return null;
    }
}
