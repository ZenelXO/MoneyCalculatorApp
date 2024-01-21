package gui.mid;

import gui.PanelsLoader;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Currency;
import java.util.List;

public class MidLeftPanel extends Component implements PanelsLoader {
    public JTextField amountArea;

    public MidLeftPanel(JTextField amountArea) {
        this.amountArea = amountArea;
    }

    public Component load(){
        JPanel left = new JPanel();
        left.setLayout(new FlowLayout(FlowLayout.CENTER));
        left.setBackground(Color.white);
            left.add(loadLabel());
            left.add(loadTextArea());

        return left;
    }

    private Component loadTextArea() {
        amountArea.setPreferredSize(new Dimension(320,25));
        return amountArea;
    }

    private Component loadLabel() {
        List<Currency> currencies = new ArrayList<>();
        JLabel amount = new JLabel("Amount:");
        return amount;
    }
}