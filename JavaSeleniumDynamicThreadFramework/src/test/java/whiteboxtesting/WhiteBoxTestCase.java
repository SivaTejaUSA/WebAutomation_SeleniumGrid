package whiteboxtesting;

import database.DatabaseReader;

/**
 * WhiteBoxTestCase provides methods for white box testing, 
 * particularly focusing on testing the functionalities of the database interaction.
 */
public class WhiteBoxTestCase {

    /**
     * Validates the number of rows read from a database table against an expected value.
     * This method can be used to verify if the DatabaseReader is correctly reading the specified table.
     *
     * @param expectedRow The expected number of rows that should be present in the table.
     * @param tableName The name of the database table to read from.
     * @return boolean indicating whether the actual number of rows matches the expected number (true) or not (false).
     */
    public static boolean validateDatabaseReader(int expectedRow, String tableName) {
        DatabaseReader reader = new DatabaseReader();
        String[][] data = reader.readTable(tableName);
        return data.length == expectedRow;
    }

}
