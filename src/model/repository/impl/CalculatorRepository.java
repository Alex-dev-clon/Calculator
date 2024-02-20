package model.repository.impl;

import model.ComplexNum;
import model.repository.MyRepository;

import java.util.Scanner;

public class CalculatorRepository implements MyRepository {

    /*
    Сложение двух комплексных чисел
     */
    @Override
    public void add(ComplexNum firstNum, ComplexNum secondNum) {
        double real = firstNum.getRealNum() + secondNum.getRealNum();
        double imaginary = firstNum.getImaginaryNum() + secondNum.getImaginaryNum();
        ComplexNum result = new ComplexNum(real, imaginary);
        System.out.println(firstNum + " + " + secondNum + " = " + result);
    }

    /*
    Умножение двух комплексных чисел
     */
    @Override
    public void multiply(ComplexNum firstNum, ComplexNum secondNum) {
        double real = firstNum.getRealNum() * secondNum.getRealNum() - firstNum.getImaginaryNum() * secondNum.getImaginaryNum();
        double imaginary = firstNum.getImaginaryNum() * secondNum.getRealNum() + firstNum.getRealNum() * secondNum.getImaginaryNum();
        ComplexNum result = new ComplexNum(real, imaginary);
        System.out.println(firstNum + " * " + secondNum + " = " + result);
    }

    /*
    Деление двух комплексных чисел
     */
    @Override
    public void divide(ComplexNum firstNum, ComplexNum secondNum) {
        double tempReal, tempImag;
        double resReal, resImag;

        if (Math.abs(secondNum.getRealNum()) >= Math.abs(secondNum.getImaginaryNum())) {
            tempReal = secondNum.getImaginaryNum() / secondNum.getRealNum();
            tempImag = secondNum.getRealNum() + tempReal * secondNum.getImaginaryNum();
            resReal = (firstNum.getRealNum() + tempReal * firstNum.getImaginaryNum()) / tempImag;
            resImag = (firstNum.getImaginaryNum() - tempReal * firstNum.getRealNum()) / tempImag;
        } else {
            tempReal = secondNum.getRealNum() / secondNum.getImaginaryNum();
            tempImag = secondNum.getImaginaryNum() + tempReal * secondNum.getRealNum();
            resReal = (tempReal * firstNum.getRealNum() + firstNum.getImaginaryNum()) / tempImag;
            resImag = (tempReal * firstNum.getImaginaryNum() - firstNum.getRealNum()) / tempImag;
        }
        ComplexNum result = new ComplexNum(resReal, resImag);
        System.out.println(firstNum + " / " + secondNum + " = " + result);
    }

    /*
    Получение двух комплексных чисел в массиве
     */
    @Override
    public ComplexNum[] readComplexNum() {
        ComplexNum[] complexNums = new ComplexNum[2];
        String firstNum = prompt("Enter the first Complex number: ");
        String secondNum = prompt("Enter the second Complex number: ");
        complexNums[0] = determineComplexNum(firstNum.toLowerCase());
        complexNums[1] = determineComplexNum(secondNum.toLowerCase());
        return complexNums;
    }

    /*
    Получение комплексного числа из строки
     */
    private ComplexNum determineComplexNum(String num) {
        try {
            String i, r;
            num = num.replace(" ", "");
            int index;
            index = num.lastIndexOf("-");
            if (index == -1 || index == 0) index = num.lastIndexOf("+");
            if (index == -1 || index == 0) index = num.lastIndexOf("*");
            if (index == -1 || index == 0) index = num.lastIndexOf("/");
            r = num.substring(0, index);
            if (num.charAt(index + 1) == 'i' && num.charAt(index) == '-') i = "-1";
            else if (num.charAt(index + 1) == 'i' && num.charAt(index) == '+') i = "1";
            else i = num.substring(index, num.length() - 1);
            double imaginary = Double.parseDouble(i);
            double real = Double.parseDouble(r);
            return new ComplexNum(real, imaginary);
        } catch (Exception e) {
            return null;
        }
    }

    /*
    Считывание с консоли
     */
    @Override
    public String prompt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return in.nextLine();
    }

    /*
    Проверка валидности комплексных чисел
     */
    @Override
    public boolean checkComplexNum(ComplexNum[] complexNums) {
        boolean check = true;
        if (complexNums[0] == null) {
            System.out.println("Wrong first number");
            check = false;
        }
        if (complexNums[1] == null) {
            System.out.println("Wrong second number");
            check = false;
        }
        return check;
    }


}
