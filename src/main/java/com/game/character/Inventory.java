package main.java.com.game.character;

import main.java.com.game.item.Item;

import java.util.ArrayList;
import java.util.List;

public class Inventory {

    private List<Item> items;

    public Inventory() {
        this.items = new ArrayList<>();
    }

    public void addItem(Item item){
        items.add(item);
    }

    public void removeItem(Item item){
        items.remove(item);
    }

    public List<Item> getItems() {
        return items;
    }

    @Override
    public String toString() {
        return "main.java.com.game.character.Inventory{" +
                "items=" + items +
                '}';
    }
}
