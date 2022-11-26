/* Да се напише алгоритам кој ќе пресметува (евалуира) математички израз составен од броеви и операциите за собирање (+) и множење (*).

Забелешка: Операцијата множење има предност пред операцијата собирање. */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class ExpressionEvaluator {

    public static int evaluateExpression(String expression){
        int result = 0;
        String[] temp = expression.split("[+]");

        for(int i = 0; i < temp.length; i++){
            int tempResult = 1;
            String[] temp2 = temp[i].split("[*]");
            for(int j = 0; j < temp2.length; j++){
                tempResult *= Integer.parseInt(temp2[j]);
            }
            result += tempResult;
        }
        return result;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        System.out.println(evaluateExpression(input.readLine()));
    }

}