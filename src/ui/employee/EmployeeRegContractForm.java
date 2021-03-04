package ui.employee;

import util.WindowInitializer;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class EmployeeRegContractForm extends JFrame {


    private JPanel mainPanel;
    private JComboBox comboBox1;
    private JTextField textField1;
    private JTextField textField2;

    public EmployeeRegContractForm(JFrame backFrame){







        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                backFrame.setEnabled(true);
            }
        });


        WindowInitializer.initialize(this, mainPanel
                , DISPOSE_ON_CLOSE, "Зарегистрировать контракт");
    }


}
