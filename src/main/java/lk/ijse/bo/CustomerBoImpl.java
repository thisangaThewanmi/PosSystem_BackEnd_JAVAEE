package lk.ijse.bo;

import lk.ijse.dao.CustomerDao;
import lk.ijse.dao.CustomerDaoImpl;
import lk.ijse.dto.CustomerDto;
import lk.ijse.entity.Customer;

import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerBoImpl implements CustomerBo {

    CustomerDao customerDao = new CustomerDaoImpl();
    @Override
    public boolean saveCustomer(CustomerDto customerDto) throws SQLException {
       return  customerDao.save( new Customer(customerDto.getId(),customerDto.getName(),customerDto.getAddress(),customerDto.getPhone()));
    }

    @Override
    public boolean updateCustomer(String id, CustomerDto customerDto) throws SQLException {
        return customerDao.update(id, new Customer(customerDto.getId(),customerDto.getName(),customerDto.getAddress(),customerDto.getPhone()));
    }

    @Override
    public boolean deleteCustomer(String id) throws SQLException {
        return customerDao.delete(id);
    }

    @Override
    public ArrayList<CustomerDto> getAllCustomer() throws SQLException {
        ArrayList<Customer> allCustomers = customerDao.getAll();
        ArrayList<CustomerDto> customerDtos = new ArrayList<>();

        for (Customer customer : allCustomers) {
            customerDtos.add(new CustomerDto(customer.getId(),customer.getName(),customer.getAddress(),customer.getPhone()));
        }

return customerDtos;
    }
}
