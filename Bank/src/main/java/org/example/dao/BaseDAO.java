package org.example.dao;
import jdk.jshell.spi.ExecutionControl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public abstract class BaseDAO<T> {
    protected Connection _connection;
    protected PreparedStatement statement;
    protected String request;
    protected ResultSet resultSet;

    protected BaseDAO(Connection connection) {
        _connection = connection;
    }

    public abstract boolean save(T element) throws SQLException;
    public abstract boolean update(T element) throws SQLException, ExecutionControl.NotImplementedException;
    public abstract boolean delete(T element) throws SQLException, ExecutionControl.NotImplementedException;
    public abstract T get(int id) throws SQLException, ExecutionControl.NotImplementedException;
    public abstract List<T> get() throws SQLException, ExecutionControl.NotImplementedException;
}
