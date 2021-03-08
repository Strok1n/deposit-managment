package ui;

import util.BCrypt;
import util.WindowInitializer;
import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

public class LoginForm extends JFrame {

    private final JFrame thisPtr = this;
    private JPanel panelMain;
    private JButton loginButton;
    private JTextField loginField;
    private JPasswordField passwordField;

    public LoginForm(){
        loginButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                //new EmployeeMainForm();
               // dispose();
                loginButton.setEnabled(false);
                JFrame bar = new AppProgressBar();
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        boolean client = false, employee = false, admin = false;
                        loginField.getText();

                        for(int i = 0; i != State.getClients().size(); i++)
                            if(loginField.getText().equals(State.getClients().get(i).get(4)))
                                if(BCrypt.checkpw(new String(passwordField.getPassword()),
                                        State.getClients().get(i).get(5))){
                                    State.setClientData(new Vector<>(State.getClients().get(i)));
                                    client = true;
                                }
                        for(int i = 0; i != State.getEmployees().size(); i++)
                            if(loginField.getText().equals(State.getEmployees().get(i).get(7)))
                                if(BCrypt.checkpw(new String(passwordField.getPassword()),
                                        State.getEmployees().get(i).get(8))){
                                    State.setEmployeeData(new Vector<>(State.getEmployees().get(i)));
                                    employee = true;
                                }
                        if(employee)
                            for(int i = 0; i != State.getPositions().size(); i++)
                                if (State.getEmployeeData().get(1).equals(State.getPositions().get(i).get(0)) && (
                                        State.getPositions().get(i).get(2).contains("Администратор") ||
                                                State.getPositions().get(i).get(2).equals("Администратор"))){
                                    admin =true;
                                }
                        if(admin){

                            new Admin();
                            dispose();
                        }else if(employee){

                            new Employee();
                            dispose();
                        }
                        if(client)
                        {
                            new Client();
                            dispose();
                        }
                        bar.setVisible(false);
                        if(!client && !employee){
                            JOptionPane.showMessageDialog(
                                    thisPtr,
                                    "Неверные данные для входа в систему. ",
                                    "Ошибка",
                                    JOptionPane.ERROR_MESSAGE);


                        loginButton.setEnabled(true);
                    }
                    }
                });
                thread.start();
            }
        });
        WindowInitializer
                .initialize(this, panelMain,
                EXIT_ON_CLOSE, "Управление банковскими вкладами");
    }
}
