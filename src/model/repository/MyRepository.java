package model.repository;

import model.ComplexNum;

public interface MyRepository {

    void add(ComplexNum firstNum, ComplexNum secondNum);

    void multiply(ComplexNum firstNum, ComplexNum secondNum);

    void divide(ComplexNum firstNum, ComplexNum secondNum);

    public ComplexNum[] readComplexNum();

    public String prompt(String message);

    public boolean checkComplexNum(ComplexNum[] complexNums);
}
