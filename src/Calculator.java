import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;

public class Calculator implements ActionListener {

    JFrame frame;
    JTextField textField;
    JButton[] numberButtons = new JButton[10];
    JButton[] functionButtons = new JButton[20];
    JButton addButton, subButton, mulButton, divButton;
    JButton equButton, delButton, clrButton;
    JButton cosButton, sinButton, tanButton, cotButton, logButton, lnButton, sqrtButton, modButton;
    //decButton adds . and parenButtons to add ()
    JButton decButton, leftParenButton, rightParenButton;
    JButton eButton, piButton;
    JPanel panel;

    Font myFont = new Font("Sans-serif", Font.BOLD, 16);

    public Calculator() {

        frame = new JFrame("Scientific Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(550, 600);
        frame.setLayout(null);

        textField = new JTextField();
        textField.setBounds(50, 25, 450, 50);
        textField.setFont(myFont);
        textField.setEditable(false);

        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(".");
        equButton = new JButton("=");
        delButton = new JButton("Del");
        clrButton = new JButton("AC"); //clear

        sinButton = new JButton("sin");
        cosButton = new JButton("cos");
        tanButton = new JButton("tan");
        cotButton = new JButton("cot");
        logButton = new JButton("log");
        lnButton = new JButton("ln");
        sqrtButton = new JButton("\u221A"); //sqrt
        leftParenButton = new JButton("(");
        rightParenButton = new JButton(")");
        piButton = new JButton("\u03C0"); // pi
        eButton = new JButton("e");
        modButton = new JButton("%");

        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = decButton;
        functionButtons[5] = equButton;
        functionButtons[6] = delButton;
        functionButtons[7] = clrButton;
        functionButtons[8] = sinButton;
        functionButtons[9] = cosButton;
        functionButtons[10] = tanButton;
        functionButtons[11] = cotButton;
        functionButtons[12] = logButton;
        functionButtons[13] = lnButton;
        functionButtons[14] = sqrtButton;
        functionButtons[15] = leftParenButton;
        functionButtons[16] = rightParenButton;
        functionButtons[17] = piButton;
        functionButtons[18] = eButton;
        functionButtons[19] = modButton;

        for (int i = 0; i < functionButtons.length; i++) {
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(myFont);
            functionButtons[i].setFocusable(false);
        }

        for (int i = 0; i < numberButtons.length; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(myFont);
            numberButtons[i].setFocusable(false);
        }

        panel = new JPanel();
        panel.setBounds(50, 100, 450, 400);;
        panel.setLayout(new GridLayout(5, 6, 5, 5));

        panel.add(piButton);
        panel.add(eButton);
        panel.add(leftParenButton);
        panel.add(rightParenButton);
        panel.add(delButton);
        panel.add(clrButton);

        panel.add(sinButton);
        panel.add(lnButton);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(divButton);

        panel.add(cosButton);
        panel.add(logButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(mulButton);

        panel.add(tanButton);
        panel.add(sqrtButton);
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(subButton);

        panel.add(cotButton);
        panel.add(modButton);
        panel.add(numberButtons[0]);
        panel.add(decButton);
        panel.add(equButton);
        panel.add(addButton);

        frame.add(panel);
        frame.add(textField);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        Calculator calc = new Calculator();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String currentText = textField.getText();

        //if we get error as a result, once we pressing a new button it will remove the message and replace it with the button we pressed
        if (currentText.equals("Error")) {
            textField.setText("");
            currentText = "";
        }

        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numberButtons[i]) {
                textField.setText(currentText.concat(String.valueOf(i)));
                return;
            }
        }

        //for every button excepting the "=", del and clear, once pressed it will concat to the current string which represents the equation that will be evaluated later
        if (e.getSource() == decButton) {
            textField.setText(currentText.concat("."));
            return;
        }
        if (e.getSource() == addButton) {
            textField.setText(currentText.concat(" + "));
            return;
        }
        if (e.getSource() == subButton) {
            if (currentText.isEmpty() || currentText.endsWith(" + ") || currentText.endsWith(" - ") || currentText.endsWith(" * ") || currentText.endsWith(" / ")) {
                textField.setText(currentText.concat("-"));
            } else {
                textField.setText(currentText.concat(" - "));
            }
            return;
        }

        if (e.getSource() == mulButton) {
            textField.setText(currentText.concat(" * "));
            return;
        }
        if (e.getSource() == divButton) {
            textField.setText(currentText.concat(" / "));
            return;
        }

        if (e.getSource() == sinButton) {
            textField.setText(currentText.concat("sin("));
            return;
        }
        if (e.getSource() == cosButton) {
            textField.setText(currentText.concat("cos("));
            return;
        }
        if (e.getSource() == tanButton) {
            textField.setText(currentText.concat("tan("));
            return;
        }
        if (e.getSource() == cotButton) {
            textField.setText(currentText.concat("cot("));
            return;
        }

        if (e.getSource() == sqrtButton) {
            textField.setText(currentText.concat("sqrt("));
            return;
        }

        if (e.getSource() == logButton) {
            textField.setText(currentText.concat("log("));
            return;
        }
        if (e.getSource() == lnButton) {
            textField.setText(currentText.concat("ln("));
            return;
        }

        if (e.getSource() == modButton) {
            textField.setText(currentText.concat(" % "));
            return;
        }

        if (e.getSource() == piButton) {
            textField.setText(currentText.concat("\u03C0"));
            return;
        }
        if (e.getSource() == eButton) {
            textField.setText(currentText.concat("e"));
            return;
        }

        //"=" button will call the evaluate method which will return the result/error message
        if (e.getSource() == equButton) {
            try {
                double result = evaluate(currentText);
                if (result == (long) result) {
                    textField.setText(String.format("%d", (long) result));
                } else {
                    textField.setText(String.format("%.3f", result));
                }
            } catch (Exception ex) {
                textField.setText("Error");
            }
            return;
        }

        if (e.getSource() == leftParenButton) {
            textField.setText(currentText.concat("("));
            return;
        }

        if (e.getSource() == rightParenButton) {
            textField.setText(currentText.concat(")"));
            return;
        }

        //clears the string
        if (e.getSource() == clrButton) {
            textField.setText("");
            return;
        }

        //deletes last elem in string
        if (e.getSource() == delButton) {
            if (!currentText.isEmpty()) {
                if (currentText.endsWith(" + ") || currentText.endsWith(" - ") || currentText.endsWith(" * ") || currentText.endsWith(" / ")) {
                    textField.setText(currentText.substring(0, currentText.length() - 3));
                } else {
                    textField.setText(currentText.substring(0, currentText.length() - 1));
                }
            }
        }
    }

