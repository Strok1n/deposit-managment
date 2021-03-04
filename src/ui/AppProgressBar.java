package ui;

import util.WindowInitializer;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class AppProgressBar extends JFrame{
    private JProgressBar progressBar1;
    private JPanel panel1;

    public AppProgressBar(){
        this.setEnabled(false);
        progressBar1.setIndeterminate(true);
        progressBar1.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {

            }
        });
        WindowInitializer.initialize(this, panel1, DISPOSE_ON_CLOSE, "");
    }


}
