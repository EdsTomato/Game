package main.java.com.game.item;

public class Item {
    private String name;
    private Double weight;


    public Item(String name, Double weight) {
        this.name = name;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public Double getWeight() {
        return weight;
    }


    @Override
    public String toString() {
        return "main.java.com.game.item.Item{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                '}';
    }
}
