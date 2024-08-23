package lk.ijse.bo;

import lk.ijse.dao.CustomerDaoImpl;
import lk.ijse.dto.CustomerDto;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CustomerBo extends SuperBo{

    public boolean saveCustomer(CustomerDto customerDto) throws SQLException;

    public boolean updateCustomer(String id, CustomerDto customerDto) throws SQLException;

    public boolean deleteCustomer(String id) throws SQLException;

    public ArrayList<CustomerDto> getAllCustomer() throws SQLException;
}
