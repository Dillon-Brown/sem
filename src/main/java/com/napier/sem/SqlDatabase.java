package com.napier.sem;

import java.sql.*;

public final class SqlDatabase implements Database {
    /**
     * Database driver.
     */
    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    /**
     * Database URL.
     */
    private static final String DB_URL = "jdbc:mysql://";
    /**
     * Database name.
     */
    private static final String DB_NAME = "/world?allowPublicKeyRetrieval=true&useSSL=false";
    /**
     * Database user.
     */
    private static final String DB_USER = "root";
    /**
     * Database password.
     */
    private static final String DB_PASS = "mysql";
    /**
     * Connection to MySQL database.
     */
    private Connection con;
    /**
     * MySQL Statement.
     */
    private Statement stmt;
    /**
     * Database result set.
     */
    private ResultSet rs;

    /**
     * Connect to the MySQL database.
     *
     * @param location string
     * @throws SQLException string
     */
    @Override
    public void connect(String location) throws SQLException {
        if (!isOpened()) {
            try {
                Class.forName(JDBC_DRIVER);
            } catch (ClassNotFoundException e) {
                System.out.println("Could not load SQL driver");
                System.exit(-1);
            }

            int retries = 10;
            for (int i = 0; i < retries; ++i) {
                System.out.println("Connecting to database...");
                try {
                    Thread.sleep(30000);
                    con = DriverManager.getConnection(DB_URL + location + DB_NAME, DB_USER, DB_PASS);
                    System.out.println("Successfully connected");
                    break;
                } catch (SQLException e) {
                    System.out.println("Failed to connect to database attempt " + i);
                    System.out.println(e.getMessage());
                    throw new SQLException(e.getMessage());
                } catch (InterruptedException ie) {
                    System.out.println("Thread interrupted? Should not happen.");
                    Thread.currentThread().interrupt();
                }
            }
        } else {
            System.out.println("Database connection already open.");
        }
    }

    /**
     * Disconnect from the MySQL database.
     *
     * @throws SQLException string
     */
    @Override
    public void disconnect() throws SQLException {
        if (isOpened()) {
            try {
                con.close();
                con = null;
            } catch (SQLException e) {
                System.out.println("Error closing connection to database");
                throw new SQLException(e.getMessage());
            }
        }
    }

    /**
     * Returns database connection status
     *
     * @return bool
     */
    public boolean isOpened() {
        return con != null;
    }

    /**
     * MySQL Query
     *
     * @param query string
     * @return ResultSet
     * @throws SQLException string
     */
    @Override
    public ResultSet query(String query) throws SQLException {
        if (stmt != null) {
            stmt.close();
        }

        if (isOpened()) {
            try {
                stmt = con.createStatement();
                rs = stmt.executeQuery(query);
            } catch (SQLException e) {
                System.out.println(e.getMessage());
                System.out.println("Query Failed");
                throw new SQLException(e.getMessage());
            } finally {
                if (stmt != null) {
                    stmt.close();
                }
            }
        }
        return rs;
    }
}