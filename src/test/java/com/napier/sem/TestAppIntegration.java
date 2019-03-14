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
        app = new App();
        db.connect(location);
    }

    @Test
    void worldCountriesByPopulationLS() throws SQLException {
        app.worldCountriesByPopulationLS();
    }
}
