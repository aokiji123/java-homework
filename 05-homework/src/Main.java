import SeaBoatPier.*;
import TaxInspector.*;

public class Main {
    public static void main(String[] args) {
        // 1) SeaBoatPier
        PierSimulation simulation = new PierSimulation(50);
        simulation.initializeRates();
        simulation.simulate("Morning", 30);

        // TASK 2 and 3 cannot be run at the same time! Comment one of them to check the work of the second one

        // 2) Dictionary
        Dictionary app = new Dictionary();
        app.run();

        // 3) TaxInspector
        TaxInspectorDatabase db = new TaxInspectorDatabase();
        db.run();
    }
}