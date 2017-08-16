import org.apache.ibatis.jdbc.ScriptRunner;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Utilities {

    public static File createFile(String path) {
        File file = null;
        try {
            file = new File(path);
            boolean fvar = file.createNewFile();
            if (fvar) {
                System.out.println("File has been created successfully");
            } else {
                System.out.println("File already present at the specified location");
            }
        } catch (IOException e) {
            System.out.println("Exception Occurred:");
            e.printStackTrace();
        }
        return file;
    }

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


    public static void loadToDbDataForTrx(Connection connection, String path) throws SQLException, ClassNotFoundException {

        Statement statement = connection.createStatement();

        statement.executeUpdate("COPY idstrx FROM " + path + " (DELIMITER ',')");

        connection.close();

        System.out.println("Data from " + path + " to database is imported");

    }

    public static void loadToDbDataForBTS(Connection connection, String path) throws SQLException, ClassNotFoundException {
        Statement statement = connection.createStatement();

        statement.executeUpdate("COPY idsbts FROM " + path + " (DELIMITER ',')");

        connection.close();

        System.out.println("Data from " + path + " to database is imported");
    }

    public static long start() {

        long start = System.nanoTime();
        long end = 0;

        return start;

    }

    public static long stop() {

        long stop = System.nanoTime();

        return stop;

    }


}
