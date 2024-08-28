package lk.ijse.bo.impl;

import lk.ijse.bo.ItemBo;
import lk.ijse.dao.DaoFactory;
import lk.ijse.dao.ItemDao;
import lk.ijse.dto.ItemDto;
import lk.ijse.entity.Item;

import java.sql.SQLException;
import java.util.ArrayList;

public class ItemBoImpl implements ItemBo {

    ItemDao itemDao = (ItemDao) DaoFactory.getDaoFactory().getDao(DaoFactory.DaoTypes.ITEM);
    @Override
    public boolean saveItem(ItemDto itemDto) throws SQLException {
        return itemDao.save(new Item(itemDto.getId(),itemDto.getName(),itemDto.getQty(),itemDto.getPrice()));
    }

    @Override
    public boolean updateItem(String id, ItemDto itemDto) throws SQLException {
        return itemDao.update( id,(new Item(itemDto.getId(),itemDto.getName(),itemDto.getQty(),itemDto.getPrice())));

    }

    @Override
    public boolean deleteItem(String id) throws SQLException {
        return itemDao.delete(id);
    }

    @Override
    public ArrayList<ItemDto> getAllItems() throws SQLException {
        ArrayList<Item> allItems = itemDao.getAll(); // itemDao eke getAll eken ena data tika arraya ekakata da gannawa
        ArrayList<ItemDto> allItemDtos = new ArrayList<>();//Creates an empty ArrayList to hold ItemDto objects.

        for(Item item : allItems){ //meke backend eken ena nisa enne entity
            allItemDtos.add(new ItemDto(item.getId(),item.getName(),item.getQty(),item.getPrice()));
        }//This loop iterates over each Item object in the allItems list.
        // For each Item, a new ItemDto object is created using the Item's id, name, quantity (qty), and price.
        //The newly created ItemDto is added to the allItemDtos list.

        return allItemDtos;
    }
}
