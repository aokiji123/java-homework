package HouseBuilder;

public class Window implements IPart {
    private boolean isBuilt = false;

    @Override
    public void build() {
        if (!isBuilt) {
            System.out.println("Будуємо вікна...");
            isBuilt = true;
        }
    }

    @Override
    public String getName() {
        return "Вікна";
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
