package lab1.View;

import lab1.View.Components.MyButtons;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrontHotDog extends JFrame {
    private MakingSales makingSales = new MakingSales();
    private TabelaInfor tabelaInfor = new TabelaInfor();
    private DisplayReport displayReport = new DisplayReport();
    private ListClients listClients = new ListClients();
    private CardLayout cardLayout = new CardLayout();
    private JPanel cardPanel = new JPanel(cardLayout);

    public FrontHotDog() {
        setupComponents();
        organize();
    }

    public void setupComponents(){
        this.setSize(800, 800);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(new Color(64, 213, 213));
    }

    public void organize() {
        ButtonsLocale buttonsLocale = new ButtonsLocale();
        buttonsLocale.setPreferredSize(new Dimension(800, 75));

        cardPanel.add(makingSales, "realizarVendas");
        cardPanel.add(tabelaInfor, "tabelaInfor");
        cardPanel.add(displayReport, "mostrarRelatorio");
        cardPanel.add(listClients, "listarClientes");

        cardLayout.show(cardPanel, "realizarVendas");

        setLayout(new BorderLayout());
        add(buttonsLocale, BorderLayout.NORTH);
        add(cardPanel, BorderLayout.CENTER);
    }

    class ButtonsLocale extends JPanel {
        private MyButtons bRealizeVendas;
        private MyButtons bListarVendas;
        private MyButtons bMostrarRelatorio;
        private MyButtons bListarClientes;

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

