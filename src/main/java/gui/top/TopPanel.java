package gui.top;

import gui.PanelsLoader;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class TopPanel extends Component implements PanelsLoader {
    public Component load(){
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 15));
        topPanel.setBorder(new LineBorder(Color.BLACK, 3));
        topPanel.setBackground(Color.ORANGE);
        topPanel.add(loadComponents());

        return topPanel;
    }

    private Component loadComponents() {
        JLabel info = new JLabel("Exchange Converter");
        info.setFont(new Font(Font.MONOSPACED, 3, 20));
        return info;
    }
}