package org.example.entity;

public class Operation {
    private long accountNumber;
    private double amount;
    private OperationStatus operationStatus;
    private BankAccount bankAccount;

    public Operation(long accountNumber, double amount, OperationStatus operationStatus) {
        this.accountNumber = accountNumber;
        this.amount = amount;
        this.operationStatus = operationStatus;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public OperationStatus getOperationStatus() {
        return operationStatus;
    }

    public void setOperationStatus(OperationStatus operationStatus) {
        this.operationStatus = operationStatus;
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    @Override
    public String toString() {
        return "Operation => " +
                "accountNumber = " + accountNumber +
                ", amount = " + amount +
                ", operationStatus = " + operationStatus +
                ", bankAccount = " + bankAccount +
                '.';
    }
}
