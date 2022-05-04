package Calculator;

import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static int num1, num2;
    static char operation;
    static int result;

    public static char[] main(String[] args) {
        System.out.println("Введите арифметическое выражение арабскими или римскими числами от I(1) до X(10) ");
        String userInput = scanner.nextLine();
        char[] under_char = new char[10];
        for (int i = 0; i < userInput.length(); i++) {
            under_char[i] = userInput.charAt(i);
            if (under_char[i] == '+') {
                operation = '+';
            }
            if (under_char[i] == '-') {
                operation = '-';
            }
            if (under_char[i] == '*') {
                operation = '*';
            }
            if (under_char[i] == '/') {
                operation = '/';
            } else {
                System.out.println("Введен не допустимый знак операции");
            }
            return under_char;
        }



        String under_charString = String.valueOf(under_char);
        String[] blacks = under_charString.split("[+-/*]");
        String stable00 = blacks[0];
        String stable01 = blacks[1];
        String string03 = stable01.trim();
        num1 = romanToNumber(stable00);
        num2 = romanToNumber(string03);
        if (num1 < 0 && num2 < 0) {
            result = 0;
        } else {
            result = calculated(num1, num2, operation);
            System.out.println("Результат для римскиз цифр");
            String resultRoman = convertNumRoman(result);
            System.out.println(stable00 + " " + operation + " " + string03 + " = " + resultRoman);
        }
        num1 = Integer.parseInt(stable00);
        num2 = Integer.parseInt(string03);
        result = calculated(num1, num2, operation);
        System.out.println("  Результат для арабскихз чисел  ");
        System.out.println(num1 + " " + operation + " " + num2 + " = " + result);
        return under_char;
    }



    private static String convertNumRoman (int numArabian) {
        String[] roman = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"
        };
        final String s = roman[numArabian];
        return s;
    }

    private static int romanToNumber (String roman) {
        try{
            if (roman.equals("I")) {
                return 1;
            }else if(roman.equals("II")) {
                return 2;
            }else if(roman.equals("III")) {
                return 3;
            }else if(roman.equals("IV")) {
                return 4;
            }else if(roman.equals("V")) {
                return 5;
            }else if(roman.equals("VI")) {
                return 6;
            }else if(roman.equals("VII")) {
                return 7;
            }else if(roman.equals("VIII")) {
                return 8;
            }else if(roman.equals("IX")) {
                return 9;
            }else if(roman.equals("X")) {
                    return 10;
                }
            } catch (InputMismatchException e) {
                throw new InputMismatchException("Неверный формат данных");
            }
            return  -1;
        }


    public static int calculated(int number1, int number2, char op) {
        int result = 0;
        switch (op) {
            case '+':
                result = number1 + number2;
                break;
            case '-':
                result = number1 - number2;
                break;
            case '*':
                result = number1 * number2;
                break;
            case '/':
                try {
                    result = number1 / number2;
                } catch (ArithmeticException | InputMismatchException e) {
                    System.out.println("Исключение : " + e);
                    System.out.println("На 0 делить нельзя");

                    break;
                }
                break;
            default:
                throw new IllegalArgumentException("Не верный знак операции");
        }
        return result;
    }
}
