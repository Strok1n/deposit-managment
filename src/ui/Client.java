package ui;

import util.WindowInitializer;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Client extends JFrame{
    private JButton снятьНаличныеСНакопившихсяButton;
    private JButton посмотретьИсториюСнятияПроцентовButton;
    private JButton снятьВсюСуммуВкладаButton;
    private JButton посмотретьИсториюКонтрактовОButton;
    private JPanel mainPanel;


    public Client(){

        снятьНаличныеСНакопившихсяButton
                .addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        super.mouseClicked(e);

                    }
                });

        WindowInitializer.initialize(this, mainPanel,
                EXIT_ON_CLOSE, "Управление вашими вкладами");
    }


}
