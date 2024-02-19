import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Random;

public class FortuneTellerFrame extends JFrame
{
    private JLabel titleLabel;
    private JTextArea fortuneArea;
    private JButton readButton;
    private JButton quitButton;
    private ArrayList<String> fortunes;
    private int lastFortuneIndex = -1;

    public FortuneTellerFrame()
    {
        // Set up the JFrame
        super("Fortune Teller");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 600);
        setResizable(false);
        setLocationRelativeTo(null);

        // Load fortunes
        fortunes = new ArrayList<>();
        fortunes.add("Embrace change, as it is the only constant in life.");
        fortunes.add("Your creativity knows no bounds; express it freely.");
        fortunes.add("Success is not just about the destination but the journey; enjoy every step.");
        fortunes.add("A helping hand is always around when you need it; don't hesitate to ask.");
        fortunes.add("Good things come to those who work hard and stay dedicated.");
        fortunes.add("Kindness is a powerful force; share it generously.");
        fortunes.add("Be patient; great things take time to unfold.");
        fortunes.add("Challenge yourself; growth happens outside your comfort zone.");
        fortunes.add("Find joy in the little things; they often lead to the greatest happiness.");
        fortunes.add("Your positive energy attracts positive outcomes.");
        fortunes.add("Forgive and let go; it's the key to inner peace.");
        fortunes.add("Opportunities are like sunrises; if you wait too long, you'll miss them.");


        // Create the components
        titleLabel = new JLabel("Fortune Teller", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 48));
        ImageIcon icon = new ImageIcon ("C:/Users/Nabou/IdeaProjects/FortuneTeller/src/fortune-teller.png");
        titleLabel.setIcon(icon);
        titleLabel.setVerticalTextPosition(JLabel.BOTTOM);
        titleLabel.setHorizontalTextPosition(JLabel.CENTER);

        fortuneArea = new JTextArea();
        fortuneArea.setEditable(false);
        fortuneArea.setFont(new Font("Arial", Font.PLAIN, 24));

        JScrollPane scrollPane = new JScrollPane(fortuneArea);

        readButton = new JButton("Read My Fortune!");
        readButton.setFont(new Font("Arial", Font.BOLD, 24));
        readButton.addActionListener((ActionEvent e) ->
        {
            String fortune = readRandomFortune();
            fortuneArea.append(fortune + "\n");
        });

        quitButton = new JButton("Quit");
        quitButton.setFont(new Font("Arial", Font.BOLD, 24));
        quitButton.addActionListener((ActionEvent e) ->
        {
            System.exit(0);
        });

        // Add the components to the JFrame
        add(titleLabel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(readButton);
        buttonPanel.add(quitButton);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    private String readRandomFortune()
    {
        int index = lastFortuneIndex;
        while (index == lastFortuneIndex)
        {
            index = new Random().nextInt(fortunes.size());
        }
        lastFortuneIndex = index;
        return fortunes.get(index);
    }
}