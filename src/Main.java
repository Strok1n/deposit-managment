import db.DatabaseConnection;
import db.dao.ClientDao;
import db.dao.EmployeeDao;
import db.dao.PassportDao;
import db.dao.PositionDao;
import ui.Admin;
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

      //  DatabaseConnection
             //   .insert(
                     //   0,
                      //  new Vector<>
                           //     (Arrays.asList("asdf","asdf","asdf","3","2","м","2000-01-01","2000-01-01","2000-01-01","2000-01-01","2000-01-01","2000-01-01","2000-01-01","да")));


        //System.out.println(AppState.models.get(1).getDataVector());

        new Admin();





       // new CrudForm(new JFrame(), 0);
       // new CrudForm(new JFrame(), 1);






       // getData();





//       new LoginForm();

      //  new PassportsCRUD(new JFrame());

      //  new PassportEditor(new JFrame());

//new EmployeeRegClientForm(new JFrame());



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
