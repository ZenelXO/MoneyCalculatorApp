package gui.bottom;

import gui.PanelsLoader;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class BottomPanel extends Component implements PanelsLoader {
    public Component load(){
        JPanel bottom = new JPanel();
        bottom.setLayout(new FlowLayout(FlowLayout.CENTER));
        bottom.setBackground(Color.GRAY);
        bottom.setBorder(new LineBorder(Color.BLACK, 3));
        bottom.add(loadLabel());

        return bottom;
    }

    private Component loadLabel() {
        JLabel info = new JLabel("Money Calculator by Ángel Hernández Ojeda");

        return info;
    }
}
