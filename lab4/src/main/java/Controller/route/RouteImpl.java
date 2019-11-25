package Controller.route;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.sql.*;

public class RouteImpl implements Route {
    private static final String DATABASE = "flightradar24";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "lfybkjshf";

    public void add(String new_scheduled_from, String new_scheduled_to, int new_actual, int new_estimated, String new_departure_from, String new_arrival_to, int new_total_distance, int new_passed_distance, String new_date) {
        Connection conn = null;

        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost/" + DATABASE +
                    "?user=" + USERNAME + "&password=" + PASSWORD + "&serverTimezone=UTC");

            Statement stmt = null;
            if (!conn.isClosed()){
                stmt = conn.createStatement();
                stmt.executeUpdate("INSERT INTO route (scheduled_from, scheduled_to, actual, estimated, departure_from, arrival_to, total_distance, passed_distance, date) VALUES (\'"+ new_scheduled_from +"\',\'"+ new_scheduled_to +"\',"+ new_actual +","+ new_estimated +",\'"+ new_departure_from +"\',\'"+ new_arrival_to +"\',"+ new_total_distance +","+ new_passed_distance +",\'"+ new_date +"\')");
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
            String query = "select * from route";
            try {
                stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(query);

                JSONArray jsonArray = new JSONArray();

                while (rs.next()) {
                    JSONObject airline = new JSONObject();
                    airline.put("id", rs.getString("id"));
                    airline.put("scheduled_from", rs.getString("scheduled_from"));
                    airline.put("scheduled_to", rs.getString("scheduled_to"));
                    airline.put("actual", rs.getString("actual"));
                    airline.put("estimated", rs.getString("estimated"));
                    airline.put("departure_from", rs.getString("departure_from"));
                    airline.put("arrival_to", rs.getString("arrival_to"));
                    airline.put("total_distance", rs.getString("total_distance"));
                    airline.put("passed_distance", rs.getString("passed_distance"));
                    airline.put("date", rs.getString("date"));
                    jsonArray.add(airline);
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
            String query = "select * from route where id =\'" + paramId + " \';";
            try {
                stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(query);

                JSONArray jsonArray = new JSONArray();

                while (rs.next()) {
                    JSONObject airline = new JSONObject();
                    airline.put("id", rs.getString("id"));
                    airline.put("scheduled_from", rs.getString("scheduled_from"));
                    airline.put("scheduled_to", rs.getString("scheduled_to"));
                    airline.put("actual", rs.getString("actual"));
                    airline.put("estimated", rs.getString("estimated"));
                    airline.put("departure_from", rs.getString("departure_from"));
                    airline.put("arrival_to", rs.getString("arrival_to"));
                    airline.put("total_distance", rs.getString("total_distance"));
                    airline.put("passed_distance", rs.getString("passed_distance"));
                    airline.put("date", rs.getString("date"));
                    jsonArray.add(airline);
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

    public void updateById(int paramId, String new_scheduled_from, String new_scheduled_to, int new_actual, int new_estimated, String new_departure_from, String new_arrival_to, int new_total_distance, int new_passed_distance, String new_date) {
        Connection conn = null;

        try {

            String url = "jdbc:sqlite:path-to-db-file/chinook/chinook.db";
            conn = DriverManager.getConnection("jdbc:mysql://localhost/" + DATABASE +
                    "?user=" + USERNAME + "&password=" + PASSWORD + "&serverTimezone=UTC");

            String query = "UPDATE route SET scheduled_from = ?, scheduled_to = ?, actual= ?, estimated= ?, departure_from= ?, arrival_to= ?, total_distance= ?, passed_distance= ?, date=? WHERE id = ?";

            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setString   (1, new_scheduled_from);
            preparedStmt.setString   (2, new_scheduled_to);
            preparedStmt.setInt      (3, new_actual);
            preparedStmt.setInt      (4, new_estimated);
            preparedStmt.setString   (5, new_departure_from);
            preparedStmt.setString   (6, new_arrival_to);
            preparedStmt.setInt      (7, new_total_distance);
            preparedStmt.setInt      (8, new_passed_distance);
            preparedStmt.setString   (9, new_date);
            preparedStmt.setInt      (10, paramId);

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
            String sql = "delete from route where id =\'" + paramId + " \';";
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
