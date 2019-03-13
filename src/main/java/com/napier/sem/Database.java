package com.napier.sem;

import java.sql.Connection;
import java.sql.ResultSet;

public interface Database {

    /**
     * Connection to MySQL database.
     */
    Connection con = null;

    void connect(String location);

    void disconnect();

    ResultSet query(String query);
}