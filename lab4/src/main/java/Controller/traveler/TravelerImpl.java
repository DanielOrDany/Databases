package Controller.traveler;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.sql.*;

public class TravelerImpl implements Traveler {
    private static final String DATABASE = "flightradar24";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "lfybkjshf";

    public void add( String new_full_name, String new_email, String new_language, String new_photo_url, String new_subscription_end, String new_plan, String new_start_at, String new_update_at, String new_deleted_at, String new_subscription_start, int new_airplane_id, int new_airline_id) {
        Connection conn = null;

        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost/" + DATABASE +
                    "?user=" + USERNAME + "&password=" + PASSWORD + "&serverTimezone=UTC");

            Statement stmt = null;
            if (!conn.isClosed()){
                stmt = conn.createStatement();
                stmt.executeUpdate("INSERT INTO traveler ( full_name, email, language, photo_url, subscription_end, plan, start_at, updated_at, deleted_at, subscription_start, airplane_id, airline_id) VALUES (\'"+ new_full_name +"\',\'"+ new_email +"\',\'"+ new_language +"\',\'"+ new_photo_url +"\',\'"+ new_subscription_end +"\',\'"+ new_plan +"\',\'"+ new_start_at +"\',\'"+ new_update_at +"\',\'"+ new_deleted_at +"\',\'"+ new_subscription_start +"\',"+ new_airplane_id +","+ new_airline_id +")");
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
            String query = "select * from traveler";
            try {
                stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(query);

                JSONArray jsonArray = new JSONArray();
                while (rs.next()) {
                    JSONObject airline = new JSONObject();
                    airline.put("id", rs.getString("id"));
                    airline.put("full_name", rs.getString("full_name"));
                    airline.put("email", rs.getString("email"));
                    airline.put("language", rs.getString("language"));
                    airline.put("photo_url", rs.getString("photo_url"));
                    airline.put("subscription_end", rs.getString("subscription_end"));
                    airline.put("plan", rs.getString("plan"));
                    airline.put("start_at", rs.getString("start_at"));
                    airline.put("updated_at", rs.getString("updated_at"));
                    airline.put("deleted_at", rs.getString("deleted_at"));
                    airline.put("subscription_start", rs.getString("subscription_start"));
                    airline.put("airplane_id", rs.getString("airplane_id"));
                    airline.put("airline_id", rs.getString("airline_id"));
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
            String query = "select * from traveler where id =\'" + paramId + " \';";
            try {
                stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(query);

                JSONArray jsonArray = new JSONArray();

                while (rs.next()) {
                    JSONObject airline = new JSONObject();
                    airline.put("id", rs.getString("id"));
                    airline.put("full_name", rs.getString("full_name"));
                    airline.put("email", rs.getString("email"));
                    airline.put("language", rs.getString("language"));
                    airline.put("photo_url", rs.getString("photo_url"));
                    airline.put("subscription_end", rs.getString("subscription_end"));
                    airline.put("plan", rs.getString("plan"));
                    airline.put("start_at", rs.getString("start_at"));
                    airline.put("updated_at", rs.getString("updated_at"));
                    airline.put("deleted_at", rs.getString("deleted_at"));
                    airline.put("subscription_start", rs.getString("subscription_start"));
                    airline.put("airplane_id", rs.getString("airplane_id"));
                    airline.put("airline_id", rs.getString("airline_id"));
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

    public void updateById(int paramId, String new_full_name, String new_email, String new_language, String new_photo_url, String new_subscription_end, String new_plan, String new_start_at, String new_update_at, String new_deleted_at, String new_subscription_start) {
        Connection conn = null;

        try {

            String url = "jdbc:sqlite:path-to-db-file/chinook/chinook.db";
            conn = DriverManager.getConnection("jdbc:mysql://localhost/" + DATABASE +
                    "?user=" + USERNAME + "&password=" + PASSWORD + "&serverTimezone=UTC");

            String query = "UPDATE traveler SET full_name = ?, email = ?, language= ?, photo_url= ?, subscription_end= ?, plan= ?, start_at= ?, updated_at= ?, deleted_at= ?, subscription_start= ? WHERE id = ?";

            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setString   (1, new_full_name);
            preparedStmt.setString   (2, new_email);
            preparedStmt.setString   (3, new_language);
            preparedStmt.setString   (4, new_photo_url);
            preparedStmt.setString   (5, new_subscription_end);
            preparedStmt.setString   (6, new_plan);
            preparedStmt.setString   (7, new_start_at);
            preparedStmt.setString   (8, new_update_at);
            preparedStmt.setString   (9, new_deleted_at);
            preparedStmt.setString   (10, new_subscription_start);
            preparedStmt.setInt      (11, paramId);

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
            String sql = "delete from traveler where id =\'" + paramId + " \';";
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
