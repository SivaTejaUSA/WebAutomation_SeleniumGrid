package businessrequirementtesting;

import database.DatabaseReader;

/**
 * BusinessRequirementTestCase contains methods for validating business requirements through database testing.
 * It uses the DatabaseReader class to interact with the database and verify the stored data.
 */
public class BusinessRequirementTestCase {

    /**
     * Validates that a specific value in the database matches the expected value.
     * This method is used for verifying if the data stored in the database meets business requirements.
     *
     * @param expectedValue The expected value to be compared with the actual database value.
     * @param tableName The name of the database table to query.
     * @param testCaseName The name of the test case, used as a filter criterion in the query.
     * @param columnName The name of the column in the table where the data is stored.
     * @return boolean indicating whether the actual value in the database matches the expected value (true) or not (false).
     */
    public static boolean validateDataInDatabase(String expectedValue, String tableName, String testCaseName, String columnName) {
        DatabaseReader reader = new DatabaseReader();
        String value = reader.getValue(tableName, testCaseName, columnName);
        return value.equals(expectedValue);
    }

}
