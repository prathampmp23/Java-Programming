package Z_Practice;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleCalculator {
    private JFrame frame;
    private JPanel panel;
    private JTextField textField;
    private JButton[] digitButtons;
    private JButton addButton, subtractButton, multiplyButton, divideButton, percentButton, equalsButton;
    private double firstOperand = 0;
    private String operator = "";

    public SimpleCalculator() {
        frame = new JFrame("Simple Calculator");
        panel = new JPanel();
        textField = new JTextField(20);
        digitButtons = new JButton[10];
        addButton = new JButton("+");
        subtractButton = new JButton("-");
        multiplyButton = new JButton("*");
        divideButton = new JButton("/");
        percentButton = new JButton("%");
        equalsButton = new JButton("=");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLayout(new BorderLayout());

        panel.setLayout(new GridLayout(4, 4));
        for (int i = 0; i < 10; i++) {
            digitButtons[i] = new JButton(String.valueOf(i));
            digitButtons[i].addActionListener(new DigitButtonListener());
            panel.add(digitButtons[i]);
        }
        addButton.addActionListener(new OperatorButtonListener("+"));
        subtractButton.addActionListener(new OperatorButtonListener("-"));
        multiplyButton.addActionListener(new OperatorButtonListener("*"));
        divideButton.addActionListener(new OperatorButtonListener("/"));
        percentButton.addActionListener(new OperatorButtonListener("%"));
        equalsButton.addActionListener(new EqualsButtonListener());

        panel.add(addButton);
        panel.add(subtractButton);
        panel.add(multiplyButton);
        panel.add(divideButton);
        panel.add(percentButton);
        panel.add(equalsButton);

        panel.add(textField);

        frame.add(panel, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    private class DigitButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JButton button = (JButton) e.getSource();
            textField.setText(textField.getText() + button.getText());
        }
    }

    private class OperatorButtonListener implements ActionListener {
        private String operatorSymbol;

        public OperatorButtonListener(String symbol) {
            operatorSymbol = symbol;
        }

        public void actionPerformed(ActionEvent e) {

            if (!textField.getText().isEmpty()) {
                firstOperand = Double.parseDouble(textField.getText());
                operator = operatorSymbol;
                textField.setText("");
            }
        }
    }

    private class EqualsButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (!textField.getText().isEmpty() && !operator.isEmpty()) {
                double secondOperand = Double.parseDouble(textField.getText());
                double result = 0;

                switch (operator) {
                    case "+":
                        result = firstOperand + secondOperand;
                        break;
                    case "-":
                        result = firstOperand - secondOperand;
                        break;
                    case "*":
                        result = firstOperand * secondOperand;
                        break;
                    case "/":
                        if (secondOperand != 0) {
                            result = firstOperand / secondOperand;
                        } else {
                            textField.setText("Error");
                            return;
                        }
                        break;
                    case "%":
                        result = firstOperand % secondOperand;
                        break;
                }
                textField.setText(String.valueOf(result));
                operator = "";
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new SimpleCalculator());
    }
}