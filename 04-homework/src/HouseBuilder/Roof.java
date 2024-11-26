package HouseBuilder;

public class Roof implements IPart {
    private boolean isBuilt = false;

    @Override
    public void build() {
        if (!isBuilt) {
            System.out.println("Будуємо дах...");
            isBuilt = true;
        }
    }

    @Override
    public String getName() {
        return "Дах";
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
