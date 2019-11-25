package Controller.airline;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.sql.*;

public class AirlineImpl implements Airline {
    private static final String DATABASE = "flightradar24";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "lfybkjshf";

    public void add(int new_partership, String new_name, String new_registration_date, String new_registration_country, int new_company_revenue, int new_owner_id) {
        Connection conn = null;

        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost/" + DATABASE +
                    "?user=" + USERNAME + "&password=" + PASSWORD + "&serverTimezone=UTC");

            Statement stmt = null;
            if (!conn.isClosed()){
                stmt = conn.createStatement();
                stmt.executeUpdate("INSERT INTO airline (partership, name, registration_date, registration_country, company_revenue, owner_id) VALUES ("+ new_partership +",\'"+ new_name +"\',\'"+ new_registration_date +"\',\'"+ new_registration_country +"\',"+ new_company_revenue +","+ new_owner_id + ")");
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
            String query = "select * from airline";
            try {
                stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(query);

                JSONArray jsonArray = new JSONArray();

                while (rs.next()) {
                    JSONObject airline = new JSONObject();
                    airline.put("id", rs.getString("id"));
                    airline.put("partnership", rs.getString("partership"));
                    airline.put("name", rs.getString("name"));
                    airline.put("registrationDate", rs.getString("registration_date"));
                    airline.put("registrationCountry", rs.getString("registration_country"));
                    airline.put("companyRevenue", rs.getString("company_revenue"));
                    airline.put("ownerId", rs.getString("owner_id"));
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
            String query = "select * from airline where id =\'" + paramId + " \';";
            try {
                stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(query);

                JSONArray jsonArray = new JSONArray();

                while (rs.next()) {
                    JSONObject airline = new JSONObject();
                    airline.put("id", rs.getString("id"));
                    airline.put("partnership", rs.getString("partership"));
                    airline.put("name", rs.getString("name"));
                    airline.put("registrationDate", rs.getString("registration_date"));
                    airline.put("registrationCountry", rs.getString("registration_country"));
                    airline.put("companyRevenue", rs.getString("company_revenue"));
                    airline.put("ownerId", rs.getString("owner_id"));
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

    public void updateById(int paramId, int newPartnership, String newName, String newRegDate, String newRegCountry, int newComRevenue) {
        Connection conn = null;

        try {

            String url = "jdbc:sqlite:path-to-db-file/chinook/chinook.db";
            conn = DriverManager.getConnection("jdbc:mysql://localhost/" + DATABASE +
                    "?user=" + USERNAME + "&password=" + PASSWORD + "&serverTimezone=UTC");

            String query = "UPDATE airline SET partership = ?, name = ?, registration_date= ?, registration_country= ?, company_revenue= ? WHERE id = ?";

            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setInt      (1, newPartnership);
            preparedStmt.setString   (2, newName);
            preparedStmt.setString   (3, newRegDate);
            preparedStmt.setString   (4, newRegCountry);
            preparedStmt.setInt   (5, newComRevenue);
            preparedStmt.setInt      (6, paramId);

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
            String sql = "delete from airline where id =\'" + paramId + " \';";
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
