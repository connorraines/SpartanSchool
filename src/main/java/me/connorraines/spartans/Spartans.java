package me.connorraines.spartans;

import org.bukkit.*;
import org.bukkit.attribute.Attribute;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashSet;

public final class Spartans extends JavaPlugin{
    private GameLogic gameLogic;
    private static Spartans instance;
    @Override
    public void onEnable() {
        instance = this;
        gameLogic = new GameLogic();
        getServer().getPluginManager().registerEvents(new SpartanEventHandlers(gameLogic), this);
        getServer().getPluginManager().registerEvents(new GuiListener(), this);
        getServer().getPluginManager().registerEvents(new ShopListener(gameLogic), this);
        getCommand("start").setExecutor(new SpartanCommandExecutor(gameLogic));
        getCommand("fixbug").setExecutor(new SpartanCommandExecutor(gameLogic));
        getCommand("buy").setExecutor(new SpartanCommandExecutor(gameLogic));
        getCommand("balance").setExecutor(new SpartanCommandExecutor(gameLogic));
        getCommand("buy").setTabCompleter(new SpartanShopTabCompletion());
        getCommand("gui").setExecutor(new GuiCommand());
        getCommand("shop").setExecutor(new ShopCommand());
    }



    @Override
    public void onDisable(){
        instance = null;
    }
    public static Spartans getInstance(){
        return instance;
    }

}
