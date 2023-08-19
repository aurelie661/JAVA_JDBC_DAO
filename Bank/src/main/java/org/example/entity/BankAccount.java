package org.example.entity;

public class BankAccount {
    private long id;
    private double balance;
    private Customer customer;
    private Operation operation;

    public BankAccount(double balance, Customer customer) {
        this.balance = balance;
        this.customer = customer;
    }

    public BankAccount() {
    }

    public BankAccount(double balance) {
        this.balance = balance;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    @Override
    public String toString() {
        return "BankAccount => " +
                "id = " + id +
                ", balance = " + balance +
                ", customer = " + customer +
                ", operation = " + operation +
                '.';
    }
}
