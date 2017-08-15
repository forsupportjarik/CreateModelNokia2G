package model.rxlevel.cf;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GetCfDataFile {

    public static void loadDataToCfLevel(Connection connection, String path) throws SQLException {

        Statement statement = connection.createStatement();

        statement.executeUpdate("COPY CF FROM" + path + "DELIMITER ';' CSV HEADER");

        System.out.println("Data from " + path + " to cf table is imported");
    }

    public static void createCfLevelFileData(Connection connection, File file) throws SQLException, IOException {

        Statement statement = connection.createStatement();

        ResultSet rs = statement.executeQuery("SELECT cf.period_start_time, cf.period_start_time, cf.period_duration, ids.bts_id, cf.bsc_name, cf.bts_name,\n" +
                "    ids.bts, cf.ncc_id, cf.bcc_id, cf.bcch_id, cf.db_value_low, cf.db_value_high, cf.ave_dl_signal_strength,\n" +
                "    cf.standart_deviation, cf.num_of_samples_in_class_1, cf.num_of_samples_in_class_2, cf.num_of_samples_in_class_3\n" +
                "  FROM cf LEFT JOIN ids ON cf.bts_name = ids.bts_name;");

        FileWriter fw = new FileWriter(file);

        fw.append("DATE\tPERIOD_START_TIME\tDURATION\tBTS_INT_ID\tBSC_NAME\tBTS_NAME\tBTS_ID\tNCC\tBCC\tBCCH\tDB_VALUE_LOW\tDB_VALUE_HIGH\tAVE_DL_SIGNAL_STRENGTH\tSTANDARD_DEVIATION\tNUM_OF_SAMPLES_IN_CLASS_1\tNUM_OF_SAMPLES_IN_CLASS_2\tNUM_OF_SAMPLES_IN_CLASS_3\n");

        while (rs.next()) {
            fw.append(rs.getString(1) + "\t");
            fw.append(rs.getString(2) + "\t");
            fw.append(rs.getString(3) + "\t");
            fw.append(rs.getString(4) + "\t");
            fw.append(rs.getString(5) + "\t");
            fw.append(rs.getString(6) + "\t");
            fw.append(rs.getString(7) + "\t");
            fw.append(rs.getString(8) + "\t");
            fw.append(rs.getString(9) + "\t");
            fw.append(rs.getString(10) + "\t");
            fw.append(rs.getString(11) + "\t");
            fw.append(rs.getString(12) + "\t");
            fw.append(rs.getString(13) + "\t");
            fw.append(rs.getString(14) + "\t");
            fw.append(rs.getString(15) + "\t");
            fw.append(rs.getString(16) + "\t");
            fw.append(rs.getString(17) + "\n");

        }
        fw.flush();
        fw.close();

        System.out.println("cf.txt file is done.");
    }
}
