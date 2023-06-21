package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PointDao {
    private static final String DATABASE_URL = "jdbc:h2:file:C:/dojo6Data/B4";
    private static final String DATABASE_USER_NAME = "";
    private static final String DATABASE_USER_PASSWORD = "";

    public int getPoints(String user_id) {
        int points = 0;
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USER_NAME, DATABASE_USER_PASSWORD);
            String query = "SELECT login_points FROM user_points WHERE username = ?";
            statement = connection.prepareStatement(query);
            statement.setString(1, user_id);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                points = resultSet.getInt("points");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResultSet(resultSet);
            closeStatement(statement);
            closeConnection(connection);
        }

        return points;
    }

    public void updateLoginPoints(String user_id, int newPoints) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USER_NAME, DATABASE_USER_PASSWORD);
            String query = "UPDATE user_points SET login_points = ? WHERE username = ?";
            statement = connection.prepareStatement(query);
            statement.setInt(1, newPoints);
            statement.setString(2, user_id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeStatement(statement);
            closeConnection(connection);
        }
    }

    private void closeResultSet(ResultSet resultSet) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private void closeStatement(PreparedStatement statement) {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
