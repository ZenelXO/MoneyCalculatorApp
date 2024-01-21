import currency.Currency;
import currency.FileLoader;
import gui.MainFrame;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        //Currencies loader
        FileLoader file = new FileLoader(new File("currencies.tsv"));
        List<Currency> currencies = file.loadAll();

        //Interface
        Image icon = new ImageIcon("icono.png").getImage();
        MainFrame display = new MainFrame(icon, currencies);
        display.setVisible(true);
    }
}