package HouseBuilder;

public interface IPart {
    void build();
    String getName();
    boolean isBuilt();
    void setBuilt(boolean built);
}