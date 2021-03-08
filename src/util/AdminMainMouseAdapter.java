package util;

import ui.MainTable;
import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

public class AdminMainMouseAdapter extends MouseAdapter {

    private final JFrame backFrame;

    public AdminMainMouseAdapter(JFrame backFrame){
     this.backFrame = backFrame;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        super.mouseClicked(e);
        Vector<String> vector = new Vector<>();
        String str = "Редактировать таблицу ";
        vector.add(str + "паспортов");
        vector.add(str + "клиентов");
        vector.add(str + "валют");
        vector.add(str + "должностей");
        vector.add(str + "работников");
        vector.add(str + "вкладов");
        vector.add(str + "контрактов");
        vector.add(str + "историй");
        StringBuilder builder = new StringBuilder(e.getSource().toString());
        String target = ",text";
        int i = builder.indexOf(target);
        int j = builder.indexOf(",", i + 1);
        backFrame.setEnabled(false);
        new MainTable(backFrame,vector.indexOf((String) builder.subSequence(i + target.length() + 1 ,j)));
    }
}
