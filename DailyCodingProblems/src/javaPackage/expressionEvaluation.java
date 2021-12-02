package javaPackage;

import java.util.Stack;


/* Evaluate an expression represented by a String. Expression can contain parentheses, 
 * you can assume parentheses are well-matched. For simplicity, you can assume only binary operations 
 * allowed are +, -, *, and /. Arithmetic Expressions can be written in one of three forms:
* 	Infix Notation: Operators are written between the operands they operate on, e.g. 3 + 4 .
   	*Prefix Notation: Operators are written before the operands, e.g + 3 4 */


public class expressionEvaluation
{
	public static int evaluate(String expression)
	{
		char[] tokens = expression.toCharArray();
		
		//Stack for numbers: 'values'
		Stack<Integer> values = new Stack<Integer>();
		
		//Stack for operators: 'ops'
		Stack<Character> ops = new Stack<Character>();
		
		for (int i = 0; i < tokens.length; i++)
		{
			//Current token is whitespace so skip
			if (tokens[i]== ' ')
				continue;
			//Current token is a number, push it to values stack
			if(tokens[i] >= '0' && tokens[i] <= '9')
			{
				StringBuffer sbuf = new StringBuffer();
				//There may be more than one digits in number
				while (i < tokens.length && tokens[i] >= '0' && tokens[i] <= '9')
						sbuf.append(tokens[i++]);
				values.push(Integer.parseInt(sbuf.toString()));
			}
			
			//Current token is an opening brace push it to ops stack
			else if (tokens[i] == '(')
				ops.push(tokens[i]);
			
			else if (tokens[i] == ')')
			{
				while(ops.peek()!= '(')
					values.push(applyOp(ops.pop(),values.pop(),values.pop()));
				ops.pop();
			}
			
			//Curent token is an operator
			else if (tokens[i] == '+' || tokens[i] == '-' || tokens[i] == '*'
					|| tokens[i] == '/')
			{
				//While top of 'ops' has same or greater precedence to current
				//token, which is an operator. Apply operator on top of 'ops'
				//to top two elements in values stack
				while(!ops.empty() && hasPrecedence(tokens[i], ops.peek()))
					values.push(applyOp(ops.pop(), values.pop(), values.pop()));
					
				//Push current token to 'ops'
					ops.push(tokens[i]);
			}
		}
		
		//Entire expression has been parsed at this point, apply
		//remaining ops to remaining values
		while(!ops.empty())
			values.push(applyOp(ops.pop(), values.pop(), values.pop()));
		
		//Top of 'values' contains the result
		return values.pop();
	}
	
	//Returns true if 'op2' has higher or same precedence as 'op1'
	//otherwise returns false
	public static boolean hasPrecedence(char op1, char op2)
	{
		if(op2 == '(' || op2 == ')')
			return false;
		if((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-'))
			return false;
		else
			return true;
	}
	
	//A utiity method to apply an operator 'op' on operands 'a'
	//and 'b'. Return the result
	public static int applyOp(char op, int b, int a)
	{
		switch(op)
		{
		case '+':
			return a+b;
		case '-':
			return a-b;
		case '*':
			return a*b;
		case '/':
			if (b==0)
				throw new UnsupportedOperationException("cannot divide by zero");
			return a/b;
		}
		
		return 0;
	}
	
	public static void main(String[] args)
	{
		System.out.println(expressionEvaluation.evaluate("10 + 2 * 6"));
		System.out.println(expressionEvaluation.evaluate("100 * 2 + 12"));
		System.out.println(expressionEvaluation.evaluate("100 * ( 2 + 12 )"));
		System.out.println(expressionEvaluation.evaluate("100 * ( 2 + 12 ) / 14"));

	}
}