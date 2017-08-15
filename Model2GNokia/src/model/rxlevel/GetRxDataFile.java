package model.rxlevel;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GetRxDataFile {

    public static void loadDataToRxLevel(Connection connection) throws SQLException {

        Statement statement = connection.createStatement();

        String path = "'C:\\DATA\\PROGRAMMING\\filesToHide\\rxlevel.csv'";

        statement.executeUpdate("COPY RXLEVEL FROM" + path + "DELIMITER ';' CSV HEADER");

        System.out.println("Data from " + path + " to rxlevel table is imported");
    }

    public static void createRxLevelFileData(Connection connection, File file) throws SQLException, IOException {

        Statement statement = connection.createStatement();

        String path = "'C:\\DATA\\PROGRAMMING\\filesToHide\\rxlevel.txt'";

        ResultSet rs = statement.executeQuery("SELECT rxlevel.bsc_name, rxlevel.bts_name, rxlevel.period_start_time, rxlevel.period_start_time, rxlevel.period_duration,\n" +
                "    ids.bts, ids.trx, rxlevel.bsc_name, ids.bts_id, ids.trx_id, rxlevel.rng_id, rxlevel.freq_ul_qual0, rxlevel.freq_ul_qual1, rxlevel.freq_ul_qual2,\n" +
                "    rxlevel.freq_ul_qual3, rxlevel.freq_ul_qual4, rxlevel.freq_ul_qual5, rxlevel.freq_ul_qual6, rxlevel.freq_ul_qual7,\n" +
                "    rxlevel.freq_dl_qual0, rxlevel.freq_dl_qual1, rxlevel.freq_dl_qual2, rxlevel.freq_dl_qual3, rxlevel.freq_dl_qual4, rxlevel.freq_dl_qual5, rxlevel.freq_dl_qual6,\n" +
                "    rxlevel.freq_dl_qual7 FROM rxlevel LEFT JOIN ids ON CONCAT(rxlevel.bts_name, rxlevel.trx_id) = CONCAT(ids.bts_name, ids.trx);");

        FileWriter fw = new FileWriter(file);

        fw.append("BSC_NAME\tBTS_NAME\tSTART\tSTOP\tPERIOD_DURATION\tBTS_ID\tTRX_ID\tBSC_INT_ID\tBTS_INT_ID\tTRX_INT_ID\tCLASS_UPPER_RANGE\tFREQ_UL_QUAL0\tFREQ_UL_QUAL1\tFREQ_UL_QUAL2\tFREQ_UL_QUAL3\tFREQ_UL_QUAL4\tFREQ_UL_QUAL5\tFREQ_UL_QUAL6\tFREQ_UL_QUAL7\tFREQ_DL_QUAL0\tFREQ_DL_QUAL1\tFREQ_DL_QUAL2\tFREQ_DL_QUAL3\tFREQ_DL_QUAL4\tFREQ_DL_QUAL5\tFREQ_DL_QUAL6\tFREQ_DL_QUAL7");

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
            fw.append(rs.getString(17) + "\t");
            fw.append(rs.getString(18) + "\t");
            fw.append(rs.getString(19) + "\t");
            fw.append(rs.getString(20) + "\t");
            fw.append(rs.getString(21) + "\t");
            fw.append(rs.getString(22) + "\t");
            fw.append(rs.getString(23) + "\t");
            fw.append(rs.getString(24) + "\t");
            fw.append(rs.getString(25) + "\t");
            fw.append(rs.getString(26) + "\n");
        }
        fw.flush();
        fw.close();

        System.out.println("rxlevel.txt file is done.");
    }
}
