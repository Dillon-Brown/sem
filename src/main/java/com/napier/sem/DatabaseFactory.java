package com.napier.sem;

class DatabaseFactory {

    /**
     * Database selection method, can be extended to allow different databases.
     *
     * @param type string specify database type
     * @return class
     */
    Database create(String type) {
        switch (type) {
            case "mysql":
                return new SqlDatabase();
            default:
                throw new IllegalArgumentException();
        }
    }
}