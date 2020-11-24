package org.example;

public class Util {

    /**
     * Returns the value after evaluation of the expression
     *
     * @param expression
     * @return
     */
    public static int solve(String expression){
        return evaluate(postfixExpression(expression.replaceAll("\\s", "").toCharArray()));
    }

    /**
     * Check if the character is number or not
     *
     * @param a
     * @return
     */
    private static boolean isNumber(char a){
        return a>='0' && a<='9';
    }

    /**
     * To get precedence of the operator
     *
     * @param a
     * @return
     */
    private static int getPrecedence(char a){
        return a == '*' || a == '/' ? a == '+' || a == '-' ? 2 : 1 : 0;
    }

    /**
     * Evaluate the Values of Integer a and Integer b based on the operator
     *
     * @param a
     * @param b
     * @param operator
     * @return
     */
    private static Integer evaluate(int a,int b,char operator){
        switch(operator){
            case '+' : return a+b;
            case '-' : return a-b;
            case '/' : return a/b;
            case '*' : return a*b;
            default : return null;
        }
    }

    /**
     * Convert the Infix Expression to Postfix Expression
     *
     * @param expression
     * @return
     */
    private static char[] postfixExpression(char[] expression){
        int length = expression.length;
        char[] holder = new char[length];
        char[] stack = new char[length];
        int toph = 0;
        int tops = -1;

        for(int i = 0 ; i < length ; i++){
            if(isNumber(expression[i])) holder[toph++] = expression[i];
            else{
                while(tops!=-1 && getPrecedence(stack[tops]) > getPrecedence(expression[i])) holder[toph++] = stack[tops--];
                stack[++tops] = expression[i];
            }
        }

        while(tops!=-1) holder[toph++] = stack[tops--];

        return holder;
    }

    /**
     * Evaluates the postfix expression to integer value
     *
     * @param postfix
     * @return
     */
    private static int evaluate(char[] postfix){
        int length = postfix.length;
        int[] stack = new int[length];
        int tops = -1;
        for(int i = 0 ; i < length ; i++ ){
            if(isNumber(postfix[i])) stack[++tops] = Integer.parseInt(Character.toString(postfix[i]));
            else{
                int a = stack[tops--];
                int b = stack[tops--];
                int result = evaluate(b, a, postfix[i]);
                stack[++tops] = result;
            }
        }
        return stack[tops];
    }
}
