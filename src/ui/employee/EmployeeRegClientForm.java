package ui.employee;

import db.dao.ClientDao;
import db.dao.PassportDao;
import state.AppState;
import ui.AppProgressBar;
import ui.Passports;
import util.BCrypt;
import util.FieldValidator;
import util.WindowInitializer;
import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.Objects;
import java.util.Vector;

public class EmployeeRegClientForm extends JFrame {


    private final JFrame thisPtr = this;
    private JTextField address;
    private JTextField phone;
    private JTextField password;
    private JTextField email;
    private JPanel panel;
    private JButton regClientBtn;
    private JComboBox<String> comboBox1;
    private JButton showPassportsTable;

    public EmployeeRegClientForm(JFrame backFrame) throws SQLException {


        PassportDao dao = new PassportDao();

        dao.select();

        showPassportsTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                try {
                    thisPtr.setEnabled(false);
                    new Passports(thisPtr);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                backFrame.setEnabled(true);
            }
        });


        for(Vector<String> vector : AppState.getPassports()) {
            comboBox1.addItem(vector.get(0) + " "
                    +vector.get(1) + " " + vector.get(2) + " " + vector.get(3));
        }


        this.regClientBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if(FieldValidator.isEmailValid(email.getText()) && email.getText().length() > 8){
                    Thread thread = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            JFrame bar = new AppProgressBar();
                            thisPtr.setEnabled(false);
                            Vector<String> args = new Vector<>();
                            String str = Objects.requireNonNull(comboBox1
                                    .getSelectedItem()).toString();
                            char[] id = new char[10];
                            str.getChars(0, str.indexOf(" "), id, 0);
                            args.add(String.valueOf(id));
                            args.add(address.getText());
                            args.add(phone.getText());
                            args.add(email.getText());
                            args.add(BCrypt.hashpw(password.getText(),
                                    BCrypt.gensalt(16)));
                            ClientDao dao = new ClientDao();
                            try {
                                dao.insert(args);
                            } catch (SQLException throwables) {
                                throwables.printStackTrace();
                            }
                            bar.setVisible(false);
                            JOptionPane.showMessageDialog(
                                    thisPtr,
                                    "Клиент успешно зарегистрирован в базе данных.",
                                    "Успех", JOptionPane.PLAIN_MESSAGE);
                            comboBox1.setSelectedIndex(0);
                            address.setText("");
                            phone.setText("");
                            email.setText("");
                            password.setText("");
                            thisPtr.setEnabled(true);
                        }
                    });
                    thread.start();
                }else{
                    thisPtr.setEnabled(false);
                    JOptionPane.showMessageDialog(
                            thisPtr,
                            "Некоторые поля заполнены неправильно. " +
                                    "Клиент не зарегистрирован.","Ошибка",
                            JOptionPane.ERROR_MESSAGE);
                    thisPtr.setEnabled(true);
                }
            }
        });

        WindowInitializer.initialize(this, panel, DISPOSE_ON_CLOSE, "Регистрация клиента");
    }
}
