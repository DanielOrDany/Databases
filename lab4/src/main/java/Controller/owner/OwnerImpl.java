package Controller.owner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.sql.*;

public class OwnerImpl implements Owner {
    private static final String DATABASE = "flightradar24";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "lfybkjshf";

    public void add(String new_full_name, int new_age, String new_live_adress, String new_email, String new_phone, int new_country_id, int new_city_id) {
        Connection conn = null;

        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost/" + DATABASE +
                    "?user=" + USERNAME + "&password=" + PASSWORD + "&serverTimezone=UTC");

            Statement stmt = null;
            if (!conn.isClosed()){
                stmt = conn.createStatement();
                stmt.executeUpdate("INSERT INTO owner (full_name, age, live_adress, email, phone, country_id, city_id) VALUES (\'"+ new_full_name +"\',"+ new_age +",\'"+ new_live_adress +"\',\'"+ new_email +"\',\'"+ new_phone +"\',"+ new_country_id +","+ new_city_id + ")");
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
            String query = "select * from owner";
            try {
                stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(query);

                JSONArray jsonArray = new JSONArray();

                while (rs.next()) {
                    JSONObject owner = new JSONObject();
                    owner.put("id", rs.getString("id"));
                    owner.put("full_name", rs.getString("full_name"));
                    owner.put("age", rs.getString("age"));
                    owner.put("live_adress", rs.getString("live_adress"));
                    owner.put("email", rs.getString("email"));
                    owner.put("phone", rs.getString("phone"));
                    owner.put("country_id", rs.getString("country_id"));
                    owner.put("city_id", rs.getString("city_id"));
                    jsonArray.add(owner);
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
            String query = "select * from owner where id =\'" + paramId + " \';";
            try {
                stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(query);

                JSONArray jsonArray = new JSONArray();

                while (rs.next()) {
                    JSONObject owner = new JSONObject();
                    owner.put("id", rs.getString("id"));
                    owner.put("full_name", rs.getString("full_name"));
                    owner.put("age", rs.getString("age"));
                    owner.put("live_adress", rs.getString("live_adress"));
                    owner.put("email", rs.getString("email"));
                    owner.put("phone", rs.getString("phone"));
                    owner.put("country_id", rs.getString("country_id"));
                    owner.put("city_id", rs.getString("city_id"));
                    jsonArray.add(owner);
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

    public void updateById(int paramId, String new_full_name, int new_age, String new_live_adress, String new_email, String new_phone, int new_country_id, int new_city_id) {
        Connection conn = null;

        try {

            String url = "jdbc:sqlite:path-to-db-file/chinook/chinook.db";
            conn = DriverManager.getConnection("jdbc:mysql://localhost/" + DATABASE +
                    "?user=" + USERNAME + "&password=" + PASSWORD + "&serverTimezone=UTC");

            String query = "UPDATE owner SET full_name = ?, age = ?, live_adress= ?, email= ?, phone= ?, country_id= ? , city_id= ? WHERE id = ?";

            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setString      (1, new_full_name);
            preparedStmt.setInt         (2, new_age);
            preparedStmt.setString      (3, new_live_adress);
            preparedStmt.setString      (4, new_email);
            preparedStmt.setString      (5, new_phone);
            preparedStmt.setInt         (6, new_country_id);
            preparedStmt.setInt         (7, new_city_id);
            preparedStmt.setInt         (8, paramId);

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
            String sql = "delete from owner where id =\'" + paramId + " \';";
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
