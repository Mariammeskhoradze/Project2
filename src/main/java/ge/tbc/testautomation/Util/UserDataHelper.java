package ge.tbc.testautomation.Util;

import ge.tbc.testautomation.data.MSSQLConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDataHelper {

    public static String[] getUserCredentials(String username) {
        String[] credentials = new String[2];

        try (Connection connect = MSSQLConnection.connect()) {
            String SQL = "SELECT username, password FROM Users WHERE username = ?";
            PreparedStatement statement = connect.prepareStatement(SQL);
            statement.setString(1, username);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                credentials[0] = resultSet.getString("username");
                credentials[1] = resultSet.getString("password");
            } else {
                throw new RuntimeException("User '" + username + "' not found in the database!");
            }
        } catch (SQLException e) {
            throw new RuntimeException("Database error: " + e.getMessage(), e);
        }

        return credentials;
    }
}
