import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.InputStream;
import java.util.LinkedList;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.plaf.basic.BasicScrollBarUI;

/**
 * @author (Lasse, Leander, Victor)
 * @version 1.1.0
 * Viel Hilfe und inspiration durch https://www.chatgpt.com.
 * Auch Hilfe bei https://docs.oracle.com.
 * Das Graphical User Interface ist dafür zuständig dem Spieler anzuzeigen was die GameEngine (Attribut) ausgibt.
 */
public class GUI implements KeyListener {
    private String startDescription;
    private final GameEngine gameEngine;
    private JFrame frame;
    private JTextField inputField;
    private JTextArea outputField;
    private JTextArea inventoryField;
    private Font fontNormal;
    private Font fontBig;
    private Font fontSmall;
    private final LinkedList<String> arguments; //Diese List speicher alle Eingaben um sie wiederverwenden zu können
    private int argument; //Wird benutzt, um die Argumente nacheinander wiederzufinden
    private final double width;
    private final double height;

    /**
     * Zum Starten aufgerufene Methode
     */
    public static void main(String[] args){
        new GUI();
    }

    /**
     * Konstruktor für die GUI Klasse
     * @author (Lasse, Leander)
     */public GUI(){
        this.arguments = new LinkedList<>();
        this.argument = 0;
        setUpFont();
        this.gameEngine = new GameEngine();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.width = screenSize.getWidth();
        this.height = screenSize.getHeight();
        createWindow();
        setUpLogo();
        setStartDescription();
        this.outputField.setText(startDescription);
        this.inventoryField.setText("Dein Inventar:\n" + this.gameEngine.getInventoryDescription());
    }

    private void setStartDescription(){
         startDescription = """
                 Willkommen im Leibniz-Text-Adventure!
                 Du bist AbiturientIn am Leibniz Gymnasium und stehst gerade mit allen
                 anderen AbiturientInnen auf dem Schulhof. Ihr lauscht gespannt der Rede
                 eurer Direktorin Frau Krollpfeiffer-Kuhring.
                 
                 Frau Krollpfeiffer-Kuhring:
                 "Liebe Abiturientinnen und Abiturienten,
                 Kolleginnen und Kollegen,
                 
                 heute ist ein ganz besonderer Tag
                 für euch, liebe AbiturientInnen, aber auch für uns LehrerInnen
                 und natürlich für mich als eure Schulleiterin.
                 
                 Nach 12 oder 13 Jahren Schule werdet ihr heute
                 das Abiturzeugnis in der Hand halten – ein Symbol für
                 Wissen, Ausdauer, für bestandene Prüfungen, für persönliche Entwicklung
                 und unzählige Momente, die euch geprägt haben.
                 Herzlichen Glückwunsch zu dieser großartigen Leistung!
                 
                 Dieses Jahr wird die Zeugnisverleihung jedoch etwas anders ablaufen!
                 Ihr dürft euch in Gruppen oder alleine darin beweisen,
                 wie gut ihr diese Schule kennt. Im gesamten Gebäude befinden sich
                 Lehrer, die bereits auf euch warten. Denn heute müsst ihr
                 ein Quiz zu dieser Schule und dem diesjährigen Jubiläum beantworten!
                 Nachdem ihr das erfolgreich getan habt, erhaltet ihr euer Abiturzeugnis.
                 
                 Begebt euch zum Starten des Spiels bitte alle in die Aula!
                 (Gib dafür unten "Starte Spiel" ein und klicke auf Eingabe)
                 Viel Glück!
                 
                 TIPP: Gibst du "Info" in die Befehlszeile ein so werden sämtliche Befehle
                 die zum Lösen des Quiz relevant sind erläutert.
                 """;
    }

