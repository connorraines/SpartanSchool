package me.connorraines.spartans;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.metadata.FixedMetadataValue;

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
        return true;
    }
}
