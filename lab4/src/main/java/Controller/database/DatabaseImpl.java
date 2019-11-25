package Controller.database;

import org.apache.ibatis.jdbc.ScriptRunner;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseImpl implements Database {
    private static final String DATABASE = "flightradar24";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "lfybkjshf";

    public void createDatabase() {
        Connection conn = null;

        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost/" + DATABASE +
                    "?user=" + USERNAME + "&password=" + PASSWORD + "&serverTimezone=UTC");

            Statement stmt = null;
            if (!conn.isClosed()){
                ScriptRunner runner = new ScriptRunner(conn);
                runner.runScript(new BufferedReader(new FileReader("createSql.sql")));
            }

        } catch (SQLException e) {
            throw new Error("Problem", e);
        } catch (FileNotFoundException e){
            throw new Error("Problem", e);
        }
    }
}
