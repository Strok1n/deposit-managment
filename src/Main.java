import db.DatabaseConnection;


import ui.AppProgressBar;
import ui.LoginForm;
import ui.Passports;
import util.FieldValidator;

import javax.swing.*;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.SQLException;

public class Main {






    public static void main(String[] args) throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException, SQLException, NoSuchAlgorithmException, InvalidKeySpecException, IOException {






//        System.out.println("isDateValid: "+ FieldValidator.isDateValid("3222-12-11"));
//
//
//
//        String password = "1234";
//
//        String generatedSecuredPasswordHash = util.BCrypt.hashpw(password, util.BCrypt.gensalt(12));
//
//
//        String generatedSecuredPasswordHash1 = util.BCrypt.hashpw(password, util.BCrypt.gensalt(13));
//
//        System.out.println(generatedSecuredPasswordHash);
//        System.out.println(util.BCrypt.checkpw(password, generatedSecuredPasswordHash));
//        System.out.println(util.BCrypt.checkpw(password, generatedSecuredPasswordHash1));
//        System.out.println(util.BCrypt.checkpw("1234", generatedSecuredPasswordHash1));
//        System.out.println(util.BCrypt.checkpw("12345", generatedSecuredPasswordHash1));

//
//

        DatabaseConnection.setAdminConnection();
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

       new LoginForm();

    }

}
