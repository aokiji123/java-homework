package HouseBuilder;

public class Team {
    private Worker[] workers;
    private TeamLeader leader;

    public Team(Worker[] workers, TeamLeader leader) {
        this.workers = workers;
        this.leader = leader;
    }

    public void startWork(House house) {
        for (Worker worker : workers) {
            worker.work();
        }
        leader.work();
        house.report();
    }
}
