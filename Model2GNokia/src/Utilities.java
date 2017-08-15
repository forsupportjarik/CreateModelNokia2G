import org.apache.ibatis.jdbc.ScriptRunner;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Utilities {

    public static Connection returnConnection() throws SQLException, ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/GSM", "postgres",
                "parafin");
        return connection;
    }

    public static void runInitDb(Connection connection) throws ClassNotFoundException, SQLException {

        String path = "C:\\Users\\yakovalenko\\IdeaProjects\\CreateModelNokia2G\\scripts\\";
        String scriptName = "initDB.sql";

        try {
            ScriptRunner scriptRunner = new ScriptRunner(connection);
            Reader reader = new BufferedReader(new FileReader(path + scriptName));
            scriptRunner.runScript(reader);
            reader.close();
            connection.close();
        } catch (Exception e) {
            System.err.println("Failed to Execute" + scriptName + " The error is " + e.getMessage());
        }
    }


    public static void loadToDbData(Connection connection) throws SQLException {

        Statement statement = connection.createStatement();

        String path = "'C:\\DATA\\PROGRAMMING\\filesToHide\\BTS_ID&TRX_ID.csv'";

        statement.executeUpdate("COPY ids FROM" + path + "(DELIMITER ',')");

        System.out.println("Data from " + path + " to database is imported");

    }
}
