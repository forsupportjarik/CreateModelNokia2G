package model.rxlevel;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class GetRxDataFile {

    public static void loadDataToRxLevel(Connection connection) throws SQLException {

        Statement statement = connection.createStatement();

        String path = "'C:\\DATA\\PROGRAMMING\\filesToHide\\rxlevel.csv'";

        statement.executeUpdate("COPY RXLEVEL FROM" + path + "DELIMITER ';' CSV HEADER");

        System.out.println("Data from " + path + " to rxlevel table is imported");
    }

    public static void createRxLevelFileData(Connection connection) throws SQLException {

        Statement statement = connection.createStatement();

        String path = "'C:\\DATA\\PROGRAMMING\\filesToHide\\rxlevel.txt'";
    }
}
