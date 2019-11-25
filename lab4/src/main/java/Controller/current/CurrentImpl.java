package Controller.current;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.sql.*;

public class CurrentImpl implements Current {

    private static final String DATABASE = "flightradar24";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "lfybkjshf";

    public void add(int new_wind, int new_temperature, float new_latitude, float new_longtitude, int new_vertical_speed, int new_gps_altitude, int new_track, int new_ground_speed, int new_true_speed, int new_indicated_speed, int new_march, int new_calibrated_altitude, int new_icao, int new_squawk, int new_date_time, int new_airplane_id) {
        Connection conn = null;

        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost/" + DATABASE +
                    "?user=" + USERNAME + "&password=" + PASSWORD + "&serverTimezone=UTC");

            Statement stmt = null;
            if (!conn.isClosed()){
                stmt = conn.createStatement();
                stmt.executeUpdate("INSERT INTO current (wind, temperature, latitude, longtitude, vertical_speed, gps_altitude, track, ground_speed, true_speed, indicated_speed, march, calibrated_altitude, icao, squawk, date_time, airplane_id) VALUES ("+ new_wind +","+ new_latitude +","+ new_longtitude +","+ new_vertical_speed +","+ new_gps_altitude +","+ new_track +","+ new_ground_speed +","+ new_true_speed +","+ new_indicated_speed+","+ new_march +","+ new_calibrated_altitude +","+ new_icao +","+ new_squawk  +",\'"+ new_date_time +"\',"+ new_airplane_id + ")");
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
            String query = "select * from current";
            try {
                stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(query);

                JSONArray jsonArray = new JSONArray();

                while (rs.next()) {
                    JSONObject current = new JSONObject();
                    current.put("id", rs.getString("id"));
                    current.put("wind", rs.getString("wind"));
                    current.put("latitude", rs.getString("latitude"));
                    current.put("longtitude", rs.getString("longtitude"));
                    current.put("gpsAltitude", rs.getString("gps_altitude"));
                    current.put("track", rs.getString("track"));
                    current.put("groundSpeed", rs.getString("ground_speed"));
                    current.put("trueSpeed", rs.getString("true_speed"));
                    current.put("indicatedSpeed", rs.getString("indicated_speed"));
                    current.put("march", rs.getString("march"));
                    current.put("calibratedAltitude", rs.getString("calibrated_altitude"));
                    current.put("icao", rs.getString("icao"));
                    current.put("squawk", rs.getString("squawk"));
                    current.put("dateTime", rs.getString("date_time"));
                    current.put("airplaneId", rs.getString("airplane_id"));
                    jsonArray.add(current);
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
            String query = "select * from current where id =\'" + paramId + " \';";
            try {
                stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(query);

                JSONArray jsonArray = new JSONArray();

                while (rs.next()) {
                    JSONObject current = new JSONObject();
                    current.put("id", rs.getString("id"));
                    current.put("wind", rs.getString("wind"));
                    current.put("latitude", rs.getString("latitude"));
                    current.put("longtitude", rs.getString("longtitude"));
                    current.put("gpsAltitude", rs.getString("gps_altitude"));
                    current.put("track", rs.getString("track"));
                    current.put("groundSpeed", rs.getString("ground_speed"));
                    current.put("trueSpeed", rs.getString("true_speed"));
                    current.put("indicatedSpeed", rs.getString("indicated_speed"));
                    current.put("march", rs.getString("march"));
                    current.put("calibratedAltitude", rs.getString("calibrated_altitude"));
                    current.put("icao", rs.getString("icao"));
                    current.put("squawk", rs.getString("squawk"));
                    current.put("dateTime", rs.getString("date_time"));
                    current.put("airplaneId", rs.getString("airplane_id"));
                    jsonArray.add(current);
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

    public void updateById(int paramId, int new_wind, int new_temperature, float new_latitude, float new_longtitude, int new_vertical_speed, int new_gps_altitude, int new_track, int new_ground_speed, int new_true_speed, int new_indicated_speed, int new_march, int new_calibrated_altitude, int new_icao, int new_squawk, int new_date_time) {
        Connection conn = null;

        try {

            String url = "jdbc:sqlite:path-to-db-file/chinook/chinook.db";
            conn = DriverManager.getConnection("jdbc:mysql://localhost/" + DATABASE +
                    "?user=" + USERNAME + "&password=" + PASSWORD + "&serverTimezone=UTC");

            String query = "UPDATE current SET wind, temperature, latitude, longtitude, vertical_speed, gps_altitude, track, ground_speed, true_speed, indicated_speed, march, calibrated_altitude, icao, squawk, date_time WHERE id = ?";

            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setInt      (1, new_wind);
            preparedStmt.setInt      (2, new_temperature);
            preparedStmt.setFloat    (3, new_latitude);
            preparedStmt.setFloat    (4, new_longtitude);
            preparedStmt.setInt      (5, new_vertical_speed);
            preparedStmt.setInt      (6, new_gps_altitude);
            preparedStmt.setInt      (7, new_track);
            preparedStmt.setInt      (8, new_ground_speed);
            preparedStmt.setInt      (9, new_true_speed);
            preparedStmt.setInt      (10, new_indicated_speed);
            preparedStmt.setInt      (11, new_march);
            preparedStmt.setInt      (12, new_calibrated_altitude);
            preparedStmt.setInt      (13, new_icao);
            preparedStmt.setInt      (14, new_squawk);
            preparedStmt.setInt      (15, new_date_time);
            preparedStmt.setInt      (16, paramId);

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
            String sql = "delete from current where id =\'" + paramId + " \';";
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
