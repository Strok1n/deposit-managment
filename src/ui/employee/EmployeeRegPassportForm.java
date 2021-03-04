package ui.employee;

import db.dao.PassportDao;
import ui.AppProgressBar;
import util.FieldValidator;
import util.WindowInitializer;
import javax.swing.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRegPassportForm extends JFrame{

    private final JFrame thisPtr = this;
    private JPanel mainPanel;
    private JTextField first_name;
    private JTextField last_name;
    private JTextField patronymic;
    private JTextField series;
    private JTextField number;
    private JTextField gender;
    private JTextField address;
    private JTextField birth_date;
    private JTextField birth_place;
    private JTextField issue_date;
    private JTextField issue_place;
    private JTextField military_duty;
    private JTextField marital_status;
    private JTextField is_valid;
    private JButton regClientBtn;

    public EmployeeRegPassportForm(JFrame backFrame){

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                backFrame.setEnabled(true);
            }
        });

        regClientBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(isFieldsValid()){
                    Thread thread = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            JFrame bar = new AppProgressBar();
                            thisPtr.setEnabled(false);
                            PassportDao passportDao = new PassportDao();
                            List<String> args = new ArrayList<>();
                            args.add(first_name.getText());
                            args.add(last_name.getText());
                            args.add(patronymic.getText());
                            args.add(series.getText());
                            args.add(number.getText());
                            args.add(gender.getText());
                            args.add(address.getText());
                            args.add(birth_date.getText());
                            args.add(birth_place.getText());
                            args.add(issue_date.getText());
                            args.add(issue_place.getText());
                            args.add(military_duty.getText());
                            args.add(marital_status.getText());
                            args.add(is_valid.getText());
                            try {
                                passportDao.insert(args);
                            } catch (SQLException throwables) {
                                throwables.printStackTrace();
                            }
                            bar.setVisible(false);
                            JOptionPane.showMessageDialog(
                                    thisPtr,
                                    "Паспорт успешно зарегистрирован в базе данных.",
                                    "Успех", JOptionPane.PLAIN_MESSAGE);
                            first_name.setText("");
                            last_name.setText("");
                            patronymic.setText("");
                            series.setText("");
                            number.setText("");
                            gender.setText("");
                            address.setText("");
                            birth_date.setText("");
                            birth_place.setText("");
                            issue_date.setText("");
                            issue_place.setText("");
                            military_duty.setText("");
                            marital_status.setText("");
                            is_valid.setText("");
                            thisPtr.setEnabled(true);
                        }
                    });
                    thread.start();
                }else{
                    thisPtr.setEnabled(false);
                    JOptionPane.showMessageDialog(
                            thisPtr,
                            "Некоторые поля заполнены неправильно. " +
                                    "Паспорт не зарегистрирован.","Ошибка",
                            JOptionPane.ERROR_MESSAGE);
                    thisPtr.setEnabled(true);
                }
            }
        });
        WindowInitializer.initialize(this, mainPanel,
                DISPOSE_ON_CLOSE, "Регистрация паспорта");
    }

    private boolean isFieldsValid(){
        if(!FieldValidator.isStringValid(first_name.getText(), 128, false)
        || FieldValidator.hasNumbers(first_name.getText()))
            return false;
        if(!FieldValidator.isStringValid(last_name.getText(), 128, false)
        || FieldValidator.hasNumbers(last_name.getText()))
            return false;
        if((!patronymic.getText().isEmpty() && !FieldValidator.isStringValid(
                patronymic.getText(), 128, false))
        || FieldValidator.hasNumbers(patronymic.getText()))
            return false;
        if(!FieldValidator.isNumberValid(series.getText()))
            return false;
        if(!FieldValidator.isNumberValid(number.getText()))
            return false;
        if(!gender.getText().equals("м") && !gender.getText().equals("ж"))
            return false;
        if(!FieldValidator.isDateValid(birth_date.getText()))
            return false;
        if(!FieldValidator.isDateValid(issue_date.getText()))
            return false;
         if(!is_valid.getText().equals("да") && !is_valid.getText().equals("нет"))
             return false;
         return true;
    }
}