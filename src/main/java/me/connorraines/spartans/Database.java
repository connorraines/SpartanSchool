package me.connorraines.spartans;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import java.util.HashMap;

public class Database {
    private HashMap<String, PlayerData> database;
    private static Database instance;


    public Database(){
        database = new HashMap<>();

    }
    public void create(Player player, int points){
        PlayerData newPlayerData = new PlayerData(player, points);
        database.put(player.getDisplayName(), newPlayerData);
    }
    public PlayerData get(Player player){
        return database.get(player.getDisplayName());
    }

    public void update(Player player, PlayerData newData){
        database.replace(player.getDisplayName(), newData);

    }
    public void delete(Player player){
        database.remove(player.getDisplayName());
    }

    public boolean changePoints(Player player, int points){
        PlayerData playerData = this.get(player);
        Bukkit.broadcastMessage(ChatColor.BOLD + player.getDisplayName() + ChatColor.DARK_AQUA + " has done something to change their ¥ by " + points);
        if (playerData != null && playerData.points + points > -1){
            playerData.points += points;
            return true;
        }
        return false;
    }
    public static Database getInstance(){
        if (instance == null){
            instance = new Database();
        }
        return instance;
    }



}
