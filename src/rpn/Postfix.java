package rpn;

import java.util.Scanner;

public abstract class Postfix{
	
	int res = 0;
	
	int x = 0;
	int y = 0;
	public int evaluate (String pfx) {
		
		 Scanner sc = new Scanner(pfx);
		 	StackAsList<Integer> stack = new StackAsList<Integer>();

		    while (sc.hasNext()) {
		        if (sc.hasNextInt()) {
		            stack.push(sc.nextInt());
		            continue;
		        }
		        int b = stack.pop();
		        int a = stack.pop();
		        char op = sc.next().charAt(0);
		        if      (op == '+') stack.push(a + b);
		        else if (op == '-') stack.push(a - b);
		        else if (op == '*') stack.push(a * b);
		        else if (op == '/') stack.push(a / b);
		        else if (op == '%') stack.push(a % b);
		    }

		    sc.close();
		    return stack.pop();
	}

}
