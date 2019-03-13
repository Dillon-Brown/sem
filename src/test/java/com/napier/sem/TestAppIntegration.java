package com.napier.sem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class TestAppIntegration {
    static App app;
    static DatabaseFactory dbf;
    static Database db;

    @BeforeAll
    static void init() {
        App app = new App();
        db = dbf.create("mysql");
        db.connect("localhost:33060");
    }

    @Test
    void worldCountriesByPopulationLS() {
        app.worldCountriesByPopulationLS();
    }
}
