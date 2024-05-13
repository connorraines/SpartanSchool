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

        ItemStack gappleButton = new ItemStack(Material.GOLDEN_APPLE);
        ArrayList<String> testlore = new ArrayList<>();
        testlore.add(ChatColor.YELLOW+"5¥");
        ItemMeta gappleButtonItemMeta = gappleButton.getItemMeta();
        gappleButtonItemMeta.setDisplayName(ChatColor.BOLD + "Golden Apple");
        gappleButtonItemMeta.setLore(testlore);
        gappleButton.setItemMeta(gappleButtonItemMeta);

        inventory.setItem(0, closeButton);
        inventory.setItem(11, gappleButton);
        return true;
    }
}
