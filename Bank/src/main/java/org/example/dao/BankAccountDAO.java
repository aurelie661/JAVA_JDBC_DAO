package org.example.dao;

import org.example.entity.BankAccount;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class BankAccountDAO extends BaseDAO<BankAccount> {


    protected BankAccountDAO(Connection connection) {
        super(connection);
    }

    @Override
    public boolean save(BankAccount element) throws SQLException {
        return false;
    }

    @Override
    public boolean update(BankAccount element) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(BankAccount element) throws SQLException {
        return false;
    }

    @Override
    public BankAccount get(int id) throws SQLException {
        return null;
    }

    @Override
    public List<BankAccount> getAll() throws SQLException {
        return null;
    }
}
