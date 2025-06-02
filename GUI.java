import java.awt.*;
import java.io.File;
import javax.swing.*;
public class GUI {
    private GameEngine gameEngine;
    private JTextField inputField;
    private JTextArea outputField;
    private Font font;

    public static void main(String[] args){
        new GUI();
    }

    public GUI(){
        setUpFont();
        generateWindow();
    }

    private void setUpFont() {
        try {
            this.font = Font.createFont(Font.TRUETYPE_FONT, new File("assets/font/eleganttypewriter.ttf")).deriveFont(30f);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void generateWindow() {
        this.gameEngine = new GameEngine();
        JFrame frame = new JFrame("Leibniz Text Adventure");
        frame.setUndecorated(true);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        Container contentPane = frame.getContentPane();
        contentPane.add(this.generateOutputField(), "Center");
        contentPane.add(this.generateInputField(), "South");
        frame.setResizable(false);
        frame.setVisible(true);
    }

    private JPanel generateInputField() {
        JPanel inputPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        inputPanel.setPreferredSize(new Dimension(1000, 80));
        inputPanel.setBackground(new Color(168, 218, 220));
        this.inputField = new JTextField();
        this.inputField.setPreferredSize(new Dimension(400, 60));
        this.inputField.addActionListener((e) -> this.executeInput());
        this.inputField.setBackground(new Color(217, 239, 232));
        this.inputField.setBorder(BorderFactory.createLineBorder(new Color(69, 123, 157), 3));
        this.inputField.setFont(this.font);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;          // Dehnt sich horizontal
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(0, 5, 0, 5); // Innenabstand
        inputPanel.add(this.inputField, gbc);
        JButton inputButton = getEnterButton();
        JButton quitButton = getQuitButton();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 0.0;
        gbc.fill = GridBagConstraints.NONE;
        inputPanel.add(inputButton, gbc);
        gbc.anchor = GridBagConstraints.LINE_END;
        gbc.gridx = 2;
        inputPanel.add(quitButton, gbc);
        return inputPanel;
    }

    private JButton getQuitButton() {
        JButton inputButton = new JButton("Spiel schließen");
        inputButton.setPreferredSize(new Dimension(400, 60));
        inputButton.addActionListener((e) -> System.exit(0));
        inputButton.setBackground(new Color(217, 239, 232));
        inputButton.setBorder(BorderFactory.createLineBorder(new Color(69, 123, 157), 3));
        inputButton.setFocusPainted(false);
        inputButton.setFont(this.font);
        inputButton.setFocusable(false);
        return inputButton;
    }

    private JButton getEnterButton() {
        JButton inputButton = new JButton("Eingabe");
        inputButton.setPreferredSize(new Dimension(200, 60));
        inputButton.addActionListener((e) -> this.executeInput());
        inputButton.setBackground(new Color(217, 239, 232));
        inputButton.setBorder(BorderFactory.createLineBorder(new Color(69, 123, 157), 3));
        inputButton.setFont(this.font);
        inputButton.setFocusable(false);
        return inputButton;
    }

    private JScrollPane generateOutputField() {
        JPanel outputPanel = new JPanel();
        this.outputField = new JTextArea();
        this.outputField.setEditable(false);
        this.outputField.setBounds(0, 0, 1000, 900);
        this.outputField.setBackground(new Color(217, 239, 232));
        this.outputField.setForeground(new Color(29, 53, 87));
        this.outputField.setFont(font);
        this.outputField.setEditable(false);
        this.outputField.setFocusable(false);

        JScrollPane scrollOutputPane = new JScrollPane(this.outputField);
        JScrollBar verticalScrollBar = scrollOutputPane.getVerticalScrollBar();
        verticalScrollBar.setUnitIncrement(20);
        verticalScrollBar.setBlockIncrement(50);
        outputPanel.add(scrollOutputPane, new GridLayout());
        return scrollOutputPane;
    }

    private void executeInput() {
        if (!inputField.getText().isEmpty()) {
            outputField.setText(outputField.getText() + gameEngine.input(inputField.getText()));
            inputField.setText("");
        }
    }
}
