package me.connorraines.spartans.shop.entity;
import me.connorraines.spartans.shop.ShopEntity;
import org.bukkit.ChatColor;
import org.bukkit.DyeColor;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Wolf;

import java.util.Random;

public class FightingWolf extends ShopEntity {

    public FightingWolf() {
        super(4, EntityType.WOLF);
    }
    @Override
    public void purchase(Player player, int quantity){
        for (int i = 0; i < quantity; i++) {
            Wolf wolf = (Wolf) player.getLocation().getWorld().spawnEntity(player.getLocation(), entity);
            wolf.setAdult();
            wolf.setTamed(true);
            wolf.setOwner(player);
            wolf.setBreed(false);
            wolf.setCustomName(ChatColor.DARK_AQUA + player.getName() + "'s Wolf");
            wolf.setCustomNameVisible(true);
            wolf.setCollarColor(randomizeColor());
            wolf.setHealth(wolf.getMaxHealth());
            wolf.setCanPickupItems(false);
        }
    }
    private DyeColor randomizeColor() {
        Random random = new Random();
        int color = random.nextInt(16);

        for (int i = 0; i < 16; i++) {
            if (i == color)
                return DyeColor.getByDyeData((byte) i);
            continue;
        }
        return null;
    }
}
