package ui;

import db.DatabaseConnection;
import util.WindowInitializer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;

public class MainTable extends JFrame {

    private final JFrame thisPtr = this;
    private JTable table1;
    private JPanel panel;
    private JButton add;
    private JButton refresh;
    private JButton сортироватьButton;


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
                if(e.getClickCount() == 2){
                    System.out.println(table1.getSelectedRow());
                   // thisPtr.setEnabled(false);
                    new CRUD(thisPtr, modelNumber, table1.getSelectedRow());
                }
            }
        });
        add.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
               // thisPtr.setEnabled(false);
                new CRUD(thisPtr, modelNumber, -1);
            }
        });
        refresh.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                //thisPtr.setEnabled(false);
                JFrame bar = new AppProgressBar();
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            DatabaseConnection.refreshModel(modelNumber);
                        } catch (SQLException exception) {
                            exception.printStackTrace();
                        }
                        bar.setVisible(false);
                        thisPtr.setEnabled(true);
                    }
                });
                thread.start();
            }
        });
        this.setPreferredSize(new Dimension(1024,784));
        WindowInitializer.initialize(thisPtr, panel, DISPOSE_ON_CLOSE, "Ведение базы данных");
    }

}
