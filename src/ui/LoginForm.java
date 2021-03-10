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

                        for(int i = 0; i != State.models.get(1).getRowCount(); i++)
                            if(loginField.getText().equals(State.models.get(1).getValueAt(i,3)))
                                if(BCrypt.checkpw(new String(passwordField.getPassword()),
                                        State.models.get(1).getValueAt(i,5).toString())){
                                    System.out.println("FSDSFD");
                                    client = true;
                                }
                        for(int i = 0; i != State.models.get(4).getRowCount(); i++)
                            if(loginField.getText().equals(State.models.get(4).getValueAt(i,6)))
                                if(BCrypt.checkpw(new String(passwordField.getPassword()),
                                        State.models.get(4).getValueAt(i,8).toString())){

                                    for(int j = 0; j != State.models.get(3).getRowCount(); j++){


                                        if(State.models.get(4).getValueAt(i, 2).toString().equals(State.models.get(3).getValueAt(j, 0).toString()) &&(
                                        State.models.get(3).getValueAt(j,2).toString().contains("Администратор") ||
                                                State.models.get(3).getValueAt(j,2).toString().equals("Администратор")  )){
                                            admin = true;

                                        }

                                    }
                                    employee = true;
                               }
                              //  }
                        if(admin){
                            new Admin();
                            dispose();
                        }else if(employee){
                            new Employee();
                            dispose();
                        }else
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
