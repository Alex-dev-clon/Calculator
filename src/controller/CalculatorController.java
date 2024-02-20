package controller;

import model.ComplexNum;
import model.repository.MyRepository;

public class CalculatorController {
    private final MyRepository repository;

    public CalculatorController(MyRepository repository) {
        this.repository = repository;
    }

    public void add(ComplexNum firstNum, ComplexNum secondNum) {
        repository.add(firstNum, secondNum);
    }

    public void multiply(ComplexNum firstNum, ComplexNum secondNum) {
        repository.multiply(firstNum, secondNum);
    }

    public void divide(ComplexNum firstNum, ComplexNum secondNum) {
        repository.divide(firstNum, secondNum);
    }

    public ComplexNum[] readComplexNum() {
        return repository.readComplexNum();
    }

    public String prompt(String message) {
        return repository.prompt(message);
    }

    public boolean checkComplexNum(ComplexNum[] complexNums) {
        return repository.checkComplexNum(complexNums);
    }
}
