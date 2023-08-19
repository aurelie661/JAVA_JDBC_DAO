package org.example.dao;

import org.example.entity.BankAccount;
import org.example.entity.Customer;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BankAccountDAO extends BaseDAO<BankAccount> {


    protected BankAccountDAO(Connection connection) {
        super(connection);
    }

    @Override
    public boolean save(BankAccount element) throws SQLException {
        request ="INSERT INTO bank_account (balance,customer_id,operation_id) VALUES (?,?,?)";
        statement = _connection.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
        statement.setDouble(1, element.getBalance());
        statement.setObject(2, element.getCustomer().getId());
        statement.setObject(3, element.getOperation().getOperationStatus());
        int nbRow = statement.executeUpdate();
        resultSet = statement.getGeneratedKeys();
        if(resultSet.next()){
            element.setId(resultSet.getInt(1));
        }
        return nbRow == 1;
    }

    @Override
    public boolean update(BankAccount element) throws SQLException {
        request = "UPDATE bank_account SET balance = ? WHERE id = ?";
        statement = _connection.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
        statement.setDouble(1,element.getBalance());
        statement.setInt(2, (int) element.getId());
        int row = statement.executeUpdate();
        return row == 1;
    }

    @Override
    public boolean delete(BankAccount element) throws SQLException {
        request = "DELETE FROM bank_account WHERE id = ?";
        statement = _connection.prepareStatement(request);
        statement.setInt(1, (int) element.getId());
        int row = statement.executeUpdate();
        return row == 1;
    }

    @Override
    public BankAccount get(int id) throws SQLException {
        BankAccount bankAccount = null;
        request = "SELECT * FROM bank_account WHERE id = ?";
        statement = _connection.prepareStatement(request);
        statement.setInt(1, id);
        resultSet = statement.executeQuery();
        if(resultSet.next()){
            bankAccount = new BankAccount(resultSet.getInt("id"));
        }
        return bankAccount;
    }

    @Override
    public List<BankAccount> getAll() throws SQLException {
        List<BankAccount> bankAccounts = new ArrayList<>();
        request = "SELECT * FROM bank_account";
        statement = _connection.prepareStatement(request);
        resultSet = statement.executeQuery();
        while (resultSet.next()){
            BankAccount bankAccount = new BankAccount(resultSet.getInt("id"));
            bankAccounts.add(bankAccount);
        }
        return bankAccounts;
    }
}
