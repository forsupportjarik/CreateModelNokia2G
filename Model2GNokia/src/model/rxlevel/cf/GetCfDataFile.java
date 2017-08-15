package model.rxlevel.cf;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GetCfDataFile {

    public static void loadDataToRxLevel(Connection connection, String path) throws SQLException {

        Statement statement = connection.createStatement();

        statement.executeUpdate("COPY CF FROM" + path + "DELIMITER ';' CSV HEADER");

        System.out.println("Data from " + path + " to cf table is imported");
    }

    public static void createRxLevelFileData(Connection connection, File file) throws SQLException, IOException {

        Statement statement = connection.createStatement();

        ResultSet rs = statement.executeQuery("SELECT rxlevel.bsc_name, rxlevel.bts_name, rxlevel.period_start_time, rxlevel.period_start_time, rxlevel.period_duration,\n" +
                "    ids.bts, ids.trx, rxlevel.bsc_name, ids.bts_id, ids.trx_id, rxlevel.rng_id, rxlevel.freq_ul_qual0, rxlevel.freq_ul_qual1, rxlevel.freq_ul_qual2,\n" +
                "    rxlevel.freq_ul_qual3, rxlevel.freq_ul_qual4, rxlevel.freq_ul_qual5, rxlevel.freq_ul_qual6, rxlevel.freq_ul_qual7,\n" +
                "    rxlevel.freq_dl_qual0, rxlevel.freq_dl_qual1, rxlevel.freq_dl_qual2, rxlevel.freq_dl_qual3, rxlevel.freq_dl_qual4, rxlevel.freq_dl_qual5, rxlevel.freq_dl_qual6,\n" +
                "    rxlevel.freq_dl_qual7 FROM rxlevel LEFT JOIN ids ON CONCAT(rxlevel.bts_name, rxlevel.trx_id) = CONCAT(ids.bts_name, ids.trx);");

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
