package model.rxlevel.dac;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GetDacDataFile {
    public static void loadDataToDacLevel(Connection connection, String path) throws SQLException {

        Statement statement = connection.createStatement();

        statement.executeUpdate("COPY DAC FROM" + path + "DELIMITER ';' CSV HEADER");

        System.out.println("Data from " + path + " to dac table is imported");
    }

    public static void createDacLevelFileData(Connection connection, File file) throws SQLException, IOException {

        Statement statement = connection.createStatement();

        ResultSet rs = statement.executeQuery("SELECT dac.period_start_time, dac.period_start_time, dac.period_duration, idsbts.bts_id, dac.bsc_name, dac.bts_name,\n" +
                "    idsbts.bts, dac.ncc_id, dac.bcc_id, dac.bcch_id, dac.db_value_low, dac.db_value_high, dac.ave_dl_sig_str_serv_cell_sum,\n" +
                "    dac.ave_dl_sig_str_serv_cell_den, dac.std_dev_of_serv_cell, dac.ave_dl_sig_str_adj_cell, dac.std_dev_of_adj_cell,\n" +
                "    dac.nbr_of_samples_in_class1, dac.nbr_of_samples_in_class2, dac.nbr_of_samples_in_class3 FROM dac LEFT JOIN idsbts\n" +
                "    ON dac.bts_name = idsbts.bts_name;");

        FileWriter fw = new FileWriter(file);

        fw.append("DATE\tPERIOD_START_TIME\tDURATION\tBTS_INT_ID\tBSC_NAME\tBTS_NAME\tBTS_ID\tNCC\tBCC\tBCCH\tDB_VALUE_LOW\tDB_VALUE_HIGH\tAVE_DL_SIG_STR_SERV_CELL_SUM\tAVE_DL_SIG_STR_SERV_CELL_DEN\tSTD_DEV_OF_SERV_CELL\tAVE_DL_SIG_STR_ADJ_CELL\tSTD_DEV_OF_ADJ_CELL\tNBR_OF_SAMPLES_IN_CLASS_1\tNBR_OF_SAMPLES_IN_CLASS_2\tNBR_OF_SAMPLES_IN_CLASS_3\n");

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
            fw.append(rs.getString(20) + "\n");

        }
        fw.flush();
        fw.close();

        System.out.println("dac.txt file is done.");
    }
}
