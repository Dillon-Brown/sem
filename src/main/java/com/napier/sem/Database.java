package com.napier.sem;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface Database {

    void connect(String location) throws SQLException;

    void disconnect() throws SQLException;

    boolean isOpened();

    ResultSet query(String query) throws SQLException;
}