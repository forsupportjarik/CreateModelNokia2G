import org.apache.ibatis.jdbc.ScriptRunner;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Utilities {

    public static void runInitDb() throws ClassNotFoundException, SQLException {

        String path = "C:\\Users\\yakovalenko\\IdeaProjects\\CreateModelNokia2G\\scripts\\";
        String scriptName = "initDB.sql";

        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/GSM", "postgres", "parafin");
        Statement stmt = null;
        try {
            ScriptRunner scriptRunner = new ScriptRunner(con);
            Reader reader = new BufferedReader(new FileReader(path + scriptName));
            scriptRunner.runScript(reader);
            reader.close();
            con.close();
        } catch (Exception e) {
            System.err.println("Failed to Execute" + scriptName + " The error is " + e.getMessage());
        }
    }


    public static void loadToDbData() {

    }
}
