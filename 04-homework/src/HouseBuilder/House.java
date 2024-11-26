package HouseBuilder;

public class House {
    private Basement basement;
    private Wall[] walls;
    private Door door;
    private Window[] windows;
    private Roof roof;

    public House() {
        this.basement = new Basement();
        this.walls = new Wall[4];
        for (int i = 0; i < walls.length; i++) {
            walls[i] = new Wall();
        }
        this.door = new Door();
        this.windows = new Window[4];
        for (int i = 0; i < windows.length; i++) {
            windows[i] = new Window();
        }
        this.roof = new Roof();
    }

    public void buildHouse(Worker worker) {
        buildPart(basement);
        buildPart(walls[0]);
        buildPart(walls[1]);
        buildPart(walls[2]);
        buildPart(walls[3]);
        buildPart(door);
        buildPart(windows[0]);
        buildPart(windows[1]);
        buildPart(windows[2]);
        buildPart(windows[3]);
        buildPart(roof);
    }

    private void buildPart(IPart part) {
        if (!part.isBuilt()) {
            part.build();
            part.setBuilt(true);
        }
    }

    public void report() {
        System.out.println("Будівництво завершено!");
    }
}
