package me.connorraines.spartans.shop;

import org.bukkit.entity.Player;

public class Buyable {
    public int price;

    public Buyable(int price){
        this.price = price;

    }

    public abstract void purchase(Player player, int quantity);
}
