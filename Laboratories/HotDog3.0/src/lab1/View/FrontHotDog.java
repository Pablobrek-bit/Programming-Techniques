package lab1.View;

import lab1.View.Components.MyButtons;
import lab1.View.Displays.*;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrontHotDog extends JFrame {

    private final MenuHotDog menuHotDog = new MenuHotDog();
    private final MakingSales makingSales = new MakingSales();
    private final TabelaInfor tabelaInfor = new TabelaInfor();
    private final DisplayReport displayReport = new DisplayReport();
    private final ListClients listClients = new ListClients();
    private final CardLayout cardLayout = new CardLayout();
    private final JPanel cardPanel = new JPanel(cardLayout);

    public FrontHotDog() {
        setupComponents();
        organize();
    }

    public void setupComponents(){
        setSize(800, 800);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(64, 213, 213));
    }

    public void organize() {
        ButtonsLocale buttonsLocale = new ButtonsLocale();
        buttonsLocale.setPreferredSize(new Dimension(800, 75));

        cardPanel.add(menuHotDog, "menu");
        cardPanel.add(makingSales, "realizarVendas");
        cardPanel.add(tabelaInfor, "tabelaInfor");
        cardPanel.add(displayReport, "mostrarRelatorio");
        cardPanel.add(listClients, "listarClientes");

        cardLayout.show(cardPanel, "menu");

        setLayout(new BorderLayout());
        add(buttonsLocale, BorderLayout.NORTH);
        add(cardPanel, BorderLayout.CENTER);
    }

    class ButtonsLocale extends JPanel {
        private final MyButtons bRealizeVendas;
        private final MyButtons bListarVendas;
        private final MyButtons bMostrarRelatorio;
        private final MyButtons bListarClientes;

        public ButtonsLocale() {
            this.setOpaque(false);

            this.setBorder(new LineBorder(Color.black, 3));

            bRealizeVendas = new MyButtons("Realizar Vendas");
            bListarVendas = new MyButtons("Listar Vendas");
            bMostrarRelatorio = new MyButtons("Mostrar Relatorio");
            bListarClientes = new MyButtons("Listar Clientes");

            bRealizeVendas.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    cardLayout.show(cardPanel, "realizarVendas");
                }
            });

            bListarVendas.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println("Limpando table");
                    tabelaInfor.clearTable();
                    System.out.println("Adicionando rows");
                    tabelaInfor.addRow();
                    cardLayout.show(cardPanel, "tabelaInfor");
                }
            });

            bMostrarRelatorio.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    cardLayout.show(cardPanel, "mostrarRelatorio");
                }
            });

            bListarClientes.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    listClients.clearTable();
                    listClients.addRow();
                    cardLayout.show(cardPanel, "listarClientes");
                }
            });

            addButtons();
        }

        private void addButtons() {
            add(bRealizeVendas);
            add(bListarVendas);
            add(bMostrarRelatorio);
            add(bListarClientes);
        }
    }
}

