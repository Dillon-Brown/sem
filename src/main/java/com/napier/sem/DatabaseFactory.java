package com.napier.sem;

/**
 * Database factory for creating different types of databases.
 */
class DatabaseFactory {

    /**
     * Database selection method, can be extended to allow different databases.
     *
     * @param type string specify database type
     * @return class
     */
    Database create(String type) {
        if (type.equals("mysql")) {
            return new SqlDatabase();
        } else {
            throw new IllegalArgumentException();
        }
    }
}