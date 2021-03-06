package rpn;

import java.util.Scanner;

public class Postfix {
    public void calculate() {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String postfixLine = infixToPostfix(line);
        double number = evaluate(postfixLine);
        System.out.println(number);
    }

    // calculate the result using an expression in the postfix format
    public double evaluate(String pfx) {
        Scanner sc = new Scanner(pfx);
        StackAsList<Double> stack = new StackAsList<Double>();
        while (sc.hasNext()) {
            if (sc.hasNextInt()) {
                stack.push(sc.nextDouble());
                continue;
            }
            double b = stack.pop();
            double a = stack.pop();
            char op = sc.next().charAt(0);
            if (op == '+') stack.push(a + b);
            else if (op == '-') stack.push(a - b);
            else if (op == '*') stack.push(a * b);
            else if (op == '/') stack.push(a / b);
            else if (op == '^') stack.push(Math.pow(a,b));



        }
        sc.close();
        return stack.pop();
    }

    // convert expression in infix format to postfix
    public String infixToPostfix(String ifx) {
        String[] tokens = ifx.split(" ");
        StringBuilder result = new StringBuilder();
        Stack<String> stack = new StackAsList<>();
        for (String token : tokens) {
            if (isNumeric(token)) {
                result.append(token + " ");
            } else if (token.equals("(")) {
                stack.push(token);
            } else if (token.equals(")")) {
                // while top is not equal open parenthesis
                while (!("(".equals(stack.peek()))) {
                    String top = stack.pop();
                    result.append(top + " ");
                }
                stack.pop();
            } else {
                while (precedence(stack.peek()) >= precedence(token)) {
                    String top = stack.pop();
                    result.append(top + " ");
                }
                stack.push(token);
            }
        }
        while (!stack.isEmpty()) {
            String top = stack.pop();
            result.append(top + " ");
        }
        // remove the last whitespace
        result.deleteCharAt(result.length() - 1);
        return result.toString();
    }
    // check if the line is a number
    public boolean isNumeric(String line) {
        if (line == null) {
            return false;
        }
        try {
            Double.parseDouble(line); // try to convert line to number
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    // defines precedence for operators
    public double precedence(String operator) {
        if ("+".equals(operator) || "-".equals(operator))
            return 1;
        else if ("*".equals(operator) || "/".equals(operator))
            return 2;
        else if ("^".equals(operator))
            return 3;
        return 0;
    }
}
