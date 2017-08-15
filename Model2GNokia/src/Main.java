import model.rxlevel.GetRxDataFile;
import model.rxlevel.cf.GetCfDataFile;
import model.rxlevel.dac.GetDacDataFile;

import java.io.IOException;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException {

        String pathToRx = "C:\\DATA\\PROGRAMMING\\filesToHide\\";
        String rxFile = "rxlevel.txt";

        String pathToCf = "C:\\DATA\\PROGRAMMING\\filesToHide\\";
        String fileCfToDb = "cf.csv";
        String cfFile = "cf.txt";

        String pathToDac = "C:\\DATA\\PROGRAMMING\\filesToHide\\";
        String fileDacToDb = "dac.csv";
        String dacFile = "dac.txt";

        Utilities.runInitDb(Utilities.returnConnection());

        Utilities.loadToDbData(Utilities.returnConnection());

        GetRxDataFile.loadDataToRxLevel(Utilities.returnConnection());
        GetRxDataFile.createRxLevelFileData(Utilities.returnConnection(), Utilities.createFile(pathToRx + rxFile));

        GetCfDataFile.loadDataToCfLevel(Utilities.returnConnection(), pathToCf + fileCfToDb);
        GetCfDataFile.createCfLevelFileData(Utilities.returnConnection(), Utilities.createFile(pathToCf + cfFile));

        GetDacDataFile.loadDataToDacLevel(Utilities.returnConnection(), pathToDac + fileDacToDb);
        GetDacDataFile.createDacLevelFileData(Utilities.returnConnection(), Utilities.createFile(pathToDac + dacFile));

    }
}
