package ui;

import db.dao.PassportDao;
import state.AppState;
import util.WindowInitializer;

import javax.swing.*;
import javax.swing.event.CellEditorListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.EventObject;
import java.util.Vector;

public class Passports extends JFrame {
    private JTable table1;
    private JPanel panel;



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
        for(int i = 0; i < AppState.getPassports().size(); i++)
            model.addRow(AppState.getPassports().get(i));
        table1.getTableHeader().setReorderingAllowed(false);
        table1.setModel(model);


        WindowInitializer.initialize(this, panel, DISPOSE_ON_CLOSE, "Паспорта");
    }

}
