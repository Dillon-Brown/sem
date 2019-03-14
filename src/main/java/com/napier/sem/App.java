package com.napier.sem;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class App {

    static App app;
    static DatabaseFactory dbf = new DatabaseFactory();
    static Database db = dbf.create("mysql");
    static String location = "localhost:33060";

    /**
     * Connect to database and run report.
     *
     * @param args string
     */
    public void main(String[] args) throws SQLException {
        App app = new App();

        try {
            db.connect(location);
        } catch (SQLException e) {
            System.out.println("Error connecting to database");
            throw new SQLException(e.getMessage());
        }

        app.menu();

        try {
            db.disconnect();
        } catch (SQLException e) {
            System.out.println("Error disconnecting from database");
            throw new SQLException(e.getMessage());
        }
    }

    /**
     * Select a report menu
     */
    private void menu() throws SQLException {
        System.out.println("Select a function:");
        System.out.println("1 All the countries in the world organised by largest population to smallest.\n");
        System.out.println("2 All the countries in a continent organised by largest population to smallest.\n");
        System.out.println("3 All the countries in a region organised by largest population to smallest.\n");
        System.out.println("4 The top N populated countries in the world where N is provided by the user.\n");
        System.out.println("5 The top N populated countries in a continent where N is provided by the user.\n");
        System.out.println("6 The top N populated countries in a region where N is provided by the user.\n");
        System.out.println("7 All the cities in the world organised by largest population to smallest.\n");
        System.out.println("8 All the cities in a continent organised by largest population to smallest.\n");
        System.out.println("9 All the cities in a region organised by largest population to smallest.\n");
        System.out.println("10 All the cities in a country organised by largest population to smallest.\n");
        System.out.println("11 All the cities in a district organised by largest population to smallest.\n");
        System.out.println("12 The top N populated cities in the world where N is provided by the user.\n");
        System.out.println("13 The top N populated cities in a continent where N is provided by the user.\n");
        System.out.println("14 The top N populated cities in a region where N is provided by the user.\n");
        System.out.println("15 The top N populated cities in a country where N is provided by the user.\n");
        System.out.println("16 The top N populated cities in a district where N is provided by the user.\n");
        System.out.println("17 All the capital cities in the world organised by largest population to smallest.\n");
        System.out.println("18 All the capital cities in a continent organised by largest population to smallest.\n");
        System.out.println("19 All the capital cities in a region organised by largest to smallest.\n");
        System.out.println("20 The top N populated capital cities in the world where N is provided by the user.\n");
        System.out.println("21 The top N populated capital cities in a continent where N is provided by the user.\n");
        System.out.println("22 The top N populated capital cities in a region where N is provided by the user.\n");
        System.out.println("23 The population of people, people living in cities, and people not living in cities in each continent.\n");
        System.out.println("24 The population of people, people living in cities, and people not living in cities in each region.\n");
        System.out.println("25 The population of people, people living in cities, and people not living in cities in each country.\n");
        System.out.println("26 The population of the world.\n");
        System.out.println("27 The population of a continent.\n");
        System.out.println("28 The population of a region.\n");
        System.out.println("29 The population of a country.\n");
        System.out.println("30 The population of a district.\n");
        System.out.println("31 The population of a city.\n");
        System.out.println("32 Chinese.\n");
        System.out.println("33 English.\n");
        System.out.println("34 Hindi.\n");
        System.out.println("35 Spanish.\n");
        System.out.println("361 Arabic.\n");

        Scanner input = new Scanner(System.in);
        int i = input.nextInt();

        if (i == 1) {
            try {
                System.out.println("All countries by population from largest to smallest:\n");
                ArrayList<Country> worldCountries = this.worldCountriesByPopulationLS();
                this.printCountries(worldCountries);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println("Failed to fetch country");
                throw new SQLException(e.getMessage());
            }
        } else if (i == 2) {
            try {
                System.out.println("Select a continent:");
                String continent = input.next();
                System.out.println("All the countries in a continent organised by largest population to smallest:\n");
                ArrayList<Country> continentCountries = this.continentCountriesByPopulationLS(continent);
                this.printCountries(continentCountries);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println("Failed to fetch country");
                throw new SQLException(e.getMessage());
            }
        } else if (i == 3) {
            try {
                System.out.println("Select a region:");
                String region = input.next();
                System.out.println("All the countries in a region organised by largest population to smallest.\n:\n");
                ArrayList<Country> regionCountries = this.regionCountriesByPopulationLS(region);
                this.printCountries(regionCountries);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println("Failed to fetch country");
                throw new SQLException(e.getMessage());
            }
        }
    }

    /**
     * Prints countries.
     *
     * @param countries countries to print.
     */
    void printCountries(ArrayList<Country> countries) {
        if (countries != null) {
            System.out.println(String.format("%-10s %-15s %-20s", "Name", "Continent", "Population"));
            for (Country country : countries) {
                if (country == null) {
                    continue;
                }
                String formattedString =
                        String.format("%-10s %-15s %-20s",
                                country.name, country.continent, country.population);
                System.out.println(formattedString);
            }
        } else {
            System.out.println("No countries");
        }
    }

    /**
     * The population of the world.
     *
     * @return
     */
    public ArrayList<Country> worldPopulation() {
        return null;
    }

    /**
     * The population of a continent.
     *
     * @return
     */
    public ArrayList<Country> continentPopulation(String continent) {
        return null;
    }

    /**
     * The population of a region.
     *
     * @return
     */
    public ArrayList<Country> regionPopulation(String region) {
        return null;
    }

    /**
     * The population of a country.
     *
     * @return
     */
    public ArrayList<Country> countryPopulation(String country) {
        return null;
    }

    /**
     * The population of a district.
     *
     * @return
     */
    public ArrayList<Country> districtPopulation(String district) {
        return null;
    }

    /**
     * The population of a city.
     *
     * @return
     */
    public ArrayList<Country> cityPopulation(String city) {
        return null;
    }

    /**
     * All the countries in the world organised by largest population to smallest.
     *
     * @return countries ArrayList
     * @throws SQLException string
     */
    ArrayList<Country> worldCountriesByPopulationLS() throws SQLException {
        try {
            String query =
                    "SELECT Name, Continent, Population "
                            + "FROM country "
                            + "ORDER BY Population DESC";

            ResultSet results = db.query(query);
            ArrayList<Country> countries = new ArrayList<>();
            while (results.next()) {
                Country country = new Country();
                country.code = results.getString("Code");
                country.name = results.getString("Name");
                country.population = results.getInt("Population");
                countries.add(country);
            }
            return countries;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to fetch country");
            throw new SQLException(e.getMessage());
        }
    }

    /**
     * All the countries in a continent organised by largest population to smallest.
     *
     * @param continent string
     * @return countries ArrayList
     * @throws SQLException string
     */
    ArrayList<Country> continentCountriesByPopulationLS(String continent) throws SQLException {
        try {
            ArrayList<Country> countries = new ArrayList<>();
            String query =
                    "SELECT Name, Continent, Population "
                            + "FROM country "
                            + "WHERE Continent = '" + continent + "' "
                            + "ORDER BY Population DESC  ";
            ResultSet results = db.query(query);
            while (results.next()) {
                Country country = new Country();
                country.code = results.getString("Code");
                country.name = results.getString("Name");
                country.continent = results.getString("Continent");
                country.population = results.getInt("Population");
                countries.add(country);
            }
            return countries;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to fetch country");
            throw new SQLException(e.getMessage());
        }
    }

    /**
     * All the countries in a region organised by largest population to smallest
     *
     * @param region string
     * @return countries ArrayList
     * @throws SQLException string
     */
    ArrayList<Country> regionCountriesByPopulationLS(String region) throws SQLException {
        try {
            ArrayList<Country> countries = new ArrayList<>();
            String query =
                    "SELECT Name, Continent, Population "
                            + "FROM country "
                            + "WHERE Region = '" + region + "' "
                            + "ORDER BY Population DESC  ";
            ResultSet results = db.query(query);
            while (results.next()) {
                Country country = new Country();
                country.code2 = results.getString("Code");
                country.name = results.getString("Name");
                country.continent = results.getString("Continent");
                country.region = results.getString("Region");
                country.population = results.getInt("Population");
                countries.add(country);
            }
            return countries;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to fetch country");
            throw new SQLException(e.getMessage());
        }
    }

    /**
     * The top N populated countries in the world where N is provided by the user.
     *
     * @return
     */
    public ArrayList<Country> worldCountriesTopN(int n) {
        return null;
    }

    /**
     * The top N populated countries in a continent where N is provided by the user.
     *
     * @return
     */
    public ArrayList<Country> continentCountriesTopN(int n) {
        return null;
    }

    /**
     * The top N populated countries in a region where N is provided by the user.
     *
     * @return
     */
    public ArrayList<Country> regionCountriesTopN(int n) {
        return null;
    }

    /**
     * All the cities in the world organised by largest population to smallest.
     *
     * @return
     */
    public ArrayList<City> worldCitiesByPopulationLS() {
        return null;
    }

    /**
     * All the cities in a continent organised by largest population to smallest.
     *
     * @return
     */
    public ArrayList<City> continentCitiesByPopulationLS() {
        return null;
    }

    /**
     * All the cities in a region organised by largest population to smallest.
     *
     * @return
     */
    public ArrayList<City> regionCitiesByPopulationLS() {
        return null;
    }

    /**
     * All the cities in a country organised by largest population to smallest.
     *
     * @return
     */
    public ArrayList<City> countryCitiesByPopulationLS() {
        return null;
    }

    /**
     * All the cities in a district organised by largest population to smallest.
     *
     * @return
     */
    public ArrayList<City> districtCitiesByPopulationLS() {
        return null;
    }

    /**
     * The top N populated cities in the world where N is provided by the user.
     *
     * @return
     */
    public ArrayList<City> worldCitiesTopN(int n) {
        return null;
    }

    /**
     * The top N populated cities in a continent where N is provided by the user.
     *
     * @return
     */
    public ArrayList<City> continentCitiesTopN(int n) {
        return null;
    }

    /**
     * The top N populated cities in a region where N is provided by the user.
     *
     * @return
     */
    public ArrayList<City> regionCitiesTopN(int n) {
        return null;
    }

    /**
     * The top N populated cities in a country where N is provided by the user.
     *
     * @return
     */
    public ArrayList<City> countryCitiesTopN(int n) {
        return null;
    }

    /**
     * The top N populated cities in a district where N is provided by the user.
     *
     * @return
     */
    public ArrayList<City> districtCitiesTopN(int n) {
        return null;
    }

    /**
     * All the capital cities in the world organised by largest population to smallest.
     *
     * @return
     */
    public ArrayList<City> worldCapitalsByPopulationLS() {
        return null;
    }

    /**
     * All the capital cities in a continent organised by largest population to smallest.
     *
     * @return
     */
    public ArrayList<City> continentCapitalsByPopulationLS() {
        return null;
    }

    /**
     * All the capital cities in a region organised by largest to smallest.
     *
     * @return
     */
    public ArrayList<City> regionCapitalsByPopulationLS() {
        return null;
    }

    /**
     * The top N populated capital cities in the world where N is provided by the user.
     *
     * @return
     */
    public ArrayList<City> worldCapitalsTopN(int n) {
        return null;
    }

    /**
     * The top N populated capital cities in a continent where N is provided by the user.
     *
     * @return
     */
    public ArrayList<City> continentCapitalsTopN(int n) {
        return null;
    }

    /**
     * The top N populated capital cities in a region where N is provided by the user.
     *
     * @return
     */
    public ArrayList<City> regionCapitalsTopN(int n) {
        return null;
    }

    /**
     * The population of people, people living in cities, and people not living in cities in each continent.
     *
     * @return
     */
    public ArrayList<City> continentPopulationCitiesandRural() {
        return null;
    }

    /**
     * The population of people, people living in cities, and people not living in cities in each region.
     *
     * @return
     */
    public ArrayList<City> regionPopulationCitiesandRural() {
        return null;
    }

    /**
     * The population of people, people living in cities, and people not living in cities in each country.
     *
     * @return
     */
    public ArrayList<City> countryPopulationCitiesandRural() {
        return null;
    }
}
