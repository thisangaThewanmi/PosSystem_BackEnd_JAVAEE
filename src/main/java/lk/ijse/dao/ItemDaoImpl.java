package lk.ijse.dao;

import lk.ijse.entity.Customer;

import java.util.ArrayList;

public class ItemDaoImpl implements ItemDao {
    @Override
    public boolean save(Customer dto) {
        return false;
    }

    @Override
    public boolean update(String id, Customer dto) {
        return false;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }

    @Override
    public ArrayList<Customer> getAll() {
        return null;
    }
}
