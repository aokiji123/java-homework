package HouseBuilder;

public class TeamLeader implements IWorker {
    public TeamLeader() {}

    @Override
    public void work() {
        System.out.println("Бригадир формує звіт про виконану роботу.");
    }
}
