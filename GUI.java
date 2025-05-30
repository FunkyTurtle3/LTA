import java.awt.*;
import javax.swing.*;
public class GUI {
    private GameEngine gameEngine;
    private JTextField inputField;
    private JTextArea outputField;

    public GUI(){
        generateWindow();
    }

    private void generateWindow(){
        gameEngine = new GameEngine();
        JFrame frame = new JFrame("Leibniz Text Adventure");
        frame.setSize(1000, 1000);
        frame.setResizable(true);

        Container contentPane = frame.getContentPane();

        contentPane.add(generateOutputField(), BorderLayout.CENTER);

        contentPane.add(generateInputField(), BorderLayout.SOUTH);

        frame.pack();
        frame.setVisible(true);
    }

    private JPanel generateInputField(){
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.LINE_AXIS));

        inputField = new JTextField();
        inputField.setSize(500, 60);
        inputField.setToolTipText("Eingabe");
        inputPanel.add(inputField);

        JButton inputButton = new JButton("Enter");
        inputButton.addActionListener(e -> executeInput());
        inputPanel.add(inputButton);

        return inputPanel;
    }

    private JPanel generateOutputField(){
        JPanel outputPanel = new JPanel();

        outputField = new JTextArea();
        outputField.setEditable(false);
        outputField.setSize(500, 60);
        outputPanel.add(outputField);

        return outputPanel;
    }

    private void executeInput(){
        String input = inputField.getText();
        inputField.setText("");
        outputField.setText(outputField.getText() + gameEngine.input(input));
    }
}
