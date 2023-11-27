package View.Containers;

import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;

public class Warnings extends JPanel {

    private JTextPane warningTextPane;
    private List<String> warningsList;

    public Warnings() {
        setLayout(new BorderLayout());
        setSetup();
        initializeComponents();
    }

    private void initializeComponents() {
        JPanel backgroundPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g.create();
                int alpha = 50;
                g2d.setComposite(AlphaComposite.SrcOver.derive((float) alpha / 255));
                g2d.setColor(getBackground());
                g2d.fill(new Rectangle2D.Double(0, 0, getWidth(), getHeight()));
                g2d.dispose();
            }
        };

        backgroundPanel.setLayout(new BorderLayout());
        backgroundPanel.setOpaque(false);
        add(backgroundPanel);

        JLabel titleLabel = new JLabel("Warnings");
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setVerticalAlignment(JLabel.TOP);
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 16));
        backgroundPanel.add(titleLabel, BorderLayout.NORTH);

        warningTextPane = new JTextPane();
        setupWarningTextPane();
        JScrollPane scrollPane = new JScrollPane(warningTextPane);
        setupScrollPane(scrollPane);
        backgroundPanel.add(scrollPane, BorderLayout.CENTER);

        warningsList = new ArrayList<>();
    }

    private void setupWarningTextPane() {
        warningTextPane.setEditable(false);
        warningTextPane.setOpaque(false);
        StyledDocument doc = warningTextPane.getStyledDocument();

        Style defaultStyle = doc.getStyle(StyleContext.DEFAULT_STYLE);
        Style redStyle = doc.addStyle("RedStyle", defaultStyle);
        StyleConstants.setForeground(redStyle, Color.RED);

        Style greenStyle = doc.addStyle("GreenStyle", defaultStyle);
        StyleConstants.setForeground(greenStyle, Color.GREEN);

        Style blueStyle = doc.addStyle("BlueStyle", defaultStyle);
        StyleConstants.setForeground(blueStyle, new Color(103, 0, 190));

        warningTextPane.setForeground(Color.WHITE);
    }

    private static void setupScrollPane(JScrollPane scrollPane) {
        scrollPane.setPreferredSize(new Dimension(200, 700));
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);
    }

    private void setSetup() {
        setOpaque(false);
        setPreferredSize(new Dimension(200, 700));
    }

    public void addWarning(String warning, String styleName) {
        StyledDocument doc = warningTextPane.getStyledDocument();
        Style style = doc.getStyle(styleName);
        try {
            doc.insertString(doc.getLength(), warning + "\n", style);
        } catch (BadLocationException e) {
            e.printStackTrace();
        }

        warningsList.add(warning);
    }
}
