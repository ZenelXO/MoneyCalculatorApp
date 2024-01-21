package gui;

import currency.Currency;
import gui.bottom.BottomPanel;
import gui.mid.MidPanel;
import gui.top.TopPanel;
import javax.swing.*;
import java.awt.*;
import java.util.List;

public class MainFrame extends JFrame {
    private final Image icon;
    private List<Currency> currencies;
    public MainFrame(Image icon, List<Currency> currencies){
        this.icon = icon;
        this.currencies = currencies;

        this.setTitle("Money Calculator");
        this.setIconImage(icon);
        this.setSize(1100,400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);

        //Main Container
        Container mainContainer = this.getContentPane();
        mainContainer.setLayout(new BorderLayout());
        mainContainer.setBackground(Color.GRAY);
            //Top Panel------------------------------------------------------------
            mainContainer.add(new TopPanel().load(), BorderLayout.NORTH);
            //Mid Panel------------------------------------------------------------
            mainContainer.add(new MidPanel(currencies).load(), BorderLayout.CENTER);
            //Bottom Panel---------------------------------------------------------
            mainContainer.add(new BottomPanel().load(), BorderLayout.SOUTH);
    }
}