    public static double evaluate(String expression) {
        // this turns stuff like "5e" into "5*e" and "5sin" into "5*sin" before we start
        expression = expression.replaceAll(" ", "")
                .replaceAll("([\\d.)\u03C0e])([a-zA-Z(])", "$1*$2")
                .replaceAll("(\\d)(\\u03C0|e)", "$1*$2");

        // we split the string(equation)
        String[] tokens = expression.split("(?<=[-+*/%()\u03C0e])|(?=[-+*/%()\u03C0e])");

        Stack<Double> values = new Stack<>();
        Stack<Object> ops = new Stack<>();

        for (String token : tokens) {
            if (token.isEmpty()) continue;

            // if token is a number
            if (token.matches("-?\\d+(\\.\\d+)?")) {
                values.push(Double.parseDouble(token));
            }
            // check for constants π and e
            else if (token.equals("\u03C0")) {
                values.push(Math.PI);
            }
            else if (token.equals("e")) {
                values.push(Math.E);
            }

            // if token is a function name
            else if (token.matches("[a-zA-Z]+")) {
                ops.push(token);
            }
            // if token is an opening brace
            else if (token.equals("(")) {
                ops.push('(');
            }
            // if token is a closing brace
            else if (token.equals(")")) {
                while (ops.peek() instanceof Character && (char) ops.peek() != '(') {
                    values.push(applyOp((char) ops.pop(), values.pop(), values.pop()));
                }
                ops.pop(); // Pop the '('

                if (!ops.isEmpty() && ops.peek() instanceof String) {
                    values.push(applyFunc((String) ops.pop(), values.pop()));
                }
            }
            // if token is an operator
            else {
                char op = token.charAt(0);
                while (!ops.isEmpty() && ops.peek() instanceof Character && hasPrecedence(op, (char) ops.peek())) {
                    values.push(applyOp((char) ops.pop(), values.pop(), values.pop()));
                }
                ops.push(op);
            }
        }

        while (!ops.isEmpty()) {
            values.push(applyOp((char) ops.pop(), values.pop(), values.pop()));
        }
        return values.pop();
    }

    public static boolean hasPrecedence(char op1, char op2) {
        if (op2 == '(' || op2 == ')') return false;
        if ((op1 == '*' || op1 == '/' || op1 == '%') && (op2 == '+' || op2 == '-')) return false;
        return true;
    }

    public static double applyOp(char op, double b, double a) {
        switch (op) {
            case '+': return a + b;
            case '-': return a - b;
            case '*': return a * b;
            case '/':
                if (b == 0) throw new UnsupportedOperationException("Cannot divide by zero");
                return a / b;
            case '%':
                if (b == 0) throw new UnsupportedOperationException("Cannot divide by zero for modulo");
                return a % b;
        }
        return 0;
    }

    public static double applyFunc(String func, double a) {
        switch (func) {
            case "sin": return Math.sin(Math.toRadians(a));
            case "cos": return Math.cos(Math.toRadians(a));
            case "tan": return Math.tan(Math.toRadians(a));
            case "cot": return 1 / Math.tan(Math.toRadians(a));
            case "log": return Math.log10(a);
            case "ln": return Math.log(a);
            case "sqrt": return Math.sqrt(a);
        }
        return 0;
    }
}