package gui.mid;

import currency.Currency;
import gui.PanelsLoader;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.List;

public class MidPanel extends Component implements PanelsLoader {
    private List<Currency> currencies;
    private JTextArea exchangeResult = new JTextArea("");
    private JTextField amountArea = new JTextField("");
    private JComboBox<String> boxCurrencies = new JComboBox<>();

    public MidPanel(List<Currency> currencies) {
        this.currencies = currencies;
    }

    public Component load(){
        JPanel mid = new JPanel();
        mid.setLayout(new GridLayout(1, 3, 0, 0));
        mid.setBorder(new LineBorder(Color.BLACK, 1));
            mid.add(new MidLeftPanel(amountArea).load());
            mid.add(new MidCenterPanel(currencies, exchangeResult, boxCurrencies).load());
            mid.add(new MidRightPanel(currencies, exchangeResult, amountArea, boxCurrencies).load());

        return mid;
    }
}