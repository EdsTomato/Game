package main.java.com.game.character;

import main.java.com.game.item.Item;

public class Character {
    private String name;
    private int health;
    private Inventory inventory;
    private Double encumbrance;

    public Character(String name, int InitialHealth) {
        this.name = name;
        this.inventory = new Inventory();
        this.health =  InitialHealth;
        this.encumbrance = 0.0;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }
    public String getName() {
        return name;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public int getHealth() {
        return health;
    }

    public boolean isAlive(){
        return health > 0;
    }

    public void takeDamage(int dmg){
        if (dmg < 0){
            throw new IllegalArgumentException("Dmg can not be negative");
        }
        health = health - dmg;
        if(health < 0){
            health = 0;
        }
    }

    public void heal(int amount){
        if (amount < 0) {
            throw new IllegalArgumentException("Healing amount cannot be negative");
        }
        health = health + amount;
        if(health > 100){
            health = 100;
        }
    }

    public void addItemToInventory(Item item){
        inventory.addItem(item);
        encumbrance += item.getWeight();
    }

    @Override
    public String toString() {
        return "Character{" +
                "name='" + name + '\'' +
                ", health=" + health +
                ", inventory=" + inventory +
                ", encumbrance=" + encumbrance +
                '}';
    }
}
