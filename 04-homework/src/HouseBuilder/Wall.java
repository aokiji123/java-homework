package HouseBuilder;

public class Wall implements IPart {
    private boolean isBuilt = false;

    @Override
    public void build() {
        if (!isBuilt) {
            System.out.println("Будуємо стіни...");
            isBuilt = true;
        }
    }

    @Override
    public String getName() {
        return "Стіни";
    }

    @Override
    public boolean isBuilt() {
        return isBuilt;
    }

    @Override
    public void setBuilt(boolean built) {
        this.isBuilt = built;
    }
}
