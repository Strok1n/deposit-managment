import db.DatabaseConnection;
import db.dao.ClientDao;
import db.dao.EmployeeDao;
import db.dao.PassportDao;
import db.dao.PositionDao;
import state.State;
import ui.admin.AdminMainForm;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.sql.SQLException;
import java.time.Instant;
import java.util.Date;


public class Main {

    public static void main(String[] args) throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException, SQLException{

        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

        DatabaseConnection.setAdminConnection();

        State.init();

        //System.out.println(AppState.models.get(1).getDataVector());

        String str = "df";


        new AdminMainForm();

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
