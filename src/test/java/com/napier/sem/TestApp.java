package com.napier.sem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class TestApp {
    static App app;

    @BeforeAll
    static void init() {
        app = new App();
    }

    @Test
    void printCountriesNullTest() {
        app.printCountries(null);
    }

    @Test
    void printCountriesTestEmpty() {
        ArrayList<Country> countries = new ArrayList<>();
        app.printCountries(countries);
    }

    @Test
    void printCountriesTestContainsNull() {
        ArrayList<Country> countries = new ArrayList<>();
        countries.add(null);
        app.printCountries(countries);
    }

    @Test
    void printCountriesTest() {
        ArrayList<Country> countries = new ArrayList<>();
        Country country = new Country();
        country.code = "ABW";
        country.name = "Aruba";
        country.continent = "North America";
        country.region = "Caribbean";
        country.surfaceArea = 193.00f;
        country.indepYear = 1;
        country.population = 103000;
        country.lifeExpectancy = 78.4f;
        country.gnp = 828.00f;
        country.gnpOld = 793.00f;
        country.localName = "Aruba";
        country.governmentForm = "Nonmetropolitan Territory of The Netherlands";
        country.headOfState = "Beatrix";
        country.capital = 129;
        country.code2 = "AW";

        countries.add(country);
        app.printCountries(countries);
    }

    @Test
    void getCities() {
    }

    @Test
    void getLanguages() {
    }

    @Test
    void worldPopulation() {
    }

    @Test
    void continentPopulation() {
    }

    @Test
    void regionPopulation() {
    }

    @Test
    void countryPopulation() {
    }

    @Test
    void districtPopulation() {
    }

    @Test
    void cityPopulation() {
    }

    @Test
    void continentCountriesByPopulationLS() {
    }

    @Test
    void regionCountriesByPopulationLS() {
    }

    @Test
    void worldCountriesTopN() {
    }

    @Test
    void continentCountriesTopN() {
    }

    @Test
    void regionCountriesTopN() {
    }

    @Test
    void worldCitiesByPopulationLS() {
    }

    @Test
    void continentCitiesByPopulationLS() {
    }

    @Test
    void regionCitiesByPopulationLS() {
    }

    @Test
    void countryCitiesByPopulationLS() {
    }

    @Test
    void districtCitiesByPopulationLS() {
    }

    @Test
    void worldCitiesTopN() {
    }

    @Test
    void continentCitiesTopN() {
    }

    @Test
    void regionCitiesTopN() {
    }

    @Test
    void countryCitiesTopN() {
    }

    @Test
    void districtCitiesTopN() {
    }

    @Test
    void worldCapitalsByPopulationLS() {
    }

    @Test
    void continentCapitalsByPopulationLS() {
    }

    @Test
    void regionCapitalsByPopulationLS() {
    }

    @Test
    void worldCapitalsTopN() {
    }

    @Test
    void continentCapitalsTopN() {
    }

    @Test
    void regionCapitalsTopN() {
    }

    @Test
    void continentPopulationCitiesandRural() {
    }

    @Test
    void regionPopulationCitiesandRural() {
    }

    @Test
    void countryPopulationCitiesandRural() {
    }
}
