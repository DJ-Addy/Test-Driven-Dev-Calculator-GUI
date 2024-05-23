package test.driven.dev.calculator.gui;
import java.util.Stack;
public class Calc {
    
    private Stack<Double> computeStack;
    private Stack<Operator> operatorStack;
    
    public Calc() {
        computeStack = new Stack<Double>();
        operatorStack = new Stack<Operator>();
    }

   public double compute(String sequence) {
    for (int i = 0; i < sequence.length(); i++) {
        int number = parseNumber(sequence, i);
         System.out.println("parseNumber: " + number);
        computeStack.push((double)number);
        // Increment i by the number of characters processed in parseNumber
        i += Integer.toString(number).length();

        if (i >= sequence.length()) {
            break;
        }

        Operator op = parseOperator(sequence, i);
        collapseTop(op);
        operatorStack.push(op);
    }
    collapseTop(Operator.BLANK);
    if (computeStack.size() == 1 && operatorStack.isEmpty()) {
        return computeStack.pop();
    }
    return 0;
}

    private void collapseTop(Operator futureTop) {
        while (computeStack.size() >= 2 && !operatorStack.isEmpty()) {
            if (priorityOfOperator(futureTop) <= priorityOfOperator(operatorStack.peek())) {
                double second = computeStack.pop();
                System.out.println(second);
                double first = computeStack.pop();
                 System.out.println(first);
                Operator op = operatorStack.pop();
                double result = applyOp(first, op, second);
                computeStack.push(result);
            } else {
                break;
            }
        }
    }

    private double applyOp(double left, Operator op, double right) {
        switch (op) {
            case ADD: return left + right;
            case SUBTRACT: return left - right;
            case MULTIPLY: return left * right;
            case DIVIDE: return left / right;
            default: return right;
        }
    }

    private int priorityOfOperator(Operator op) {
        switch (op) {
            case ADD: return 1;
            case SUBTRACT: return 1;
            case MULTIPLY: return 2;
            case DIVIDE: return 2;
            case BLANK: return 0;
        }
        return 0;
    }

   private int parseNumber(String sequence, int offset) {
    StringBuilder sb = new StringBuilder();
    while (offset < sequence.length() && (Character.isDigit(sequence.charAt(offset)))) {
        sb.append(sequence.charAt(offset));
        offset++;
    }
    return Integer.parseInt(sb.toString());
}

    private Operator parseOperator(String sequence, int offset) {
        if (offset < sequence.length()) {
            char op = sequence.charAt(offset);
            switch (op) {
                case '+': return Operator.ADD;
                case '-': return Operator.SUBTRACT;
                case '*': return Operator.MULTIPLY;
                case '/': return Operator.DIVIDE;
            }
        }
        return Operator.BLANK;
    }
    

    public static void main(String[] args) {
        String exper = "3+5*2";
        Calc calculator = new Calc();
        double res = calculator.compute(exper);
        System.out.println("Result: " + res);
    }

}
