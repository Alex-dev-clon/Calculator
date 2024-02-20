package util;

import controller.CalculatorController;
import model.repository.MyRepository;
import model.repository.impl.CalculatorRepository;
import view.CalculatorView;

import java.io.IOException;

public class ApplicationRunner {
    private ApplicationRunner() {
    }

    public static void startApplication (){
        MyRepository repository = new CalculatorRepository();
        CalculatorController controller = new CalculatorController(repository);
        try {
            CalculatorView view = new CalculatorView(controller);
            view.run();
        } catch (IOException e){
            e.printStackTrace();
        }

    }

}
