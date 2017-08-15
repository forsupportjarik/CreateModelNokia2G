import model.rxlevel.GetRxDataFile;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        Utilities.runInitDb(Utilities.returnConnection());

        Utilities.loadToDbData(Utilities.returnConnection());

        GetRxDataFile.loadDataToRxLevel(Utilities.returnConnection());

    }
}
