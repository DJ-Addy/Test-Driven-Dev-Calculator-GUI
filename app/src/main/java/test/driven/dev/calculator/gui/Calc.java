package test.driven.dev.calculator.gui;
import java.util.Stack;

public class Calc {
    
    private Stack<Double> computeStack;
    private Stack<Character> operatorStack;
    private boolean error;
    
    public Calc() {
        computeStack = new Stack<Double>();
        operatorStack = new Stack<Character>();
        error = false;
    }

    private boolean isOperator(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '^' || ch == '%';
    }

    private boolean isFunction(String str) {
        return str.equals("sin") || str.equals("cos") || str.equals("tan") || str.equals("log") || str.equals("sqrt");
    }

    private int getPrecedence(char ch) {
        if (ch == '+' || ch == '-' || ch == '%' || ch == '^') {
            return 1;
        }
        if (ch == '*' || ch == '/') {
            return 2;
        }
        if (ch == '!') {
            return 3; // Highest precedence for factorial since it's unary
        }
        return 0;
    }

    private void functionHandler(String function, double argument) {
        double result = 0;
        switch (function) {
            case "sin":
                result = Math.sin(Math.toRadians(argument));
                break;
            case "cos":
                result = Math.cos(Math.toRadians(argument));
                break;
            case "tan":
                result = Math.tan(Math.toRadians(argument));
                break;
            case "log":
                result = Math.log10(argument);
                break;
            case "sqrt":
                result = Math.sqrt(argument);
                break;
        }
        computeStack.push(result);
    }

    private void processOperator(char t) {
        double a, b;
        if (computeStack.empty()) {
            System.out.println("Expression error.");
            error = true;
            return;
        } else {
            b = computeStack.pop();
        }
        if (computeStack.empty()) {
            System.out.println("Expression error.");
            error = true;
            return;
        } else {
            a = computeStack.pop();
        }
        double r = 0;
        switch (t) {
            case '+':
                r = a + b;
                break;
            case '-':
                r = a - b;
                break;
            case '*':
                r = a * b;
                break;
            case '/':
                r = a / b;
                break;
            case '^':
                r = Math.pow(a, b);
                break;
            case '%':
                r = a % b;
                break;
            case '!':
                r= 1;
                for (int i = 1; i <= a; i++) {
                    r *= i;
                }
                break;
            default:
                System.out.println("Operator error.");
                error = true;
        }
        computeStack.push(r);
    }

    public double processInput(String input) {
        // The tokens that make up the input
        String[] tokens = input.split(" ");

        // Main loop - process all input tokens
        for (int n = 0; n < tokens.length; n++) {
            String nextToken = tokens[n];
            char ch = nextToken.charAt(0);
            if (ch >= '0' && ch <= '9') {
                double value = Double.parseDouble(nextToken);
                computeStack.push(value);
            } else if (isOperator(ch)) {
                if (operatorStack.empty() || getPrecedence(ch) > getPrecedence(operatorStack.peek())) {
                    operatorStack.push(ch);
                } else {
                    while (!operatorStack.empty() && getPrecedence(ch) <= getPrecedence(operatorStack.peek())) {
                        char toProcess = operatorStack.pop();
                        processOperator(toProcess);
                    }
                    operatorStack.push(ch);
                }
            } else if (isFunction(nextToken)) {
                // Read the function argument
                if (tokens.length > n + 2 && tokens[n + 1].equals("(") && tokens[n + 3].equals(")")) {
                    double argument = Double.parseDouble(tokens[n + 2]);
                    functionHandler(nextToken, argument);
                    n += 3 ; // Skip the next three tokens
                } else {
                    System.out.println("Error: Invalid function format.");
                    error = true;
                }
            } else if (ch == '(') {
                operatorStack.push(ch);
            } else if (ch == ')') {
                while (!operatorStack.empty() && operatorStack.peek() != '(') {
                    char toProcess = operatorStack.pop();
                    processOperator(toProcess);
                }
                if (!operatorStack.empty() && operatorStack.peek() == '(') {
                    operatorStack.pop();
                } else {
                    System.out.println("Error: unbalanced parenthesis.");
                    error = true;
                }
            }
        }
        // Empty out the operator stack at the end of the input
        while (!operatorStack.empty() && isOperator(operatorStack.peek())) {
            char toProcess = operatorStack.pop();
            processOperator(toProcess);
        }
        // Return the result if no error has been seen.
        if (!error) {
            double result = computeStack.pop();
            if (!operatorStack.empty() || !computeStack.empty()) {
                System.out.println("Expression error.");
                return Double.NaN; // Indicate an error occurred
            } else {
                return result;
            }
        } else {
            return Double.NaN; // Indicate an error occurred
        }
    }

    public static void main(String[] args) {
        Calc calculator = new Calc();
        String expression = "3 + 5 * 2";
        System.out.println("Result: " + calculator.processInput(expression)); // Should output 13

        expression = "3 + ( 2 * 2 )";
        System.out.println("Result: " + calculator.processInput(expression)); // Should output 7

        expression = "sin ( 90 ) + 2";
        System.out.println("Result: " + calculator.processInput(expression)); // Should output 1.0

        expression = "5 % 2";
        System.out.println("Result: " + calculator.processInput(expression)); // Should output 1.0
        
        expression = "log ( 100 ) / 10";
        System.out.println("Result: " + calculator.processInput(expression)); // Should output 0.2
        expression = "( sqrt ( 4 ) / 10 ) + 2";
        System.out.println("Result: " + calculator.processInput(expression)); // Should output 1.0
    }
}
