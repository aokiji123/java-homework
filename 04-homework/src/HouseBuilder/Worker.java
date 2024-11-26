package HouseBuilder;

public class Worker implements IWorker {
    private House house;

    public Worker(House house) {
        this.house = house;
    }

    @Override
    public void work() {
        house.buildHouse(this);
    }
}
