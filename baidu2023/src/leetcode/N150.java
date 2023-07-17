package leetcode;

import java.util.LinkedList;

public class N150 {
    public static void main(String[] args) {
        System.out.println(evalRPN(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}));
    }
    /**
     * 150 逆波兰表达式求值 https://leetcode.cn/problems/evaluate-reverse-polish-notation/
     * @param tokens
     * @return
     */
    public static int evalRPN(String[] tokens) {
        if (tokens.length == 1) {
            return Integer.valueOf(tokens[0]);
        }
        LinkedList<String> numberStack = new LinkedList();
        int fitstMethodIndex = 0;
        for (int i = 0; i < tokens.length; i++) {
            if (isMethod(tokens[i])) {
                fitstMethodIndex = i;
                break;
            } else {
                numberStack.push(tokens[i]);
            }
        }
        while (numberStack.size() >= 2) {
            String second = numberStack.pop();
            String first = numberStack.pop();
            String temp = String.valueOf(getResult(first, second, tokens[fitstMethodIndex]));
            numberStack.push(temp);
            fitstMethodIndex++;
            while (fitstMethodIndex < tokens.length && !isMethod(tokens[fitstMethodIndex])) {
                numberStack.push(tokens[fitstMethodIndex]);
                fitstMethodIndex++;
            }
        }
        return Integer.valueOf(numberStack.pop());
    }

    public static int getResult(String s1, String s2, String method) {
        int n1 = Integer.parseInt(s1);
        int n2 = Integer.parseInt(s2);
        if (method.equals("+")) {
            return n1 + n2;
        }
        if (method.equals("-")) {
            return n1 - n2;
        }
        if (method.equals("*")) {
            return n1 * n2;
        }
        if (method.equals("/")) {
            return n1 / n2;
        }
        return 0;
    }

    public static boolean isMethod(String s) {
        return "+".equals(s) || "-".equals(s) || "*".equals(s) || "/".equals(s);
    }
}
