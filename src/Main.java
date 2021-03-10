import db.DatabaseConnection;
import db.dao.ClientDao;
import db.dao.EmployeeDao;
import db.dao.PassportDao;
import db.dao.PositionDao;
import ui.Admin;
import ui.LoginForm;
import ui.State;

import javax.swing.*;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Vector;


public class Main {

    public static void main(String[] args) throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException, SQLException{

        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

        DatabaseConnection.setAdminConnection();

        State.init();



        new LoginForm();
        new Admin();





       // new CrudForm(new JFrame(), 0);
       // new CrudForm(new JFrame(), 1);






       // getData();





//       new LoginForm();





    }


    private static void getData() throws SQLException {
        ClientDao dao = new ClientDao();
        EmployeeDao employeeDao = new EmployeeDao();
        PositionDao positionDao = new PositionDao();
        PassportDao dao1 = new PassportDao();

        dao1.select();
        dao.select();
        employeeDao.select();
        positionDao.select();
    }

}
