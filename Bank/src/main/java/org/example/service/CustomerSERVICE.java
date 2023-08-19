package org.example.service;
import org.example.dao.CustomerDAO;
import org.example.entity.Customer;
import org.example.utils.DatabaseManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class CustomerSERVICE {
    CustomerDAO customerDAO;
    Connection connection;

    public CustomerSERVICE() {
        connection = DatabaseManager.getPostgresSQLConnection();
        customerDAO = new CustomerDAO(connection);
    }
    public boolean createCustomer(String firstName,String lastName,String phoneNumber){
        Customer customer = new Customer(firstName,lastName,phoneNumber);
        try {
            if(customerDAO.save(customer)) {
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }
    public  boolean updateCustomer(Customer customer){
        try {
            if(customerDAO.update(customer)) {
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }
    public boolean deleteCustomer(Customer customer){
        try {
            if(customerDAO.delete(customer)) {
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }
    public Customer getCustomerbyId(long id){
        try {
            return customerDAO.get((int) id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public List<Customer> getAllCustomers(){
        try {
            return customerDAO.getAll();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
