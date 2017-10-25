import java.util.Stack;
import java.io.*;

class Calculator
{
    // A utility function to return precedence of a given operator
    // Higher returned value means higher precedence
    static int Prec(char ch)
    {
        switch (ch)
        {
        case '+':
        case '-':
            return 1;

        case '*':
        case '/':
        case '%':
            return 2;

        }
        return -1;
    }

    // The main method that converts given infix expression
    // to postfix expression.
    static String infixToPostfix(String exp)throws IllegalOperationException, LookAtMrAlgebraOverHereException
    {
        // initializing empty String for result
        String result = new String("");
        boolean lastest = false;

        // initializing empty stack
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i<exp.length(); ++i)
        {
            char c = exp.charAt(i);

             // If the scanned character is an operand, add it to output.

             if(c == '&' || c == '#' || c == '@' || c == '^' || c == '!')
                 throw new IllegalOperationException("this is not a legal operator");

            else if (Character.isDigit(c)|| c == '.'){


                result += c;
                lastest = false;
              }


            // If the scanned character is an '(', push it to the stack.

            else if (c == '('){

                stack.push(c);

              }

            //  If the scanned character is an ')', pop and output from the stack
            // until an '(' is encountered.
            else if (c == ')')
            {

                while (!stack.isEmpty() && stack.peek() != '('){
                    result += " ";
                    result += stack.pop();

                  }

                if (!stack.isEmpty() && stack.peek() != '(')
                    return "Invalid Expression"; // invalid expression
                else
                    stack.pop();
            }

            else// an operator is encountered
            {   result += " ";
                if(lastest == true)
                  throw new LookAtMrAlgebraOverHereException("you need to enter number, number belongs here!");
                lastest = true;
                while (!stack.isEmpty() && Prec(c) <= Prec(stack.peek())){
                    result += stack.pop();
                    result += " ";


                }

                stack.push(c);
            }

        }

        // pop all the operators from the stack
        while (!stack.isEmpty())

            result += " " + stack.pop();
        return result;
    }

    private static void evaluate(Stack<Double> postfix, char operator) {
        double num2 = postfix.pop();
        if(postfix.empty())
          throw new UserIsADumbassException("missing number, you DUMBASS!");
        double num1 = postfix.pop();
        switch (operator) {
            case '+':{
                postfix.push(num1 + num2);

                break;
              }
            case '-':
                postfix.push(num1 - num2); break;
            case '/':{
                if(num2 == 0 || num2 == 0.0)
                throw new ArithmeticException("Can't divide by zero!");

                postfix.push(num1 / num2); break;
              }
            case '*':
                postfix.push(num1 * num2); break;
            case '%':
                postfix.push(num1 % num2); break;
        }
    }

    private static boolean isOperator(char ch){
        return     (ch == '/' ||
                ch == '+' ||
                ch == '-' ||
                ch == '*' ||
                ch == '%' ||
                ch == '(' ||
                ch == ')');

    }

    // Driver method
    public static void main(String[] args)
    {
      try{

        String exp = args[0];
        exp = infixToPostfix(exp);
        System.out.println(exp);
        String[] splitStr = exp.trim().split("\\s+");

        Stack<Double> postfix = new Stack<>();

        for (String token : splitStr) {


           if (isOperator(token.charAt(0))) {
              if(postfix.empty())
                throw new UserIsADumbassException("missing number, you DUMBASS!");
               evaluate(postfix, token.charAt(0));
           } else {
               postfix.push(Double.parseDouble(token));

           }

        }

        System.out.println("result = " + postfix.pop());


    }catch(IllegalArgumentException ex){
      System.out.println("Caught Exception: " + ex.getMessage());
    }catch(Exception e){
      System.out.println("Caught Exception: " + e.getMessage());

    }
    }

  }
