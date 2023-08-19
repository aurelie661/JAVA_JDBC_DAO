package org.example.service;

import org.example.dao.BankAccountDAO;
import org.example.entity.BankAccount;
import org.example.entity.Customer;

import java.sql.Connection;
import java.sql.SQLException;

public class BankAccountSERVICE {
    BankAccountDAO bankAccountDAO;
    Connection connection;

    public BankAccountSERVICE(BankAccountDAO bankAccountDAO, Connection connection) {
        this.bankAccountDAO = bankAccountDAO;
        this.connection = connection;
    }

    public boolean createAccount(double balance, Customer customer){
        BankAccount bankAccount = new BankAccount(balance,customer);
        try {
            if(bankAccountDAO.save(bankAccount)) {
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }
}
