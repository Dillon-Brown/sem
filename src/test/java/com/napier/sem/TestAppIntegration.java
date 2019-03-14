package com.napier.sem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

class TestAppIntegration {
    static App app;
    static DatabaseFactory dbf = new DatabaseFactory();
    static Database db = dbf.create("mysql");
    static String location = "localhost:33060";

    @BeforeAll
    static void init() throws SQLException {
        App app = new App();

        try {
            db.connect(location);
        } catch (SQLException e) {
            System.out.println("Error connecting to database");
            throw new SQLException(e.getMessage());
        }
    }

    @Test
    void worldCountriesByPopulationLS() throws SQLException {
        try {
            app.worldCountriesByPopulationLS();
        } catch (SQLException e) {
            System.out.println("Failed to fetch country");
            throw new SQLException(e.getMessage());
        }
    }
}
