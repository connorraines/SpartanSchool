package me.connorraines.spartans;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

public class SpartanCommandExecutor implements CommandExecutor {
    private GameLogic gameLogic;

    public SpartanCommandExecutor(GameLogic gameLogic){
        this.gameLogic = gameLogic;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (command.getName().equalsIgnoreCase("start")){

            if (sender instanceof Player p){
                gameLogic.startSpartanSchool();
            }
        }
        if (command.getName().equalsIgnoreCase("fixbug")){

            if (sender instanceof Player p){
                GameLogic.fixBug();
            }
        }
        if (command.getName().equalsIgnoreCase("buy")){

            if (sender instanceof Player p){
                gameLogic.handlePurchase(args, p);
            }
        }
        if (command.getName().equalsIgnoreCase("balance")){

            if (sender instanceof Player p){
                gameLogic.getBalance(p);
            }
        }

        return true;
    }
}
