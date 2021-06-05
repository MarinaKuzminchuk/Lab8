package rpn;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        Postfix postfix = new Postfix();
        String postfixLine = postfix.infixToPostfix(line);
        int number = postfix.evaluate(postfixLine);
        System.out.println(number);
    }
}
