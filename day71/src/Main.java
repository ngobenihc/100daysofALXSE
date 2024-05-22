import java.util.*;

class Main {
    public static void main(String []argh) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String input = sc.next();
            // Call the isBalanced function and print the result
            System.out.println(isBalanced(input));
        }

        sc.close();
    }

    public static boolean isBalanced(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> matchingParentheses = new HashMap<>();
        matchingParentheses.put(')', '(');
        matchingParentheses.put('}', '{');
        matchingParentheses.put(']', '[');

        for (char ch : s.toCharArray()) {
            if (matchingParentheses.containsValue(ch)) {
                // If it's an opening bracket, push to stack
                stack.push(ch);
            } else if (matchingParentheses.containsKey(ch)) {
                // If it's a closing bracket, check for matching opening bracket
                if (stack.isEmpty() || stack.pop() != matchingParentheses.get(ch)) {
                    return false;
                }
            } else {
                // If the character is not a valid bracket (which should not be the case in the problem statement)
                return false;
            }
        }

        // If stack is empty, all opening brackets had matching closing brackets
        return stack.isEmpty();
    }
}
