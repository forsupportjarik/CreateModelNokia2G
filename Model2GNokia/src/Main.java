import model.rxlevel.GetRxDataFile;
import model.rxlevel.cf.GetCfDataFile;
import model.rxlevel.dac.GetDacDataFile;

import java.io.IOException;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException {

        String pathToIdsDatatrx = "C:\\DATA\\PROGRAMMING\\filesToHide\\";
        String fileToLoadIdstrx = "TRX_ID.csv";
        String pathToIdsDataBts = "C:\\DATA\\PROGRAMMING\\filesToHide\\";
        String fileToLoadIdsBts = "BTS_ID.csv";

        String pathToRx = "C:\\DATA\\PROGRAMMING\\filesToHide\\";
        String fileRxToDb = "rxlevel.csv";
        String rxFile = "rxlevel.txt";

        String pathToCf = "C:\\DATA\\PROGRAMMING\\filesToHide\\";
        String fileCfToDb = "cf.csv";
        String cfFile = "cf.txt";

        String pathToDac = "C:\\DATA\\PROGRAMMING\\filesToHide\\";
        String fileDacToDb = "dac.csv";
        String dacFile = "dac.txt";




        Utilities.runInitDb(Utilities.returnConnection());

        Utilities.loadToDbDataForBTS(Utilities.returnConnection(),"'" + pathToIdsDataBts + fileToLoadIdsBts + "'");
        Utilities.loadToDbDataForTrx(Utilities.returnConnection(), "'" + pathToIdsDatatrx + fileToLoadIdstrx + "'");
        GetRxDataFile.loadDataToRxLevel(Utilities.returnConnection(), "'" + pathToRx + fileRxToDb + "'");
        GetCfDataFile.loadDataToCfLevel(Utilities.returnConnection(), "'" + pathToCf + fileCfToDb + "'");
        GetDacDataFile.loadDataToDacLevel(Utilities.returnConnection(), "'" + pathToDac + fileDacToDb + "'");

        GetRxDataFile.createRxLevelFileData(Utilities.returnConnection(), Utilities.createFile(pathToRx + rxFile));
        GetCfDataFile.createCfLevelFileData(Utilities.returnConnection(), Utilities.createFile(pathToCf + cfFile));
        GetDacDataFile.createDacLevelFileData(Utilities.returnConnection(), Utilities.createFile(pathToDac + dacFile));

    }
}
