package ui.admin;

import state.State;
import util.WindowInitializer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;

public class PassportsCRUD extends JFrame {
    private final JFrame thisPtr = this;
    private JTable table1;
    private JPanel panel1;
    private JButton добавитьПаспортButton;
    private JButton отсортироватьButton;


    public PassportsCRUD(JFrame backFrame) throws SQLException {


        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                backFrame.setEnabled(true);
            }
        });



        table1.getTableHeader().setReorderingAllowed(false);
        table1.setModel(State.getPassportsModel());
        table1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                System.out.println( table1.getSelectedRow());
                if(e.getClickCount() == 2){
                        new PassportEditor(thisPtr, table1.getSelectedRow(),         State.getPassportsModel());
                }
            }
        });



        this.setMinimumSize(new Dimension(1024,0));
        WindowInitializer.initialize(this, panel1, DISPOSE_ON_CLOSE, "Паспорта");
    }

}
