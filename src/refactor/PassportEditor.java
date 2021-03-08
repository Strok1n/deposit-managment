package refactor;

import db.dao.PassportDao;
import ui.State;
import ui.AppProgressBar;
import util.WindowInitializer;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.Vector;

public class PassportEditor extends JFrame{

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
    private JButton удалитьПаспортButton;
    private JTextField id;

    public PassportEditor(JFrame backFrame, int row, DefaultTableModel model){

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                backFrame.setEnabled(true);
            }
        });

        id.setText((String) State.models.get(0).getValueAt(row, 0));
        first_name.setText((String) State.models.get(0).getValueAt(row, 1));
        last_name.setText((String) State.models.get(0).getValueAt(row, 2));
        patronymic.setText((String) State.models.get(0).getValueAt(row, 3));
        series.setText((String) State.models.get(0).getValueAt(row, 4));
        number.setText((String) State.models.get(0).getValueAt(row, 5));
        gender.setText((String) State.models.get(0).getValueAt(row, 6));
        address.setText((String) State.models.get(0).getValueAt(row, 7));
        birth_date.setText((String) State.models.get(0).getValueAt(row, 8));
        birth_place.setText((String) State.models.get(0).getValueAt(row, 9));
        issue_date.setText((String) State.models.get(0).getValueAt(row, 10));
        issue_place.setText((String) State.models.get(0).getValueAt(row, 11));
        military_duty.setText((String) State.models.get(0).getValueAt(row, 12));
        marital_status.setText((String) State.models.get(0).getValueAt(row, 13));
        is_valid.setText((String) State.models.get(0).getValueAt(row, 14));





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
                            Vector<String> args = new Vector<>();

                            args.add(id.getText());
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
                               // passportDao.insert(args);
                                passportDao.update(args);
                            } catch (SQLException throwables) {
                                throwables.printStackTrace();
                            }
                            bar.setVisible(false);
                            JOptionPane.showMessageDialog(
                                    thisPtr,
                                    "Данные паспорта успешно обновлены в базе данных.",
                                    "Успех", JOptionPane.PLAIN_MESSAGE);
                            dispose();
                            thisPtr.setEnabled(true);
                            State.getPassports().set(row, args);

                            for(int i = 0; i != args.size(); i++){
                                State.models.get(0).setValueAt(args.get(i), row, i);
                            }




                                for(int i = 0; i != args.size(); i++){

                                    model.setValueAt(args.get(i), row, i);

                                }
                        }
                    });
                    thread.start();
                }else{
                    thisPtr.setEnabled(false);
                    JOptionPane.showMessageDialog(
                            thisPtr,
                            "Некоторые поля заполнены неправильно. " +
                                    "Паспорт не обновлен.","Ошибка",
                            JOptionPane.ERROR_MESSAGE);
                    thisPtr.setEnabled(true);
                }
            }
        });

        удалитьПаспортButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        thisPtr.setEnabled(false);

                        int input = JOptionPane.showConfirmDialog(thisPtr,
                                "Вы действительно хотите удалить паспорт?",
                                "Подтверждение",
                                JOptionPane.OK_CANCEL_OPTION);

                        if(input == 0){
                            JFrame bar = new AppProgressBar();
                            PassportDao dao = new PassportDao();
                            try {
                                dao.delete((String) State.models.get(0).getValueAt(row,0));
                            } catch (SQLException throwables) {
                                throwables.printStackTrace();
                            }
                            bar.setVisible(false);
                            model.removeRow(row);
                            JOptionPane.showMessageDialog(
                                    thisPtr,
                                    "Паспорт удален.",
                                    "Успех", JOptionPane.PLAIN_MESSAGE);
                            thisPtr.dispose();
                        }
                        thisPtr.setEnabled(true);

                    }
                });
                thread.start();



            }
        });



        WindowInitializer.initialize(this, mainPanel,
                DISPOSE_ON_CLOSE, "Изменение паспорта");
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