package HouseBuilder;

public class Door implements IPart {
    private boolean isBuilt = false;

    @Override
    public void build() {
        if (!isBuilt) {
            System.out.println("Будуємо двері...");
            isBuilt = true;
        }
    }

    @Override
    public String getName() {
        return "Двері";
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
