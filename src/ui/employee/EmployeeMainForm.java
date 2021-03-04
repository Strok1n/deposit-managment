package ui.employee;

import util.WindowInitializer;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

public class EmployeeMainForm extends JFrame {
    private JPanel panelMain;
    private JButton registerPassportBtn;
    private JButton registerContractBtn;
    private JButton registerClientBtn;

    public EmployeeMainForm(){
        JFrame frame = this;
        this.registerPassportBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                frame.setEnabled(false);
                new EmployeeRegPassportForm(frame);
            }
        });
        this.registerContractBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                frame.setEnabled(false);
                new EmployeeRegContractForm(frame);
            }
        });
        this.registerClientBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                frame.setEnabled(false);
                try {
                    new EmployeeRegClientForm(frame);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });
        WindowInitializer.initialize(this, panelMain,
                WindowConstants.EXIT_ON_CLOSE,
                "Управление вкладами");

    }



}