    /**
     * Verändert das logo des Fenster - rein kosmetisch
     * Logo kreiert mit https://www.figma.com
     */
    private void setUpLogo() {
        try {
            InputStream imageStream = GUI.class.getResourceAsStream("/assets/textures/logo.png");
            Image icon = ImageIO.read(imageStream);
            frame.setIconImage(icon);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        //Hilfe von https://www.chatgpt.com
    }

    /**
     * Macht den importierten "elegantTypewriter" Font für die GUI nutzbar.
     * Die importierte Schriftart ist frei nutzbar für nicht-kommerzielle Zwecke.
     * Rein kosmetischer Natur
     * @author (Lasse, Victor)
     */private void setUpFont() {
        try {
            InputStream Fontstream = GUI.class.getResourceAsStream("/assets/font/ElegantTypewriter.ttf");
            Font font = Font.createFont(Font.TRUETYPE_FONT, Fontstream);
            this.fontNormal = font.deriveFont(30f);
            this.fontBig = font.deriveFont(40f);
            this.fontSmall = font.deriveFont(25f);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        //Hilfe von https://www.chatgpt.com
    }

    /**
     * Methode mit der das Fenster generiert und ausgegeben wird
     * @author (Lasse, Leander, Victor)
     */private void createWindow() {
        this.frame = new JFrame("Leibniz Text Adventure");
        frame.setUndecorated(true);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setBackground(new Color(69, 123, 157));
        frame.setName("Leibniz Text Adventure");
        Container contentPane = frame.getContentPane();
        contentPane.add(this.createInputField(), "South");
        contentPane.add(this.createOutputField(), "Center");
        frame.setResizable(false);
        frame.setVisible(true);
    }

    /**
     * Methode mit der das Eingabefeld generiert und ausgegeben wird
     * @author (Lasse, Leander, Victor)
     */private JPanel createInputField() {
        JPanel inputPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        inputPanel.setPreferredSize(new Dimension((int) (this.width * ((double) 7 /10)), (int) (height / 10)));
        inputPanel.setBackground(new Color(168, 218, 220));
        inputPanel.setBorder(BorderFactory.createLineBorder(new Color(69, 123, 157), 3));
        this.inputField = new JTextField();
        this.inputField.setMinimumSize(new Dimension((int) (this.width * ((double) 20 /100)), (int) (this.height * ((double) 1 /12))));
        this.inputField.setMaximumSize(new Dimension((int) (this.width * ((double) 20 /100)), (int) (this.height * ((double) 1 /12))));
        this.inputField.setPreferredSize(new Dimension((int) (this.width * ((double) 20 /100)), (int) (this.height * ((double) 1 /12))));
        this.inputField.addActionListener((e) -> this.executeInput());
        this.inputField.addKeyListener(this);
        this.inputField.setBackground(new Color(217, 239, 232));
        this.inputField.setBorder(BorderFactory.createLineBorder(new Color(69, 123, 157), 3));
        this.inputField.setFont(this.fontBig);
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
        //Grafiken von https://www.chatgpt.com
        inputPanel.add(quitButton, gbc);
        return inputPanel;
    }

    /**
     * Methode mit welcher der "Spiel schließen"-Knopf generiert und ausgegeben wird
     * @author (Lasse, Leander, Victor)
     */private JButton createQuitButton() {
        JButton inputButton = new JButton("Spiel schließen");
        inputButton.setMinimumSize(new Dimension((int) (this.width * ((double) 20 /100)), (int) (this.height * ((double) 1 /12))));
        inputButton.setMaximumSize(new Dimension((int) (this.width * ((double) 20 /100)), (int) (this.height * ((double) 1 /12))));
        inputButton.setPreferredSize(new Dimension((int) (this.width * ((double) 20 /100)), (int) (this.height * ((double) 1 /12))));
        inputButton.addActionListener((e) -> System.exit(0));
        inputButton.setBackground(new Color(217, 239, 232));
        inputButton.setBorder(BorderFactory.createLineBorder(new Color(69, 123, 157), 3));
        inputButton.setFocusPainted(false);
        inputButton.setFont(this.fontBig);
        inputButton.setFocusable(false);
        return inputButton;
    }

    /**
     * Methode mit welcher der Eingabe-Knopf generiert und ausgegeben wird
     * @author (Lasse, Leander, Victor)
     */private JButton createEnterButton() {
        JButton inputButton = new JButton("Eingabe");
        inputButton.setMinimumSize(new Dimension((int) (this.width * ((double) 20 /100)), (int) (this.height * ((double) 1 /12))));
        inputButton.setMaximumSize(new Dimension((int) (this.width * ((double) 20 /100)), (int) (this.height * ((double) 1 /12))));
        inputButton.setPreferredSize(new Dimension((int) (this.width * ((double) 20 /100)), (int) (this.height * ((double) 1 /12))));
        inputButton.addActionListener((e) -> this.executeInput());
        inputButton.setBackground(new Color(217, 239, 232));
        inputButton.setBorder(BorderFactory.createLineBorder(new Color(69, 123, 157), 3));
        inputButton.setFont(this.fontBig);
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
        this.outputField.setFont(fontSmall);
        this.outputField.setEditable(false);

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
        
        scrollOutputPane.setPreferredSize(new Dimension((int) (this.width * ((double) 7 /10)), (int) (this.height * ((double) 9 /10))));
        scrollOutputPane.setBorder(BorderFactory.createLineBorder(new Color(69, 123, 157), 3));
        
        JPanel previewPanel = new JPanel(new BorderLayout());
        previewPanel.setPreferredSize(new Dimension((int) (this.width * ((double) 3 /10)), (int) (this.height * ((double) 9 /10))));

        JTextArea notesField = new JTextArea("Hier hast du Platz für Notizen");
        notesField.setBorder(BorderFactory.createLineBorder(new Color(69, 123, 157), 3));
        notesField.setBackground(new Color(217, 239, 232));
        notesField.setForeground(new Color(29, 53, 87));
        notesField.setFont(fontNormal);
        notesField.setPreferredSize(new Dimension((int) (this.width - scrollOutputPane.getWidth()), (int) (this.height * ((double) 45 /100))));

        this.inventoryField = new JTextArea();
        this.inventoryField.setBorder(BorderFactory.createLineBorder(new Color(69, 123, 157), 3));
        this.inventoryField.setBackground(new Color(217, 239, 232));
        this.inventoryField.setForeground(new Color(29, 53, 87));
        this.inventoryField.setFont(fontNormal);
        this.inventoryField.setEditable(false);
        this.inventoryField.setPreferredSize(new Dimension((int) (this.width * ((double) 3 /10)), (int) (this.height * ((double) 45 /100))));

        previewPanel.add(notesField, BorderLayout.NORTH);
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
            this.arguments.addFirst(inputField.getText());
            this.argument = 0;
        }
        if (this.inputField.getText().equalsIgnoreCase("starte neu")) this.outputField.setText(startDescription);
        this.inputField.setText("");
        this.inventoryField.setText("Dein Inventar:\n" + this.gameEngine.getInventoryDescription());
    }

    public void keyTyped(KeyEvent e) {
        //nicht benötigt aber durch Interface vorgegeben
    }

    /**
     * Ermöglicht es mit den Pfeiltasten (oben und unten) zwischen vorherigen Eingaben zu wechseln um das Spielgeschehen zu beschleunigen und tippen zu ersparen
     * @author (LAsse, Leander)
     */
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == 38 && this.arguments.size() > this.argument) {
            this.inputField.setText(this.arguments.get(this.argument));
            this.argument++;
        }
        if(e.getKeyCode() == 40 && this.argument > 0) {
            this.argument--;
            this.inputField.setText(this.arguments.get(this.argument));
        }
    }

    public void keyReleased(KeyEvent e) {
        //nicht benötigt aber durch Interface vorgegeben
    }
}