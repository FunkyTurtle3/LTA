import java.awt.*;
import java.io.File;
import javax.swing.*;
import javax.swing.plaf.basic.BasicScrollBarUI;
/**
 * @author (Lasse, Leander, Victor)
 * @version 1.1.0
 * Das Graphical User Interface ist dafür zuständig dem Spieler anzuzeigen was die GameEngine (Attribut) ausgibt.
 */
public class GUI {
    private static final String START_DESCRIPTION = "\nWillkommen zum Leibniz Text Abenteuer!\n\nHier lernst du die Schule besser kennen, möchtest du das Spiel starten?\nDann schreibe \"Starte Spiel\" in das Feld unten\n";
    private final GameEngine gameEngine;
    private JTextField inputField;
    private JTextArea outputField;
    private JTextArea inventoryField;
    private Font font;
    public static void main(String[] args){
        new GUI();
    }

    /**
     * Konstruktor für die GUI Klasse
     * @author (Lasse, Leander)
     */public GUI(){
        setUpFont();
        this.gameEngine = new GameEngine();
        createWindow();
        this.outputField.setText(START_DESCRIPTION);
        this.inventoryField.setText("Dein Inventar:\n" + this.gameEngine.getInventoryDescription());
    }

    /**
     * Macht den importierten "elegantTypewriter" Font für die GUI nutzbar.
     * Die importierte Schriftart ist frei nutzbar für nicht-kommerzielle Zwecke.
     * @author (Lasse, Victor)
     */private void setUpFont() {
        try {
            this.font = Font.createFont(Font.TRUETYPE_FONT, new File("assets/font/eleganttypewriter.ttf")).deriveFont(30f);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Methode mit der das Fenster generiert und ausgegeben wird
     * @author (Lasse, Leander, Victor)
     */private void createWindow() {
        JFrame frame = new JFrame("Leibniz Text Adventure");
        frame.setUndecorated(true);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        Container contentPane = frame.getContentPane();
        contentPane.add(this.createOutputField(), "Center");
        contentPane.add(this.createInputField(), "South");
        frame.setResizable(false);
        frame.setVisible(true);
    }

    /**
     * Methode mit der das Eingabefeld generiert und ausgegeben wird
     * @author (Lasse, Leander, Victor)
     */private JPanel createInputField() {
        JPanel inputPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        inputPanel.setPreferredSize(new Dimension(1000, 80));
        inputPanel.setBackground(new Color(168, 218, 220));
        inputPanel.setBorder(BorderFactory.createLineBorder(new Color(69, 123, 157), 3));
        this.inputField = new JTextField();
        this.inputField.setPreferredSize(new Dimension(400, 60));
        this.inputField.addActionListener((e) -> this.executeInput());
        this.inputField.setBackground(new Color(217, 239, 232));
        this.inputField.setBorder(BorderFactory.createLineBorder(new Color(69, 123, 157), 3));
        this.inputField.setFont(this.font);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(0, 5, 0, 5);
        inputPanel.add(this.inputField, gbc);
        JButton inputButton = createEnterButton();
        JButton quitButton = createQuitButton();
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

    /**
     * Methode mit welcher der "Spiel schließen"-Knopf generiert und ausgegeben wird
     * @author (Lasse, Leander, Victor)
     */private JButton createQuitButton() {
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

    /**
     * Methode mit welcher der Eingabe-Knopf generiert und ausgegeben wird
     * @author (Lasse, Leander, Victor)
     */private JButton createEnterButton() {
        JButton inputButton = new JButton("Eingabe");
        inputButton.setPreferredSize(new Dimension(200, 60));
        inputButton.addActionListener((e) -> this.executeInput());
        inputButton.setBackground(new Color(217, 239, 232));
        inputButton.setBorder(BorderFactory.createLineBorder(new Color(69, 123, 157), 3));
        inputButton.setFont(this.font);
        inputButton.setFocusable(false);
        return inputButton;
    }

    /**
     * Methode mit der das Ausgabefeld generiert und ausgegeben wird
     * @author (Lasse, Leander, Victor)
     */private JPanel createOutputField() {
        JPanel outputPanel = new JPanel(new GridBagLayout());
        this.outputField = new JTextArea();
        this.outputField.setEditable(false);
        this.outputField.setBackground(new Color(217, 239, 232));
        this.outputField.setForeground(new Color(29, 53, 87));
        this.outputField.setFont(font);
        this.outputField.setEditable(false);
        this.outputField.setFocusable(false);

        JScrollPane scrollOutputPane = new JScrollPane(this.outputField);
        JScrollBar verticalScrollBar = scrollOutputPane.createVerticalScrollBar();
        verticalScrollBar.setUnitIncrement(20);
        verticalScrollBar.setBlockIncrement(50);
        //noch zu verstehen
        verticalScrollBar.setUI(createScrollBar());
        scrollOutputPane.setVerticalScrollBar(verticalScrollBar);
        JScrollBar horizontalScrollBar = scrollOutputPane.createHorizontalScrollBar();
        horizontalScrollBar.setUnitIncrement(20);
        horizontalScrollBar.setBlockIncrement(50);
        //noch zu verstehen
        horizontalScrollBar.setUI(createScrollBar());
        scrollOutputPane.setHorizontalScrollBar(horizontalScrollBar);

        scrollOutputPane.setPreferredSize(new Dimension(1300, 1000));
        scrollOutputPane.setBorder(BorderFactory.createLineBorder(new Color(69, 123, 157), 3));

        JPanel previewPanel = new JPanel(new BorderLayout());
        previewPanel.setPreferredSize(new Dimension(620, 1000));

        JTextArea locationField = new JTextArea();
        locationField.setBorder(BorderFactory.createLineBorder(new Color(69, 123, 157), 3));
        locationField.setBackground(new Color(217, 239, 232));
        locationField.setForeground(new Color(29, 53, 87));
        locationField.setFont(font);
        locationField.setEditable(false);
        locationField.setFocusable(false);
        locationField.setPreferredSize(new Dimension(620, 500));

        this.inventoryField = new JTextArea();
        this.inventoryField.setBorder(BorderFactory.createLineBorder(new Color(69, 123, 157), 3));
        this.inventoryField.setBackground(new Color(217, 239, 232));
        this.inventoryField.setForeground(new Color(29, 53, 87));
        this.inventoryField.setFont(font);
        this.inventoryField.setEditable(false);
        this.inventoryField.setFocusable(false);
        this.inventoryField.setPreferredSize(new Dimension(620, 500));

        previewPanel.add(locationField, BorderLayout.NORTH);
        previewPanel.add(this.inventoryField, BorderLayout.SOUTH);

        outputPanel.add(scrollOutputPane);
        outputPanel.add(previewPanel);
        return outputPanel;
    }

    /**
     * Erstellt einen Button ohne Aussehen und Inhalt um ihn entsprechend anzuzeigen ohne, dass er sichtbar ist
     * @author (Lasse, Leander)
     * @sources (Hilfe von ChatGPT)
     */
    private JButton createZeroButton() {
        JButton button = new JButton();
        button.setPreferredSize(new Dimension(0, 0));
        button.setMinimumSize(new Dimension(0, 0));
        button.setMaximumSize(new Dimension(0, 0));
        return button;
    }

    /**
     * Methode mit der, eine ScrollBar generiert und ausgegeben wird
     * @author (Lasse, Leander)
     * @sources (Hilfe von ChatGPT)
     */private BasicScrollBarUI createScrollBar() {
        return new BasicScrollBarUI() {
            @Override
            protected void configureScrollBarColors() {
                this.thumbColor = new Color(168, 218, 220);   // Farbe des Schiebers
                this.trackColor = new Color(217, 239, 232);   // Farbe der Bahn
            }

            @Override
            protected void paintThumb(Graphics g, JComponent c, Rectangle thumbBounds) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setColor(thumbColor);
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.fillRoundRect(thumbBounds.x, thumbBounds.y, thumbBounds.width, thumbBounds.height, 10, 10);
                g2.dispose();
            }

            @Override
            protected JButton createDecreaseButton(int orientation) {
                return createZeroButton();
            }

            @Override
            protected JButton createIncreaseButton(int orientation) {
                return createZeroButton();
            }
        };
    }

    /**
     * Methode durch die der GameEngine der Abruf zur Verarbeitung eines Inputs gegeben wird
     * @author (Lasse, Leander)
     */private void executeInput() {
        if (!this.inputField.getText().isEmpty()) {
            this.outputField.setText(this.outputField.getText() + this.gameEngine.input(this.inputField.getText()));
        }
        if (this.inputField.getText().equalsIgnoreCase("starte neu")) this.outputField.setText(START_DESCRIPTION);
        this.inputField.setText("");
        this.inventoryField.setText("Dein Inventar:\n" + this.gameEngine.getInventoryDescription());
    }
}