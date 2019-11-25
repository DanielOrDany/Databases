package Controller.category;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.sql.*;

public class CategoryImpl implements Category {
    private static final String DATABASE = "flightradar24";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "lfybkjshf";

    public void add(String new_type) {
        Connection conn = null;

        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost/" + DATABASE +
                    "?user=" + USERNAME + "&password=" + PASSWORD + "&serverTimezone=UTC");

            Statement stmt = null;
            if (!conn.isClosed()){
                stmt = conn.createStatement();
                stmt.executeUpdate("INSERT INTO airplane_category (type) VALUES (\'"+ new_type + "\')");
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
            String query = "select * from airplane_category";
            try {
                stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(query);

                JSONArray jsonArray = new JSONArray();

                while (rs.next()) {
                    JSONObject airplane_category = new JSONObject();
                    airplane_category.put("id", rs.getString("id"));
                    airplane_category.put("type", rs.getString("type"));
                    jsonArray.add(airplane_category);
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
            String query = "select * from airplane_category where id =\'" + paramId + " \';";
            try {
                stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(query);

                JSONArray jsonArray = new JSONArray();

                while (rs.next()) {
                    JSONObject airplane_category = new JSONObject();
                    airplane_category.put("id", rs.getString("id"));
                    airplane_category.put("type", rs.getString("type"));
                    jsonArray.add(airplane_category);
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

    public void updateById(int paramId, String newType) {
        Connection conn = null;

        try {

            String url = "jdbc:sqlite:path-to-db-file/chinook/chinook.db";
            conn = DriverManager.getConnection("jdbc:mysql://localhost/" + DATABASE +
                    "?user=" + USERNAME + "&password=" + PASSWORD + "&serverTimezone=UTC");

            String query = "UPDATE airplane_categorys SET type=? WHERE id = ?";

            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setString   (1, newType);
            preparedStmt.setInt      (2, paramId);

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
            String sql = "delete from airplane_category where id =\'" + paramId + " \';";
            try {
                stmt = conn.createStatement();
                stmt.executeUpdate(sql);
                System.out.println("Record deleted successfully");

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
