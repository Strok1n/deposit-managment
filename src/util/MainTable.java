package util;

import state.State;
import util.menus.CRUD;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainTable extends JFrame {

    private final JFrame thisPtr = this;
    private JTable table1;
    private JPanel panel;
    private JButton add;
    private JButton refresh;


    public MainTable(JFrame backFrame, int modelNumber){
        table1.getTableHeader().setReorderingAllowed(false);
        table1.setModel(State.models.get(modelNumber));
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                backFrame.setEnabled(true);
            }
        });
        table1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                System.out.println( table1.getSelectedRow());
                if(e.getClickCount() == 2){
                    new CRUD(backFrame, modelNumber, false);
                }
            }
        });
        add.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                thisPtr.setEnabled(false);
                new CRUD(thisPtr, modelNumber, true);
            }
        });
        this.setPreferredSize(new Dimension(1024,784));
        WindowInitializer.initialize(thisPtr, panel, DISPOSE_ON_CLOSE, "Ведение базы данных");
    }

}
