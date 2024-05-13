package me.connorraines.spartans;

import me.connorraines.spartans.shop.Buyable;
import me.connorraines.spartans.shop.ShopItem;
import me.connorraines.spartans.shop.entity.FightingWolf;
import me.connorraines.spartans.shop.entity.IronGolem;
import me.connorraines.spartans.shop.entity.Snowman;
import me.connorraines.spartans.shop.item.Arrow;
import me.connorraines.spartans.shop.item.Egapple;
import me.connorraines.spartans.shop.item.Gapple;
import me.connorraines.spartans.shop.item.Snowball;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;

public class SpartanShop {

    public static HashMap<String, Buyable> itemMap;
    static {
        itemMap = new HashMap<>();
        itemMap.put("arrow", new Arrow());
        itemMap.put("snowball", new Snowball());
        itemMap.put("gapple", new Gapple());
        itemMap.put("irongolem", new IronGolem());
        itemMap.put("egapple", new Egapple());
        itemMap.put("snowman", new Snowman());
        itemMap.put("wolf", new FightingWolf());
    }
    public static boolean purchase(Player player, String itemName, int quantity, StringBuilder error){
        if(quantity <= 0){
            error.append("Not a valid amount");
        }
        int playerPoints = Database.getInstance().get(player).points;
        Buyable item = itemMap.get(itemName.toLowerCase());
        if(item == null){
            error.append("Item is not a option");
            return false;
        }
        if (playerPoints >= item.price * quantity) {
            item.purchase(player, quantity);
            Database.getInstance().changePoints(player, item.price * quantity * -1);
            return true;
        }
        error.append("You need more ¥");
        return false;

    }

}
