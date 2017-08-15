import model.rxlevel.GetRxDataFile;

import java.io.IOException;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException {

        String pathToRx = "C:\\DATA\\PROGRAMMING\\filesToHide\\";
        String rxFile = "rxlevel.txt";

        String pathToCf = "C:\\DATA\\PROGRAMMING\\filesToHide\\";
        String cfFile = "cf.txt";

        Utilities.runInitDb(Utilities.returnConnection());

        Utilities.loadToDbData(Utilities.returnConnection());

        GetRxDataFile.loadDataToRxLevel(Utilities.returnConnection());
        GetRxDataFile.createRxLevelFileData(Utilities.returnConnection(), Utilities.createFile(pathToRx + rxFile));

    }
}
