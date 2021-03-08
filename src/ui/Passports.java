package ui;

import util.WindowInitializer;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;

public class Passports extends JFrame {
    private JTable table1;
    private JPanel panel12;



    public Passports(JFrame backFrame) throws SQLException {


        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                backFrame.setEnabled(true);
            }
        });


        DefaultTableModel model = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        model.addColumn("Идентификатор");
        model.addColumn("Имя");
        model.addColumn("Фамилия");
        model.addColumn("Отчество");
        model.addColumn("Серия");
        model.addColumn("Номер");
        model.addColumn("Пол");
        model.addColumn("Адрес");
        model.addColumn("Дата рождения");
        model.addColumn("Место рождения");
        model.addColumn("Дата выдачи");
        model.addColumn("Место выдачи");
        model.addColumn("Воинская деятельность");
        model.addColumn("Семейное положение");
        model.addColumn("Действителен ли паспорт");

        //AppState.getPassports().sort(new VectorComparator());


        for(int i = 0; i < State.getPassports().size(); i++)
            model.addRow(State.getPassports().get(i));
        table1.getTableHeader().setReorderingAllowed(false);
        table1.setModel(model);

        this.setMinimumSize(new Dimension(1024,0));
        WindowInitializer.initialize(this, panel12, DISPOSE_ON_CLOSE, "Паспорта");
    }

}
