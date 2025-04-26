package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * DatabaseReader provides functionalities to interact with a MYSQL database.
 * It allows reading and updating values in a specified table using JDBC.
 */
public class DatabaseReader {
    // JDBC URL, username and password for database connection
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/QATestingDatabase";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    /**
     * Reads the entire specified table from the database and returns the data as a 2D String array.
     * Each row of the table corresponds to a String array within the returned 2D array.
     * 
     * @param tableName The name of the table to read from the database.
     * @return A 2D String array containing the table data.
     */
    public String[][] readTable(String tableName) {
        List<String[]> dataList = new ArrayList<>();

        // Try-with-resources to ensure that all resources will be closed
        try (Connection conn = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
             PreparedStatement statement = conn.prepareStatement("SELECT * FROM " + tableName);
             ResultSet resultSet = statement.executeQuery()) {

            int colCount = resultSet.getMetaData().getColumnCount();

            // Extract data from ResultSet and store in dataList
            while (resultSet.next()) {
                String[] rowData = new String[colCount];
                for (int i = 1; i <= colCount; i++) {
                    rowData[i - 1] = resultSet.getString(i);
                }
                dataList.add(rowData);
            }
        } catch (SQLException e) {
            // Print stack trace for SQLException
            e.printStackTrace();
        }

        // Convert List to 2D array before returning
        return dataList.toArray(new String[dataList.size()][]);
    }

    /**
     * Retrieves the value of a specified column for a given testcase from the database.
     * 
     * @param tableName The name of the table to query.
     * @param testcase The name of the testcase to filter by.
     * @param columnName The name of the column from which to retrieve the value.
     * @return The value from the specified column and testcase, or an empty string if no value is found.
     */
    public String getValue(String tableName, String testcase, String columnName) {
        // Try-with-resources to ensure that all resources will be closed
        try (Connection conn = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
             PreparedStatement statement = conn.prepareStatement("SELECT " + columnName + " FROM " + tableName + " WHERE TestCaseName = ?")) {

            statement.setString(1, testcase);
            // Execute the query and return the result
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getString(columnName);
                }
            }
        } catch (SQLException e) {
            // Print stack trace for SQLException
            e.printStackTrace();
        }
        return "";
    }

    /**
     * Updates the value of a specified column for a given testcase in the database.
     * 
     * @param tableName The name of the table to update.
     * @param testcase The name of the testcase to filter by.
     * @param columnName The name of the column to update.
     * @param value The new value to set for the specified column.
     */
    public void updateValue(String tableName, String testcase, String columnName, String value) {
        // Try-with-resources to ensure that all resources will be closed
        try (Connection conn = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
             PreparedStatement statement = conn.prepareStatement("UPDATE " + tableName + " SET " + columnName + " = ? WHERE TestCaseName = ?")) {

            statement.setString(1, value);
            statement.setString(2, testcase);
            // Execute the update
            statement.executeUpdate();
        } catch (SQLException e) {
            // Print stack trace for SQLException
            e.printStackTrace();
        }
    }
}
