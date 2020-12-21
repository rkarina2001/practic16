package exercise;

public abstract class MenuItem {
    private int cost;
    private String name;
    public String description;

    abstract int getCost();

    abstract String getName();

    abstract String getDescription();
}
