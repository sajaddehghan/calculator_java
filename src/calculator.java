
public class calculator {
    public String account(String expression) {


        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) == '*') {

                int k;
                for (k = i - 1; k >= 0; k--) {
                    char ch = expression.charAt(k);
                    if (!(ch >= '0' && ch <= '9' || ch=='.')) {
                        if (ch=='-'){
                            if (k-1==-1||expression.charAt(k-1)=='-'||expression.charAt(k-1)=='+'||expression.charAt(k-1)=='*'
                                    ||expression.charAt(k-1)=='/'){
                                k--;
                            }
                        }
                        break;
                    }
                }
                double number1 = Double.valueOf(expression.substring(k + 1, i));

                int p;
                for (p = i + 2; p < expression.length(); p++) {
                    char ch = expression.charAt(p);
                    if (!(ch >= '0' && ch <= '9'|| ch=='.')) {
                        break;
                    }
                }
                double number2 = Double.valueOf(expression.substring(i + 1, p));
                double sum = number1 * number2;

                String oldstring=expression.substring(k + 1, i)+"*"+expression.substring(i + 1, p);
                expression=expression.replace(oldstring,String.valueOf(sum));
                i=0;
            }
            if (expression.charAt(i) == '/') {

                int k;
                for (k = i - 1; k >= 0; k--) {
                    char ch = expression.charAt(k);
                    if (!(ch >= '0' && ch <= '9'|| ch=='.')) {
                        if (ch=='-'){
                            if (k-1==-1||expression.charAt(k-1)=='-'||expression.charAt(k-1)=='+'||expression.charAt(k-1)=='*'
                                    ||expression.charAt(k-1)=='/'){
                                k--;
                            }
                        }
                        break;
                    }
                }
                double number1 = Double.valueOf(expression.substring(k + 1, i));

                int p;
                for (p = i + 2; p < expression.length(); p++) {
                    char ch = expression.charAt(p);
                    if (!(ch >= '0' && ch <= '9'|| ch=='.')) {
                        break;
                    }
                }
                double number2 = Double.valueOf(expression.substring(i + 1, p));
                double sum = number1 / number2;

                String oldstring=expression.substring(k + 1, i)+"/"+expression.substring(i + 1, p);
                expression=expression.replace(oldstring,String.valueOf(sum));
                i=0;
            }
        }



        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) == '+') {

                int k;
                for (k = i - 1; k >= 0; k--) {
                    char ch = expression.charAt(k);
                    if (!(ch >= '0' && ch <= '9'|| ch=='.')) {
                        if (ch=='-'){
                            if (k-1==-1||expression.charAt(k-1)=='-'||expression.charAt(k-1)=='+'||expression.charAt(k-1)=='*'
                                    ||expression.charAt(k-1)=='/'){
                                k--;
                            }
                        }
                        break;
                    }
                }
                double number1 = Double.valueOf(expression.substring(k + 1, i));

                int p;
                for (p = i + 2; p < expression.length(); p++) {
                    char ch = expression.charAt(p);
                    if (!(ch >= '0' && ch <= '9'|| ch=='.')) {
                        break;
                    }
                }
                double number2 = Double.valueOf(expression.substring(i + 1, p));
                double sum = number1 + number2;
                String oldstring=expression.substring(k + 1, i)+"+"+expression.substring(i + 1, p);
                expression=expression.replace(oldstring,String.valueOf(sum));
                i=0;
            }
            if (expression.charAt(i) == '-') {
                if (i==0){
                    continue;
                }
                int k;
                for (k = i - 1; k >= 0; k--) {
                    char ch = expression.charAt(k);
                    if (!(ch >= '0' && ch <= '9'|| ch=='.')) {
                        if (ch=='-'){
                            if (k-1==-1||expression.charAt(k-1)=='-'||expression.charAt(k-1)=='+'||expression.charAt(k-1)=='*'
                                    ||expression.charAt(k-1)=='/'){
                                k--;
                            }
                        }
                        break;
                    }
                }
                double number1 = Double.valueOf(expression.substring(k + 1, i));

                int p;
                for (p = i + 2; p < expression.length(); p++) {
                    char ch = expression.charAt(p);
                    if (!(ch >= '0' && ch <= '9'|| ch=='.')) {
                        break;
                    }
                }
                double number2 = Double.valueOf(expression.substring(i + 1, p));
                double sum = number1 - number2;

                String oldstring=expression.substring(k + 1, i)+"-"+expression.substring(i + 1, p);
                expression=expression.replace(oldstring,String.valueOf(sum));
                i=0;
            }
        }
        return expression;
    }


    public String bracket(String str) {
        while (str.contains(")")) {
            for (int i = 0; i < str.length(); i++) {
                int temp = 0;

                if (str.charAt(i) == ')') {
                    for (temp = i - 1; temp >= 0; temp--) {
                        if (str.charAt(temp) == '(') {
                            String exp = str.substring(temp + 1, i);
                            String exp2="("+exp+")";
                            str = str.replace(exp2,account(exp));
                            break;
                        }
                    }
                    break;
                }
            }
        }
        return str;
    }

    public void check(String expression) {

        for (int i = 0; i < expression.length(); i++) {

            if (expression.charAt(i) == ')' || expression.charAt(i) == '(') {
                expression=bracket(expression);
                break;
            }

        }
        System.out.println(account(expression));

    }

}
