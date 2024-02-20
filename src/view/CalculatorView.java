package view;

import controller.CalculatorController;
import model.ComplexNum;
import model.repository.impl.LogOpenListener;
import util.Commands;

import java.io.IOException;
import java.util.Arrays;

public class CalculatorView {
    private final CalculatorController calculatorController;
    private final LogOpenListener listener;

    public CalculatorView(CalculatorController userController) throws IOException {
        this.calculatorController = userController;
        this.listener = new LogOpenListener();
    }

    public void run() throws IOException {
        listener.update("Start application");
        String command;
        Commands com;
        ComplexNum[] complexNums = new ComplexNum[2];
        System.out.println("List of commands: " + Arrays.toString(Commands.values()));
        while (true) {
            command = calculatorController.prompt("Enter the command: ").toUpperCase();
            if (!checkCommand(command)) {
                listener.update("Entered the wrong command");
                System.out.println("Wrong command");
                com = Commands.SKIP;
            } else {
                listener.update("Entered " + command + " command");
                com = Commands.valueOf(command);
                if (com == Commands.EXIT) {
                    listener.update("Exit from application");
                    return;
                }
                if (com == Commands.SKIP) continue;
                complexNums = calculatorController.readComplexNum();
                listener.update("Entered complex numbers");
                if (!calculatorController.checkComplexNum(complexNums)) {
                    listener.update("Entered wrong complex numbers");
                    continue;
                }
            }
            switch (com) {
                case SKIP:
                    listener.update("Skip step");
                    continue;
                case ADD:
                    listener.update("Addition of complex numbers");
                    calculatorController.add(complexNums[0], complexNums[1]);
                    break;
                case MULT:
                    listener.update("Multiplication of complex numbers");
                    calculatorController.multiply(complexNums[0], complexNums[1]);
                    break;
                case DIV:
                    listener.update("Division of complex numbers");
                    calculatorController.divide(complexNums[0], complexNums[1]);
                    break;
            }
        }
    }

    /*
    Проверка валидности принятой команды
     */
    private boolean checkCommand(String command) {
        Commands[] commands = Commands.values();
        for (Commands com : commands) {
            if (command.equals(com.toString())) return true;
        }
        return false;
    }
}

