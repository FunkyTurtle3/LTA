import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.swing.*;
public class GUI {
    private JFrame frame;
    private GameEngine gameEngine;
    private JTextField inputField;
    private JTextArea outputField;
    private JButton inputButton;

    public GUI(){
        generateWindow();
    }

    private void generateWindow(){
        gameEngine = new GameEngine();
        frame = new JFrame("Leibniz Text Adventure");
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
        inputPanel.setLayout(new BoxLayout(inputPanel, 2));

        inputField = new JTextField();
        inputField.setSize(500, 60);
        inputField.setToolTipText("Eingabe");
        inputPanel.add(inputField);

        inputButton = new JButton("Enter");
        inputButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                executeInput();
            }
        });
        inputPanel.add(inputButton);

        return inputPanel;
    }

    private JPanel generateOutputField(){
        JPanel outputPanel = new JPanel();
        outputPanel.setLayout(new BoxLayout(outputPanel, 1));

        outputField = new JTextArea();
        outputField.setSize(500, 60);
        outputPanel.add(outputField);

        return outputPanel;
    }

    private void executeInput(){
        String input = inputField.getText();
        outputField.setText(outputField.getText() + gameEngine.input(input));
    }
}
