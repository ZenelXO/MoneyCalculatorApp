package gui.mid;

import currency.Currency;
import gui.PanelsLoader;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class MidCenterPanel extends Component implements PanelsLoader {
    public List<Currency> currencies;
    public JTextArea exchangeResult;
    public JComboBox<String> boxCurrencies;

    public MidCenterPanel(List<Currency> currencies, JTextArea exchangeResult, JComboBox<String> boxCurrencies) {
        this.currencies = currencies;
        this.exchangeResult = exchangeResult;
        this.boxCurrencies = boxCurrencies;
    }

    public Component load(){
        JPanel mid = new JPanel();
        mid.setLayout(new FlowLayout(FlowLayout.CENTER));
        mid.setBackground(Color.white);
            mid.add(loadLabel());
            mid.add(loadComboBox());
            mid.add(loadSpace());
            mid.add(loadTextArea());

        return mid;
    }

    private Component loadTextArea() {
        exchangeResult.setEditable(false);
        exchangeResult.setText("");
        return exchangeResult;
    }

    private Component loadSpace() {
        JTextArea exchangeArea = new JTextArea();
        exchangeArea.setEditable(false);
        exchangeArea.setPreferredSize(new Dimension(350,150));
        return exchangeArea;
    }

    private Component loadComboBox() {
        List<String> listofCurrencies = new ArrayList<>();
        for(Currency i : currencies){
            listofCurrencies.add(i.getKey() + "-" + i.getName());
        }

        for(String i : listofCurrencies){
            boxCurrencies.addItem(i);
        }

        return boxCurrencies;
    }

    private Component loadLabel() {
        JLabel from = new JLabel("From: ");
        return from;
    }
}