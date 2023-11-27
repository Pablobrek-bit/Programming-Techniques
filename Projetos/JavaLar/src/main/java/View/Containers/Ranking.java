package View.Containers;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.List;

public class Ranking extends JPanel {

    private JTextArea rankingTextArea;

    public Ranking() {
        setLayout(new BorderLayout());
        setSetup();
        initializeComponents();
    }

    private void initializeComponents() {

        JLabel titleLabel = new JLabel("Ranking");
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setVerticalAlignment(JLabel.TOP);
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 16));

        rankingTextArea = new JTextArea();
        setupRankingTextArea();

        JScrollPane scrollPane = new JScrollPane(rankingTextArea);
        setupScrollPane(scrollPane);

        add(titleLabel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
    }

    private void setupRankingTextArea() {
        rankingTextArea.setEditable(false);
        rankingTextArea.setLineWrap(true);
        rankingTextArea.setWrapStyleWord(true);
        rankingTextArea.setOpaque(false);
        rankingTextArea.setForeground(Color.WHITE);
        rankingTextArea.setFont(new Font("SansSerif", Font.BOLD, 14));
    }

    private static void setupScrollPane(JScrollPane scrollPane) {
        scrollPane.setPreferredSize(new Dimension(200, 700));
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);
    }

    public void setSetup() {
        setOpaque(false);
        setPreferredSize(new Dimension(200, 700));
    }

    public void updateRanking(List<String> rankedNames) {
        StringBuilder rankingText = new StringBuilder();
        for (int i = 0; i < rankedNames.size(); i++) {
            rankingText.append(i + 1).append(". ").append(rankedNames.get(i)).append("\n");
        }
        rankingTextArea.setText(rankingText.toString());
    }
}
