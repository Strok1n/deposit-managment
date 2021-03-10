package ui;

import util.WindowInitializer;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
                new CRUD(frame, 0, -1);
            }
        });
        this.registerContractBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                frame.setEnabled(false);
                new CRUD(frame, 6,-1);
            }
        });
        this.registerClientBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                frame.setEnabled(false);

                new CRUD(frame,  1,-1);
            }
        });
        WindowInitializer.initialize(this, panelMain,
                WindowConstants.EXIT_ON_CLOSE,
                "Управление вкладами");
    }



}
