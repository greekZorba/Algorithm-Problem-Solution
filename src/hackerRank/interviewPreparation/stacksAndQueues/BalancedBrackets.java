package hackerRank.interviewPreparation.stacksAndQueues;

import java.util.EmptyStackException;
import java.util.Stack;

public class BalancedBrackets {

    public String isBalanced(String s) {

        char[] bracketArray = s.toCharArray();
        Stack<Character> bracketStack = new Stack<>();

        for(int i=0; i<bracketArray.length; i++) {
            char bracket = bracketArray[i];
            boolean isPair = true;
            try {
                switch(bracket) {
                    case '(':
                    case '[':
                    case '{': bracketStack.push(bracket);
                        break;
                    case '}':
                    case ']':
                    case ')':
                        isPair = isPairBrackets(bracketStack.peek(), bracket);
                        if(isPair) {
                            bracketStack.pop();
                        }
                        break;
                }

                if(!isPair) {
                    return "NO";
                }
            } catch (EmptyStackException e) {
                return "NO";
            }
        }

        if(bracketStack.isEmpty()) {
            return "YES";
        } else {
            return "NO";
        }
    }

    public boolean isPairBrackets(char openBracket, char closeBracket) {

        if((openBracket == '{' && closeBracket == '}')
                || (openBracket == '(' && closeBracket == ')')
                || (openBracket == '[' && closeBracket == ']')) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        BalancedBrackets balancedBrackets = new BalancedBrackets();
        String brackets = "{(([])[])[]}[]";
        System.out.println(balancedBrackets.isBalanced(brackets));
    }

}
