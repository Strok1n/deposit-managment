package util.menus;

import state.State;
import util.Validator;
import util.WindowInitializer;
import javax.swing.*;
import java.awt.event.*;
import java.util.Vector;

public class CRUD extends JFrame{

    private final JFrame thisPtr = this;
    private JPanel mainPanel;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JTextField textField7;
    private JTextField textField8;
    private JTextField textField9;
    private JTextField textField10;
    private JTextField textField11;
    private JTextField textField12;
    private JTextField textField13;
    private JTextField textField14;
    private JButton button0;
    private JButton button1;
    private JTextField textField0;
    private JLabel label0;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    private JLabel label6;
    private JLabel label7;
    private JLabel label8;
    private JLabel label9;
    private JLabel label10;
    private JLabel label11;
    private JLabel label12;
    private JLabel label13;
    private JLabel label14;
    private JComboBox<String> comboBox1;
    private JComboBox<String> comboBox2;
    private JComboBox<String> comboBox3;
    private JLabel labelBox0;
    private JLabel labelBox1;
    private JLabel labelBox2;

    private Vector<JTextField> textFields;
    private Vector<JLabel> jTextLabels;
    private Vector<JComboBox<String>> boxes;
    private Vector<JLabel> jBoxesLabels;

    private void packFieldsToVector(){
        textFields = new Vector<>();
        textFields.add(textField0);
        textFields.add(textField1);
        textFields.add(textField2);
        textFields.add(textField3);
        textFields.add(textField4);
        textFields.add(textField5);
        textFields.add(textField6);
        textFields.add(textField7);
        textFields.add(textField8);
        textFields.add(textField9);
        textFields.add(textField10);
        textFields.add(textField11);
        textFields.add(textField12);
        textFields.add(textField13);
        textFields.add(textField14);
        jTextLabels = new Vector<>();
        jTextLabels.add(label0);
        jTextLabels.add(label1);
        jTextLabels.add(label2);
        jTextLabels.add(label3);
        jTextLabels.add(label4);
        jTextLabels.add(label5);
        jTextLabels.add(label6);
        jTextLabels.add(label7);
        jTextLabels.add(label8);
        jTextLabels.add(label9);
        jTextLabels.add(label10);
        jTextLabels.add(label11);
        jTextLabels.add(label12);
        jTextLabels.add(label13);
        jTextLabels.add(label14);
        boxes = new Vector<>();
        boxes.add(comboBox1);
        boxes.add(comboBox2);
        boxes.add(comboBox3);
        jBoxesLabels = new Vector<>();
        jBoxesLabels.add(labelBox0);
        jBoxesLabels.add(labelBox1);
        jBoxesLabels.add(labelBox2);
    }

    public CRUD(JFrame backFrame, int modelNumber, boolean flag){
        packFieldsToVector();
        for(JLabel label : jTextLabels)
            label.setVisible(false);
        for(JTextField field : textFields)
            field.setVisible(false);
        for(JComboBox<String> box : boxes)
            box.setVisible(false);
        for(JLabel label : jBoxesLabels)
            label.setVisible(false);

//
//        for(int i = 0; i != State.models.get(modelNumber).getColumnCount(); i++){
//           // jTextLabels.get(i).setText(State.labels.get(modelNumber).get(i));
//         //   jTextLabels.get(i).setVisible(true);
//          //  textFields.get(i).setVisible(true);
//        }

        for(int i = 0; i!= State.jTextFieldsNumber.get(modelNumber); i++){
            jTextLabels.get(i).setText(State.textLabels.get(modelNumber).get(i));
            jTextLabels.get(i).setVisible(true);
            textFields.get(i).setVisible(true);
        }
        for(int i = 0; i!= State.jComboBoxesNumber.get(modelNumber); i++){
            jBoxesLabels.get(i).setText(State.boxLabels.get(modelNumber).get(i));
            jBoxesLabels.get(i).setVisible(true);
            boxes.get(i).setVisible(true);
        }


        if(modelNumber == 1){
            for(int j = 0; j != State.jComboBoxesFK.get(modelNumber).size(); j++){
                for(int i = 0; i != State.models.get(State.jComboBoxesFK.get(modelNumber).get(j)).getRowCount(); i++)
                    boxes.get(j).addItem(String.valueOf(State.models.get(j).getDataVector().get(i)));
            }
        }




        if(flag){

            button1.setVisible(false);
            button0.setText("Добавить запись");

            button0.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    super.mouseClicked(e);
                    Vector<String> params = new Vector<>();

                    for(int i = 0; i != State.models.get(modelNumber).getColumnCount(); i++)
                        params.add(textFields.get(i).getText());

                    System.out.println(Validator.validate(params, modelNumber));
                    //validate -> sql + model
                }
            });




        }else{

            button0.setText("Обновить запись");

            button0.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    super.mouseClicked(e);

                    // validate -> sql + model

                }
            });



            button1.setText("Удалить запись");

            button1.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    super.mouseClicked(e);

                    // confirm -> sql + model

                }
            });

        }






        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                backFrame.setEnabled(true);
            }
        });


//        button0.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                if(isFieldsValid()){
//                    Thread thread = new Thread(new Runnable() {
//                        @Override
//                        public void run() {
//                            JFrame bar = new AppProgressBar();
//                            thisPtr.setEnabled(false);
//                            PassportDao passportDao = new PassportDao();
//                            List<String> args = new ArrayList<>();
//                            args.add(textField1.getText());
//                            args.add(textField2.getText());
//                            args.add(textField3.getText());
//                            args.add(textField4.getText());
//                            args.add(textField5.getText());
//                            args.add(textField6.getText());
//                            args.add(textField7.getText());
//                            args.add(textField8.getText());
//                            args.add(textField9.getText());
//                            args.add(textField10.getText());
//                            args.add(textField11.getText());
//                            args.add(textField12.getText());
//                            args.add(textField13.getText());
//                            args.add(textField14.getText());
//                            try {
//                                passportDao.insert(args);
//                            } catch (SQLException throwables) {
//                                throwables.printStackTrace();
//                            }
//                            bar.setVisible(false);
//                            JOptionPane.showMessageDialog(
//                                    thisPtr,
//                                    "Паспорт успешно зарегистрирован в базе данных.",
//                                    "Успех", JOptionPane.PLAIN_MESSAGE);
//                            textField1.setText("");
//                            textField2.setText("");
//                            textField3.setText("");
//                            textField4.setText("");
//                            textField5.setText("");
//                            textField6.setText("");
//                            textField7.setText("");
//                            textField8.setText("");
//                            textField9.setText("");
//                            textField10.setText("");
//                            textField11.setText("");
//                            textField12.setText("");
//                            textField13.setText("");
//                            textField14.setText("");
//                            thisPtr.setEnabled(true);
//                        }
//                    });
//                    thread.start();
//                }else{
//                    thisPtr.setEnabled(false);
//                    JOptionPane.showMessageDialog(
//                            thisPtr,
//                            "Некоторые поля заполнены неправильно. " +
//                                    "Паспорт не зарегистрирован.","Ошибка",
//                            JOptionPane.ERROR_MESSAGE);
//                    thisPtr.setEnabled(true);
//                }
//            }
//        });
        WindowInitializer.initialize(this, mainPanel,
                DISPOSE_ON_CLOSE, "Регистрация паспорта");
    }
}