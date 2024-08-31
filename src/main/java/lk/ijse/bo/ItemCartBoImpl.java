package lk.ijse.bo;

import lk.ijse.dao.CustomerDao;
import lk.ijse.dao.DaoFactory;
import lk.ijse.dao.ItemCartDao;
import lk.ijse.dto.CustomerDto;
import lk.ijse.dto.ItemCartDto;
import lk.ijse.dto.ItemDto;
import lk.ijse.entity.Customer;
import lk.ijse.entity.ItemCart;

import java.sql.SQLException;
import java.util.ArrayList;

public class ItemCartBoImpl implements ItemCartBo {

    ItemCartDao itemCartDao = (ItemCartDao) DaoFactory.getDaoFactory().getDao(DaoFactory.DaoTypes.ITEMCART);


    @Override
    public boolean saveItemCart(ItemCartDto dto) throws SQLException {
        return  itemCartDao.save(new ItemCart(dto.getOrderId(),dto.getItemCode(),dto.getItemName(),dto.getQty(),dto.getPrice(),dto.getTotal()));
    }

    @Override
    public boolean updateItemCart(String id, ItemCartDto dto) throws SQLException {
        return false;
    }

    @Override
    public boolean deleteItemCart(String id) throws SQLException {
        return false;
    }

    @Override
    public ArrayList<ItemCartDto> getAllItemCarts() throws SQLException {
        ArrayList<ItemCart> allItems = itemCartDao.getAll();
        ArrayList<ItemCartDto> allItemDtos = new ArrayList<>();

        for (ItemCart itemCart : allItems) {
            allItemDtos.add(new ItemCartDto(itemCart.getOrderId(),itemCart.getItemCode(),itemCart.getItemName(),itemCart.getQty(),itemCart.getPrice(),itemCart.getTotal()));
        }

        return allItemDtos;

    }
}
