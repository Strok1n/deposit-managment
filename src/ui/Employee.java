package ui;

import refactor.EmployeeRegClientForm;
import refactor.EmployeeRegContractForm;
import util.WindowInitializer;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

public class Employee extends JFrame {
    private JPanel panelMain;
    private JButton registerPassportBtn;
    private JButton registerContractBtn;
    private JButton registerClientBtn;

    public Employee(){
        JFrame frame = this;
        this.registerPassportBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                frame.setEnabled(false);
                new CRUD(frame, 0, true);
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
