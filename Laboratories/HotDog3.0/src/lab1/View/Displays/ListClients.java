package lab1.View.Displays;

import lab1.Model.People.Client.Client;
import lab1.Services.Management;
import lab1.Services.Validations;
import lab1.View.Components.MyLabel;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.util.List;

public class ListClients extends JPanel {

    private DefaultTableModel model = new DefaultTableModel();
    private JTable table = new JTable(model);

    public ListClients(){
        setupComponents();
        addComponents();
        setupComponenetsTable();

    }

    private void setupComponenetsTable(){
        model.setRowCount(0);
        model.setColumnCount(0);

        model.addColumn("Name");
        model.addColumn("Id");

        table.setFont(new Font("Arial", Font.BOLD, 10));
        table.setPreferredScrollableViewportSize(new Dimension(700, 500)); // Largura x Altura
        table.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        table.getColumnModel().getColumn(0).setPreferredWidth(100);
        table.getColumnModel().getColumn(1).setPreferredWidth(10);

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

    private void setupComponents() {
        setBackground(new Color(64, 213, 213));
        setBorder(new LineBorder(Color.black, 3));
        setLayout(new FlowLayout(FlowLayout.CENTER));
    }

    public void addRow(){
        List<Client> clients = Validations.findUsers();
        for (Client client : clients) {
            model.addRow(new Object[]{
                    client.getName(),
                    client.getId()
            });
        }
    }

    public void clearTable(){
        model.setRowCount(0);
        model.setColumnCount(0);
        model.addColumn("Name");
        model.addColumn("Id");
    }

    private void addComponents() {
        add(new MyLabel("Listar clientes"));
    }


}
