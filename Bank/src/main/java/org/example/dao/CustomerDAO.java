package org.example.dao;

import org.example.entity.Customer;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class CustomerDAO extends BaseDAO<Customer> {

    public CustomerDAO(Connection connection) {
        super(connection);
    }

    public boolean save(Customer element) throws SQLException {
        request ="INSERT INTO customer (first_name,last_name,phone_number) VALUES (?,?,?)";
        statement = _connection.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
        statement.setString(1, element.getFirstName());
        statement.setString(2, element.getLastName());
        statement.setString(3, element.getPhoneNumber());
        int nbRow = statement.executeUpdate();
        resultSet = statement.getGeneratedKeys();
        if(resultSet.next()){
            element.setId(resultSet.getInt(1));
        }
        return nbRow == 1;
    }

    public boolean update(Customer element) {
        return false;
    }

    public boolean delete(Customer element) {
        return false;
    }

    public Customer get(int id) {
        return null;
    }

    public List<Customer> getAll() {
        return null;
    }
}
