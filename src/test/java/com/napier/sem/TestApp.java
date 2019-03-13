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
        country.Code = "ABW";
        country.Name = "Aruba";
        country.Continent = "North America";
        country.Region = "Caribbean";
        country.SurfaceArea = 193.00f;
        country.IndepYear = 1;
        country.Population = 103000;
        country.LifeExpectancy = 78.4f;
        country.GNP = 828.00f;
        country.GNPOld = 793.00f;
        country.LocalName = "Aruba";
        country.GovernmentForm = "Nonmetropolitan Territory of The Netherlands";
        country.HeadOfState = "Beatrix";
        country.Capital = 129;
        country.Code2 = "AW";

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
