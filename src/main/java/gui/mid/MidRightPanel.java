package gui.mid;

import currency.Currency;
import gui.ExchangeConverter;
import gui.ExchangeConverterLoader;
import gui.PanelsLoader;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MidRightPanel extends Component implements PanelsLoader {
    private List<Currency> currencies;
    private JTextArea exchangeResult;
    private JTextField amountArea;
    private JComboBox<String> boxCurrencies;
    private JComboBox<String> to;

    public MidRightPanel(List<Currency> currencies, JTextArea exchangeResult, JTextField amountArea, JComboBox<String> boxCurrencies) {
        this.currencies = currencies;
        this.exchangeResult = exchangeResult;
        this.amountArea = amountArea;
        this.boxCurrencies = boxCurrencies;
    }



    public Component load(){
        JPanel right = new JPanel();
        right.setLayout(new FlowLayout());
        right.setBackground(Color.white);
            right.add(loadLabel());
            right.add(loadComboBox());
            right.add(loadSpace());
            right.add(loadCalculateButton(exchangeResult));

        return right;
    }

    private Component loadSpace() {
        JTextArea exchangeArea = new JTextArea();
        exchangeArea.setEditable(false);
        exchangeArea.setPreferredSize(new Dimension(300,150));
        return exchangeArea;
    }

    private Component loadCalculateButton(JTextArea exchangeResult) {
        JButton calculate = new JButton("Convert Money");
        calculate.addActionListener(addAction());
        return calculate;
    }

    private Component loadLabel() {
        JLabel to = new JLabel("To: ");
        return to;
    }

    private Component loadComboBox() {
        List<String> listofCurrencies = new ArrayList<>();
        for(Currency i : currencies){
            listofCurrencies.add(i.getKey() + "-" + i.getName());
        }
        String[] result = listofCurrencies.toArray(new String[0]);

        to = new JComboBox<>(result);
        to.setPreferredSize(new Dimension(335,25));
        return to;
    }

    public ActionListener addAction(){
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(amountArea.getText().isEmpty()){
                    exchangeResult.setText("");
                    JFrame frame = new JFrame();
                    JOptionPane.showMessageDialog(frame, "Introduce un número.");
                }else{
                    try{
                        double amount = Double.parseDouble(amountArea.getText());
                        String base = boxCurrencies.getSelectedItem().toString();
                        String symbol = to.getSelectedItem().toString();
                        ExchangeConverterLoader result = new ExchangeConverter(base, symbol, amount);
                        try {
                            exchangeResult.setFont(new Font("Arial", Font.BOLD, 14));
                            exchangeResult.setText(amount + " " + base + " = " + result.calculate() + " " + symbol);
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                    } catch (NumberFormatException numberFormatException) {
                        JFrame frame = new JFrame();
                        JOptionPane.showMessageDialog(frame, "Usa el punto como separador decimal.");
                    }
                }
            }
        };
    }
}