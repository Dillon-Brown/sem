package com.napier.sem;

import java.sql.Connection;
import java.sql.ResultSet;

public interface Database {
    void connect(String location);

    void disconnect();

    ResultSet query(String query);
}