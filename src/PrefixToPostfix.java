import java.util.Stack;

public class PrefixToPostfix {
    public static void main(String[] args){
        String str = "*-A/BC-/AKL";
        String result = convertPrePostFix(str);
        System.out.println(result);
    }
    static String convertPrePostFix(String str){
        int length = str.length();
        Stack<String> stack = new Stack<String>();
        for(int i = length-1; i >= 0; i--){
            if(isOperator(str.charAt(i))){
                String s1 = stack.pop();
                String s2 = stack.pop();
                String temp = s1+s2+str.charAt(i);
                stack.push(temp);
            }else {
                stack.push(str.charAt(i)+"");
            }
        }
        return stack.pop();
    }

    private static boolean isOperator(char c) {
        switch (c){
            case '+':
            case '-':
            case '*':
            case '/':
            case '^':
            case '%':
                return true;
        }
        return false;
    }
}
