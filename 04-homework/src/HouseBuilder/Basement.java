package HouseBuilder;

public class Basement implements IPart {
    private boolean isBuilt = false;

    @Override
    public void build() {
        if (!isBuilt) {
            System.out.println("Будуємо фундамент...");
            isBuilt = true;
        }
    }

    @Override
    public String getName() {
        return "Фундамент";
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

