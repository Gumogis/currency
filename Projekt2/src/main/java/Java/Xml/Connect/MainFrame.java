package Java.Xml.Connect;

import Java.Xml.Connect.Panels.CurrencyTable;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainFrame extends JFrame {

    private final CurrencyTable currencyTable;
    private final JPanel buttonPanel;
    private final JButton vycetka;
    private final JButton zadaniHodnot;
    private final List<Integer> cisla = new ArrayList<>();
    private final String[] hodnoty = new String[]{"1","2","5","10","20","50","100","200","500","1000","2000","5000"};

    public MainFrame() {



        setVisible(true);
        setTitle("Zkouska");
        setBackground(Color.black);
        setLayout(new BorderLayout());
        setMinimumSize(new Dimension(500,500));
        setExtendedState(Frame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        currencyTable = new CurrencyTable(hodnoty);
        add(currencyTable,BorderLayout.CENTER);
        buttonPanel = new JPanel();
        add(buttonPanel,BorderLayout.NORTH);
        vycetka = new JButton();
        vycetka.setText("Výčetka");
        buttonPanel.add(vycetka);
        zadaniHodnot = new JButton();
        zadaniHodnot.setText("zadání hodnot");
        buttonPanel.add(zadaniHodnot);

        zadaniHodnot.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int penize = Integer.parseInt(JOptionPane.showInputDialog("Zadejte číslo na rozpočítání"));
                cisla.clear();
                cisla.add(penize/5000);
                penize%=5000;
                cisla.add(penize/2000);
                penize%=2000;
                cisla.add(penize/1000);
                penize%=1000;
                cisla.add(penize/500);
                penize%=500;
                cisla.add(penize/200);
                penize%=200;
                cisla.add(penize/100);
                penize%=100;
                cisla.add(penize/50);
                penize%=50;
                cisla.add(penize/20);
                penize%=20;
                cisla.add(penize/10);
                penize%=10;
                cisla.add(penize/5);
                penize%=3;
                cisla.add(penize/2);
                penize%=2;
                cisla.add(penize);

                currencyTable.setValues(cisla);
            }
        });

        vycetka.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    File myObj = new File("C:\\skibidi\\vycetka.txt");
                    FileWriter myWriter = new FileWriter("C:\\skibidi\\vycetka.txt");
                    myWriter.write("Hodnota" + "\t\t" + "Počet bankovek a mincí");
                    for(int i = 0; i < 12; i++){
                        myWriter.write("\n" + hodnoty[i] + "\t\t" + cisla.get(11-i));
                    }
                    myWriter.close();
                    myObj.createNewFile();
                } catch (IOException s) {
                    System.out.println("Error");
                    s.printStackTrace();
                }
            }
        });

    }
}
