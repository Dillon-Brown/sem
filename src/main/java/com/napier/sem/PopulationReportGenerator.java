package com.napier.sem;

/**
 * Generates queries for capital city reports
 * User inputs are represented by '?' - this will be replaced in prepared statements we'll send to the DB
 */
public class PopulationReportGenerator {
    /**
     * Generates a SQL query to return the population details of a country
     */
    public String GenerateQuery_PopulationDifferencesCountry() {
        return
                "SELECT \n" +
                        "    country.Name \n" +
                        "        AS 'Country', \n" +
                        "    country.Population\n" +
                        "        AS 'Total Population', \n" +
                        "    SUM(city.Population) \n" +
                        "        AS 'Population Living in Cities',\n" +
                        "    (SUM(city.Population) / country.Population) * 100 \n" +
                        "        AS 'Population Living in Cities (%)',\n" +
                        "    country.Population - SUM(city.Population) \n" +
                        "        AS 'Population Not Living in Cities',\n" +
                        "    ((country.Population - SUM(city.Population)) / country.Population) * 100 \n" +
                        "        AS 'Population Not Living in Cities (%)'\n" +
                        "FROM country\n" +
                        "JOIN city ON city.CountryCode = country.Code\n" +
                        "WHERE country.name LIKE ? -- where clause taken from user input\n" +
                        "GROUP BY country.Name, country.Population";
    }

    /**
     * Generates a SQL query to return the population details of a region
     */
    public String GenerateQuery_PopulationDifferencesRegion() {
        return
                "SELECT \n" +
                        "    country.Region\n" +
                        "        AS 'Region', \n" +
                        "    SUM(country.Population)\n" +
                        "        AS 'Total Population', \n" +
                        "    SUM(city.Population) \n" +
                        "        AS 'Population Living in Cities',\n" +
                        "    (SUM(city.Population) / SUM(country.Population)) * 100 \n" +
                        "        AS 'Population Living in Cities (%)',\n" +
                        "    SUM(country.Population) - SUM(city.Population) \n" +
                        "        AS 'Population Not Living in Cities',\n" +
                        "    ((SUM(country.Population) - SUM(city.Population)) / SUM(country.Population)) * 100 \n" +
                        "        AS 'Population Not Living in Cities (%)'\n" +
                        "FROM country\n" +
                        "JOIN city ON city.CountryCode = country.Code\n" +
                        "GROUP BY country.Region\n" +
                        "HAVING country.Region LIKE ? -- having clause taken from user input";
    }

    /**
     * Generates a SQL query to return the population details of a continent
     */
    public String GenerateQuery_PopulationDifferencesContinent() {
        return
                "SELECT \n" +
                        "    country.Continent\n" +
                        "        AS 'Continent', \n" +
                        "    SUM(country.Population)\n" +
                        "        AS 'Total Population', \n" +
                        "    SUM(city.Population) \n" +
                        "        AS 'Population Living in Cities',\n" +
                        "    (SUM(city.Population) / SUM(country.Population)) * 100 \n" +
                        "        AS 'Population Living in Cities (%)',\n" +
                        "    SUM(country.Population) - SUM(city.Population) \n" +
                        "        AS 'Population Not Living in Cities',\n" +
                        "    ((SUM(country.Population) - SUM(city.Population)) / SUM(country.Population)) * 100 \n" +
                        "        AS 'Population Not Living in Cities (%)'\n" +
                        "FROM country\n" +
                        "JOIN city ON city.CountryCode = country.Code\n" +
                        "GROUP BY country.Continent\n" +
                        "HAVING country.Continent LIKE ? -- having clause taken from user input";
    }
}