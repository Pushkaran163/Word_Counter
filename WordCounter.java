import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WordCounter extends JFrame implements ActionListener {
    // Components of the GUI
    private JTextArea textArea;
    private JLabel wordCountLabel;
    private JLabel charCountLabel;
    private JLabel paragraphCountLabel;
    private JButton countButton;

    public WordCounter() {
        // Create a JFrame container
        super("Word Counter");

        // Set the layout for the frame
        setLayout(new BorderLayout());

        // Initialize components
        textArea = new JTextArea(10, 50);
        wordCountLabel = new JLabel("Words: 0");
        charCountLabel = new JLabel("Characters: 0");
        paragraphCountLabel = new JLabel("Paragraphs: 0");
        countButton = new JButton("Count");

        // Add ActionListener to the button
        countButton.addActionListener(this);

        // Add components to the frame
        add(new JScrollPane(textArea), BorderLayout.CENTER);

        JPanel panel = new JPanel();
        panel.add(wordCountLabel);
        panel.add(charCountLabel);
        panel.add(paragraphCountLabel);
        panel.add(countButton);

        add(panel, BorderLayout.SOUTH);

        // Set frame properties
        setSize(600, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Get text from the text area
        String text = textArea.getText();

        // Calculate word count
        String[] words = text.trim().split("\\s+");
        int wordCount = words.length;

        // Calculate character count
        int charCount = text.length();

        // Calculate paragraph count
        String[] paragraphs = text.split("\\n+");
        int paragraphCount = paragraphs.length;

        // Update labels
        wordCountLabel.setText("Words: " + wordCount);
        charCountLabel.setText("Characters: " + charCount);
        paragraphCountLabel.setText("Paragraphs: " + paragraphCount);
    }

    public static void main(String[] args) {
        // Run the application
        SwingUtilities.invokeLater(() -> new WordCounter());
    }
}