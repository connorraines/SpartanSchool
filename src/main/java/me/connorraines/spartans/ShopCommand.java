package me.connorraines.spartans;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.metadata.FixedMetadataValue;

import java.util.ArrayList;

public class ShopCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("no");
            return true;
        }
        Player player = (Player) sender;

        Inventory inventory = Bukkit.createInventory(player, 9*6, ChatColor.DARK_BLUE + "Spartan Shop");
        player.openInventory(inventory);
        player.setMetadata("OpenedMenu", new FixedMetadataValue(Spartans.getInstance(), inventory));

        ItemStack closeButton = new ItemStack(Material.BARRIER);
        ItemMeta closeButtonItemMeta = closeButton.getItemMeta();
        closeButtonItemMeta.setDisplayName(ChatColor.RED + "Close Shop");
        closeButton.setItemMeta(closeButtonItemMeta);



        inventory.setItem(8, closeButton);
        inventory.setItem(2+(9*1), itemFactory(Material.GOLDEN_APPLE, "Golden Apple", "5¥"));
        inventory.setItem(3+(9*1), itemFactory(Material.ENCHANTED_GOLDEN_APPLE, "Enchanted Golden Apple", "20¥"));
        inventory.setItem(4+(9*1), itemFactory(Material.ARROW, "Arrow", "3¥"));
        inventory.setItem(14, itemFactory(Material.SNOWBALL, "Snowball", "1¥"));
        inventory.setItem(0+(9*1), itemFactory(Material.CHEST, "Items", ""));

        inventory.setItem(0+(9*2), itemFactory(Material.SPAWNER, "Mobs", ""));
        inventory.setItem(2+(9*2), itemFactory(Material.WOLF_SPAWN_EGG, "Wolf", "4¥"));
        inventory.setItem(3+(9*2), itemFactory(Material.CARVED_PUMPKIN, "Snowman", "2¥"));
        inventory.setItem(4+(9*2), itemFactory(Material.IRON_BLOCK, "Iron Golem", "10¥"));
        return true;
    }

    private ItemStack itemFactory(Material material, String displayName, String lore){
        ItemStack itemButton = new ItemStack(material);
        ArrayList<String> testlore = new ArrayList<>();
        testlore.add(ChatColor.YELLOW+ lore);
        ItemMeta ButtonItemMeta = itemButton.getItemMeta();
        ButtonItemMeta.setDisplayName(ChatColor.BOLD + displayName);
        ButtonItemMeta.setLore(testlore);
        itemButton.setItemMeta(ButtonItemMeta);

        return itemButton;
    }
}
