package me.connorraines.spartans.shop;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;



public class ShopEntity extends Buyable{
    public EntityType entity;

    public ShopEntity(int price, EntityType entity){
        super(price);
        this.entity = entity;
    }
    public void purchase(Player player, int quantity){
        for (int i = 0; i < quantity; i++) {
            player.getLocation().getWorld().spawnEntity(player.getLocation(), entity);
        }
    }
}
