import java.util.Stack;

class InfixToPostfix{
    public static void main(String[] args) {
        String exp="3+4*8";
        String rst= infixToPostfix(exp);
        System.out.println("Ans: "+rst);
    }

    private static String infixToPostfix(String exp) {
        String str="";
        char[] charArray = exp.toCharArray();
        Stack<Character> s = new Stack<>();
        for(int i=0;i<charArray.length;i++)
        {
            if(charArray[i]=='(')
            {
                s.push(charArray[i]);
            }
            else if ((charArray[i] >= '0' && charArray[i] <= '9') || (charArray[i] >= 'A' && charArray[i] <= 'Z') || (charArray[i] >= 'a' && charArray[i] <= 'z')) {
                str+=charArray[i];
            }
            else if(charArray[i]==')')
            {
                if(s.isEmpty()) s.push(charArray[i]);

                else{
                     // ^
                    // * /
                    // + -
                    // ( )
                    if(charArray[i]=='+' || charArray[i]=='-')
                    {
                        if(s.peek()=='*'|| s.peek()=='/')
                        {
                            while(s.isEmpty() && s.peek()!='*' || s.peek()!='/')
                            {
                                str+=s.pop();
                            }
                        }
                        else{
                            s.push(charArray[i]);
                        }
                    }
                    if(charArray[i]=='*' || charArray[i]=='/')
                    {
                        if(s.peek()=='^')
                        {
                            while(s.isEmpty() && s.peek()!='^')
                            {
                                str+=s.pop();
                            }
                        }
                        if(s.peek()=='*'|| s.peek()=='/')
                        {
                            while(s.isEmpty() && s.peek()!='+' || s.peek()!='-')
                            {
                                str+=s.pop();
                            }
                        }
                        else{
                            s.push(charArray[i]);
                        }
                    }
                }
            }
        }
        
        while(!s.isEmpty())
        {
            str+=s.pop();
        }


        return str;
    }

}

private static String infixToPostfix(String exp) {
    String str = "";
    char[] charArray = exp.toCharArray();
    Stack<Character> s = new Stack<>();

    for (int i = 0; i < charArray.length; i++) {
        char ch = charArray[i];

        if (Character.isLetterOrDigit(ch)) {
            str += ch;
        } else if (ch == '(') {
            s.push(ch);
        } else if (ch == ')') {
            while (!s.isEmpty() && s.peek() != '(') {
                str += s.pop();
            }
            if (!s.isEmpty() && s.peek() == '(') {
                s.pop();
            }
        } else {
            while (!s.isEmpty() && precedence(ch) <= precedence(s.peek())) {
                str += s.pop();
            }
            s.push(ch);
        }
    }

    while (!s.isEmpty()) {
        if (s.peek() == '(') {
            return "Invalid infix expression"; // Unmatched parentheses
        }
        str += s.pop();
    }

    return str;
}

private static int precedence(char ch) {
    switch (ch) {
        case '^':
            return 3;
        case '*':
        case '/':
            return 2;
        case '+':
        case '-':
            return 1;
        default:
            return -1;
    }
}
