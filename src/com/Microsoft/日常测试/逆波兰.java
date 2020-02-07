package com.Microsoft.日常测试;

import javax.swing.*;
import java.util.Scanner;
import java.util.Stack;

/**
 * @author 熊立伟
 * @version 1.0
 * @date 2020/2/5 17:24
 */
public class 逆波兰 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String text=sc.nextLine();
//        text="1+(2-3)*4+10/5";
        text=toBehind(text);
        System.out.println(text);
        try{
            System.out.println(caculuator(text));
        }catch (Exception e){
            System.out.println("表达式错误");
            System.out.println(e);
        }

    }
    public static String toBehind(String text){
        Stack<String> number=new Stack<>();
        Stack<Character> operator=new Stack<>();
        Boolean digit=false;
        for (int i = 0; i <text.length() ; i++) {
            if(Character.isDigit(text.charAt(i))){
                if(digit){
                    number.push(number.pop()+text.charAt(i));
                }else {
                    number.push(String.valueOf(text.charAt(i)));
                    digit=true;
                }
            }else if(text.charAt(i)=='.'){
                number.push(number.pop()+".");
            }else {
                digit=false;
                if (text.charAt(i)=='('){
                    operator.push('(');
                }else if(text.charAt(i)==')'){
                    while (operator.peek()!='('){
                        number.push(String.valueOf(operator.pop()));
                    }
                    operator.pop();
                }else if(text.charAt(i)=='*'||text.charAt(i)=='/'||text.charAt(i)=='+'||text.charAt(i)=='-') {
                    if (operator.empty()){
                        operator.push(text.charAt(i));
                    }
                    else if((text.charAt(i)=='*'||text.charAt(i)=='/')&&(operator.peek()=='+'||operator.peek()=='-')){
                        operator.push(text.charAt(i));
                    }else {
                            while (!operator.empty()) {
                                if(operator.peek() == '('){
                                    operator.push(text.charAt(i));
                                    break;
                                }

                                number.push(String.valueOf(operator.pop()));
                                if (operator.empty()||(operator.peek() == '+' || operator.peek() == '-' )) {
                                    operator.push(text.charAt(i));
                                    break;
                                }
                            }
                    }
                }
            }

        }
        while (!operator.empty()){
            number.push(String.valueOf(operator.pop()));
        }
        return number.toString();
    }
    public static Double caculuator(String text)throws Exception{
        Stack<Double> stack =new Stack<>();
        StringBuffer sb=new StringBuffer();
        double a,b;
        for (int i = 0; i <text.length() ; i++) {
            Character temp=text.charAt(i);
            if(Character.isDigit(temp)||temp=='.'){
                sb.append(temp);
            }if(temp==' '){
                if (sb.length()>0){
                    stack.push(Double.valueOf(sb.toString()));
                    sb.delete(0,sb.length());
                }
            } else {
                switch (temp){
                    case '+':
                        stack.push(stack.pop()+stack.pop());
                        break;
                    case '-':
                        a=stack.pop();
                        b=stack.pop();
                        stack.push(b-a);
                        break;
                    case '*':
                        stack.push(stack.pop()*stack.pop());
                        break;
                    case '/':
                        if(stack.peek()==0){
                            System.out.println("sorry");
                            System.exit(0);
                        }
                        a=stack.pop();
                        b=stack.pop();
                        stack.push(b/a);
                        break;
                }
            }
        }
        if(stack.empty())return Double.valueOf(sb.toString());
        return stack.pop();
    }

}
