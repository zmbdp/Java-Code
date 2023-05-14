import java.util.Stack;

class Solution {
    public int evalRPN(String[] tokens) {
        if (tokens.length == 0) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            //如果是字母
            if (tokens[i] == "+" || tokens[i] == "-" || tokens[i] == "*" || tokens[i] == "/") {
                int y = stack.pop();
                int x = stack.pop();
                //看看是什么操作符
                if (tokens[i] == "+") {
                    stack.push(x + y);
                }
                if (tokens[i] == "-") {
                    stack.push(x - y);
                }
                if (tokens[i] == "*") {
                    stack.push(x * y);
                }
                if (tokens[i] == "/") {
                    stack.push(x / y);
                }
            }
            //如果是数字
            else {
                stack.push(Integer.parseInt(tokens[i]));
            }
        }
        return stack.pop();
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] str = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        int x = solution.evalRPN(str);//12
        System.out.println(x);
    }
}