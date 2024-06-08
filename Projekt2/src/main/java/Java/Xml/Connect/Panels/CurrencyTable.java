package Java.Xml.Connect.Panels;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.List;

public class CurrencyTable extends JTable {
    DefaultTableModel dtm;
    public CurrencyTable(String[] hodnoty) {
        dtm = new DefaultTableModel();
        dtm.setRowCount(12);
        dtm.setColumnCount(3);
        setModel(dtm);
        for(int i = 0; i<12;i++){
            setValueAt(hodnoty[i],i,0);
        }
    }

    public void setValues(List<Integer> cisla){
        for(int i = 0; i < 12; i++){
            setValueAt(cisla.get(i),11-i,2);
        }
    }

}
