import java.util.ArrayList;
import java.util.List;

import Controller.Controller;
import Controller.iGetModel;
import Controller.iGetView;
import Model.Toy;
import Model.ToysModel;
import View.ViewRus;

public class App {
    public static void main(String[] args) throws Exception {
        
        List<Toy> toysBase = new ArrayList<>();

        //adding toys to the list
        toysBase.add(new Toy(1, "Конструктор", 10, 25));
        toysBase.add(new Toy(2, "Кукла", 20, 15));
        toysBase.add(new Toy(3, "Самокат", 1, 5));
        toysBase.add(new Toy(4, "Грузовик", 15, 20));
        toysBase.add(new Toy(5, "Набор наклеек", 30, 30));

        iGetModel model = new ToysModel(toysBase, "toys.txt");
        iGetView view = new ViewRus();

        Controller control = new Controller(model, view);

        control.run();
    }
}
