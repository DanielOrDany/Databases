package Controller.airplane;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.sql.*;

public class AirplaneImpl implements Airplane {
    private static final String DATABASE = "flightradar24";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "lfybkjshf";

    public void add(String new_name, String new_registration_date, String new_registration_country, String new_serial_number, int new_age, int new_airplane_category_id, int new_airline_id, int new_route_id) {
        Connection conn = null;

        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost/" + DATABASE +
                    "?user=" + USERNAME + "&password=" + PASSWORD + "&serverTimezone=UTC");

            Statement stmt = null;
            if (!conn.isClosed()){
                stmt = conn.createStatement();
                stmt.executeUpdate("INSERT INTO airplane (name, registration_date, registration_country, serial_number, age, airplane_category_id, airline_id, route_id) VALUES (\'"+ new_name +"\',\'"+ new_registration_date +"\',\'"+ new_registration_country +"\',\'"+ new_serial_number +"\',"+ new_age +","+ new_airplane_category_id +","+ new_airline_id +","+ new_route_id + ")");
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
            String query = "select * from airplane";
            try {
                stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(query);

                JSONArray jsonArray = new JSONArray();

                while (rs.next()) {
                    JSONObject airline = new JSONObject();
                    airline.put("id", rs.getString("id"));
                    airline.put("name", rs.getString("name"));
                    airline.put("registrationDate", rs.getString("registration_date"));
                    airline.put("registrationCountry", rs.getString("registration_country"));
                    airline.put("serialNumber", rs.getString("serial_number"));
                    airline.put("age", rs.getString("age"));
                    airline.put("airplaneCategoryId", rs.getString("airplane_category_id"));
                    airline.put("airlineId", rs.getString("airline_id"));
                    airline.put("routeId", rs.getString("route_id"));
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
            String query = "select * from airplane where id =\'" + paramId + " \';";
            try {
                stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(query);

                JSONArray jsonArray = new JSONArray();

                while (rs.next()) {
                    JSONObject airline = new JSONObject();
                    airline.put("id", rs.getString("id"));
                    airline.put("name", rs.getString("name"));
                    airline.put("registrationDate", rs.getString("registration_date"));
                    airline.put("registrationCountry", rs.getString("registration_country"));
                    airline.put("serialNumber", rs.getString("serial_number"));
                    airline.put("age", rs.getString("age"));
                    airline.put("airplaneCategoryId", rs.getString("airplane_category_id"));
                    airline.put("airlineId", rs.getString("airline_id"));
                    airline.put("routeId", rs.getString("route_id"));
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

    public void updateById(int paramId, String new_name, String new_registration_date, String new_registration_country, String new_serial_number, int new_age) {
        Connection conn = null;

        try {

            String url = "jdbc:sqlite:path-to-db-file/chinook/chinook.db";
            conn = DriverManager.getConnection("jdbc:mysql://localhost/" + DATABASE +
                    "?user=" + USERNAME + "&password=" + PASSWORD + "&serverTimezone=UTC");

            String query = "UPDATE airplane SET name = ?, registration_date= ?, registration_country= ?, serial_number= ?, age=?, WHERE id = ?";

            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setString   (1, new_name);
            preparedStmt.setString   (2, new_registration_date);
            preparedStmt.setString   (3, new_registration_country);
            preparedStmt.setString   (4, new_serial_number);
            preparedStmt.setInt      (5, new_age);
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
            String sql = "delete from airplane where id =\'" + paramId + " \';";
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
