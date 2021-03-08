package ui;

import util.AdminMainMouseAdapter;
import util.WindowInitializer;

import javax.swing.*;


public class Admin extends JFrame {

    private JPanel panelMain;
    private JButton редактироватьТаблицуПаспортовButton;
    private JButton редактироватьТаблицуКлиентовButton;
    private JButton редактироватьТаблицуВалютButton;
    private JButton редактироватьТаблицуДолжностейButton;
    private JButton редактироватьТаблицуРаботниковButton;
    private JButton редактироватьТаблицуВкладовButton;
    private JButton редактироватьТаблицуКонтрактовButton;
    private JButton редактироватьТаблицуИсторийButton;

    public Admin(){



       // panelMain.add(panel2);

        AdminMainMouseAdapter adapter = new AdminMainMouseAdapter(this);
        редактироватьТаблицуПаспортовButton.addMouseListener(adapter);
        редактироватьТаблицуКлиентовButton.addMouseListener(adapter);
        редактироватьТаблицуВалютButton.addMouseListener(adapter);
        редактироватьТаблицуДолжностейButton.addMouseListener(adapter);
        редактироватьТаблицуРаботниковButton.addMouseListener(adapter);
        редактироватьТаблицуВкладовButton.addMouseListener(adapter);
        редактироватьТаблицуКонтрактовButton.addMouseListener(adapter);
        редактироватьТаблицуИсторийButton.addMouseListener(adapter);




        WindowInitializer.initialize(this, panelMain, EXIT_ON_CLOSE, "Ведение базы данных");
    }

}

