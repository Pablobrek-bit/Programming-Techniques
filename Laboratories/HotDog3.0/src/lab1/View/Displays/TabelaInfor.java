package lab1.View.Displays;

import lab1.Services.Management;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;

public class TabelaInfor extends JPanel{

    private DefaultTableModel model = new DefaultTableModel();
    private JTable table = new JTable(model);

    public TabelaInfor(){
        this.setBackground(new Color(64, 213, 213));
        this.setBorder(new LineBorder(Color.black, 3));

        model.setRowCount(0);
        model.setColumnCount(0);

        model.addColumn("Name");
        model.addColumn("Id");
        model.addColumn("Option-Cheese");
        model.addColumn("Option-Protein");
        model.addColumn("Cheese");
        model.addColumn("Drink");
        model.addColumn("Value");

        table.setFont(new Font("Arial", Font.BOLD, 10));
        table.setPreferredScrollableViewportSize(new Dimension(700, 500)); // Largura x Altura
        table.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        table.getColumnModel().getColumn(0).setPreferredWidth(50);
        table.getColumnModel().getColumn(1).setPreferredWidth(60);
        table.getColumnModel().getColumn(2).setPreferredWidth(140);
        table.getColumnModel().getColumn(3).setPreferredWidth(140);
        table.getColumnModel().getColumn(4).setPreferredWidth(70);
        table.getColumnModel().getColumn(5).setPreferredWidth(50);


        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        table.setDefaultRenderer(Object.class, centerRenderer);
        JTableHeader header = table.getTableHeader();
        header.setFont(new Font("Roboto", Font.BOLD, 22));
        header.setBackground(Color.black);
        header.setForeground(Color.white);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(150, 110, 880, 500);
        add(scrollPane);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);


    }

    public void addRow(){
        for(int i = 0; i < Management.sales.size(); i++){
            model.addRow(new Object[]{
                    Management.sales.get(i).getClient().getName(),
                    Management.sales.get(i).getClient().getId(),
                    Management.sales.get(i).getHotDog().getCheese(),
                    Management.sales.get(i).getHotDog().getProtein(),
                    Management.sales.get(i).getHotDog().getAdditional(),
                    Management.sales.get(i).getHotDog().getDrink(),
                    0
            });
        }
    }

}
