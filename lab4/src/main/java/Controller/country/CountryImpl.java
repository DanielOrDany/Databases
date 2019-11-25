package Controller.country;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.sql.*;

public class CountryImpl implements Country {
    private static final String DATABASE = "flightradar24";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "lfybkjshf";

    public void add(String new_name, String new_language) {
        Connection conn = null;

        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost/" + DATABASE +
                    "?user=" + USERNAME + "&password=" + PASSWORD + "&serverTimezone=UTC");

            Statement stmt = null;
            if (!conn.isClosed()){
                stmt = conn.createStatement();
                stmt.executeUpdate("INSERT INTO country (name, language) VALUES (\'"+ new_name +"\',\'"+ new_language + "\')");
            }

        } catch (SQLException e) {
            throw new Error("Problem", e);
        }
    }

    public JSONArray getAll() {
        Connection conn = null;

        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost/" + DATABASE +
                    "?user=" + USERNAME + "&password=" + PASSWORD + "&serverTimezone=UTC");

            Statement stmt = null;
            String query = "select * from country";
            try {
                stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(query);

                JSONArray jsonArray = new JSONArray();

                while (rs.next()) {
                    JSONObject country = new JSONObject();
                    country.put("id", rs.getString("id"));
                    country.put("name", rs.getString("name"));
                    country.put("language", rs.getString("language"));
                    jsonArray.add(country);
                }

                return jsonArray;

            } catch (SQLException e ) {
                throw new Error("Problem", e);
            } finally {
                if (stmt != null) { stmt.close(); }
            }

        } catch (SQLException e) {
            throw new Error("Problem", e);
        }
    }

    public JSONArray getById(int paramId) {
        Connection conn = null;

        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost/" + DATABASE +
                    "?user=" + USERNAME + "&password=" + PASSWORD + "&serverTimezone=UTC");

            Statement stmt = null;
            String query = "select * from country where id =\'" + paramId + " \';";
            try {
                stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(query);

                JSONArray jsonArray = new JSONArray();

                while (rs.next()) {
                    JSONObject country = new JSONObject();
                    country.put("id", rs.getString("id"));
                    country.put("name", rs.getString("name"));
                    country.put("language", rs.getString("language"));
                    jsonArray.add(country);
                }

                return jsonArray;

            } catch (SQLException e ) {
                throw new Error("Problem", e);
            } finally {
                if (stmt != null) { stmt.close(); }
            }

        } catch (SQLException e) {
            throw new Error("Problem", e);
        }
    }

    public void updateById(int paramId, String newName, String newLanguage) {
        Connection conn = null;

        try {

            String url = "jdbc:sqlite:path-to-db-file/chinook/chinook.db";
            conn = DriverManager.getConnection("jdbc:mysql://localhost/" + DATABASE +
                    "?user=" + USERNAME + "&password=" + PASSWORD + "&serverTimezone=UTC");

            String query = "UPDATE airline SET name = ?, language = ? WHERE id = ?";

            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setString   (1, newName);
            preparedStmt.setString   (2, newLanguage);
            preparedStmt.setInt      (3, paramId);

            // execute the java preparedstatement
            preparedStmt.executeUpdate();

        } catch (SQLException e) {
            throw new Error("Problem", e);
        }
    }

    public void deleteById(int paramId) {
        Connection conn = null;

        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost/" + DATABASE +
                    "?user=" + USERNAME + "&password=" + PASSWORD + "&serverTimezone=UTC");

            Statement stmt = null;
            String sql = "delete from country where id =\'" + paramId + " \';";
            try {
                stmt = conn.createStatement();
                stmt.executeUpdate(sql);

            } catch (SQLException e ) {
                throw new Error("Problem", e);
            } finally {
                if (stmt != null) { stmt.close(); }
            }

        } catch (SQLException e) {
            throw new Error("Problem", e);
        }
    }
}
