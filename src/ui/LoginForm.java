package ui;

import ui.employee.EmployeeMainForm;
import util.WindowInitializer;
import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LoginForm extends JFrame {

    private JPanel panelMain;
    private JButton loginButton;
    private JTextField loginField;
    private JPasswordField passwordField;

    public LoginForm(){
        loginButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                new EmployeeMainForm();
                dispose();
            }
        });
        WindowInitializer
                .initialize(this, panelMain,
                EXIT_ON_CLOSE, "Управление банковскими вкладами");
    }
}
