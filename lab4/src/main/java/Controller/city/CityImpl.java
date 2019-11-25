package Controller.city;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.sql.*;

public class CityImpl implements City {
    private static final String DATABASE = "flightradar24";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "lfybkjshf";

    public void add( String new_name, String new_region, int new_country_id) {
        Connection conn = null;

        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost/" + DATABASE +
                    "?user=" + USERNAME + "&password=" + PASSWORD + "&serverTimezone=UTC");

            Statement stmt = null;
            if (!conn.isClosed()){
                stmt = conn.createStatement();
                stmt.executeUpdate("INSERT INTO city (name, region, country_id) VALUES (\'"+ new_name +"\',\'"+ new_region +"\',"+ new_country_id + ")");
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
            String query = "select * from city";
            try {
                stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(query);

                JSONArray jsonArray = new JSONArray();

                while (rs.next()) {
                    JSONObject city = new JSONObject();
                    city.put("id", rs.getString("id"));
                    city.put("name", rs.getString("name"));
                    city.put("region", rs.getString("region"));
                    city.put("countryId", rs.getString("country_id"));
                    jsonArray.add(city);
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
            String query = "select * from city where id =\'" + paramId + " \';";
            try {
                stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(query);

                JSONArray jsonArray = new JSONArray();

                while (rs.next()) {
                    JSONObject city = new JSONObject();
                    city.put("id", rs.getString("id"));
                    city.put("name", rs.getString("name"));
                    city.put("region", rs.getString("region"));
                    city.put("countryId", rs.getString("country_id"));
                    jsonArray.add(city);
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

    public void updateById(int paramId, String new_name, String new_region) {
        Connection conn = null;

        try {

            String url = "jdbc:sqlite:path-to-db-file/chinook/chinook.db";
            conn = DriverManager.getConnection("jdbc:mysql://localhost/" + DATABASE +
                    "?user=" + USERNAME + "&password=" + PASSWORD + "&serverTimezone=UTC");

            String query = "UPDATE city SET name = ?, region= ? WHERE id = ?";

            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setString   (1, new_name);
            preparedStmt.setString   (2, new_region);
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
            String sql = "delete from city where id =\'" + paramId + " \';";
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
