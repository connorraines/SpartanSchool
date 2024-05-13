package me.connorraines.spartans;

import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;

import java.util.HashSet;

public class GameLogic {
    public Database database = Database.getInstance();
    public Location playerSpawnPoint;
    public Location enemySpawnPoint;
    public int enemyCount;
    public int waveCount;

    public int protection;



    HashSet<EntityType> hostileMobs = new HashSet<>(){{
        add(EntityType.ZOMBIE);
        add(EntityType.SKELETON);
        add(EntityType.SLIME);
        add(EntityType.SPIDER);
        add(EntityType.WITCH);
        add(EntityType.HUSK);
        add(EntityType.STRAY);
        add(EntityType.MAGMA_CUBE);
        add(EntityType.CAVE_SPIDER);
        add(EntityType.WITHER_SKELETON);

    }};
    public void GameLogic(){

     }
    public void startSpartanSchool(){
        protection = 1;
        enemyCount = 0;
        waveCount = 1;
        GameUtils.removeAllMobs();
        World world= Bukkit.getWorlds().get(0);
        world.setTime(18000);
        world.setGameRule(GameRule.DO_DAYLIGHT_CYCLE, false);
        world.setGameRule(GameRule.KEEP_INVENTORY, true);
        enemySpawnPoint = new Location(world,-707, 6, 136);
        playerSpawnPoint = new Location(world,-660, 4, 136);
        GameUtils.getPlayersReady(playerSpawnPoint);
        spawnWave();
        GameUtils.addAllPlayersToDatabase(database);
    }
    public void spawnWave(){
        spawnMobs(1);
        for(int i = 2; i <= waveCount; i++){
            final int index = i;
            Bukkit.getScheduler().runTaskLater(Spartans.getInstance(), new Runnable() {
                @Override
                public void run() {
                    spawnMobs(index);
                }
            }, 5L * i);


        }
        waveCount++;
    }
    private void spawnMobs(int i){
        World world= Bukkit.getWorlds().get(0);
        world.spawnEntity(enemySpawnPoint, EntityType.ZOMBIE);
        enemyCount++;
        System.out.println(i);
        if (i > 4) {
            world.spawnEntity(enemySpawnPoint, EntityType.SKELETON);
            enemyCount++;
        }
        if (i > 9){
            world.spawnEntity(enemySpawnPoint, EntityType.SLIME);
            enemyCount++;
        }
        if (i > 14){
            world.spawnEntity(enemySpawnPoint, EntityType.SPIDER);
            enemyCount++;
        }
        if (i > 19){
            world.spawnEntity(enemySpawnPoint, EntityType.WITCH);
            enemyCount++;
        }
        if (i > 24){
            world.spawnEntity(enemySpawnPoint, EntityType.HUSK);
            enemyCount++;
        }
        if (i > 29){
            world.spawnEntity(enemySpawnPoint, EntityType.STRAY);
            enemyCount++;
        }
        if (i > 34){
            world.spawnEntity(enemySpawnPoint, EntityType.MAGMA_CUBE);
            enemyCount++;
        }
        if (i > 39){
            world.spawnEntity(enemySpawnPoint, EntityType.CAVE_SPIDER);
            enemyCount++;
        }
        if (i > 44){
            world.spawnEntity(enemySpawnPoint, EntityType.WITHER_SKELETON);
            enemyCount++;
        }
    }

    public void handleEntityDamageByEntity(Entity entity, Entity damager){

        Bukkit.broadcastMessage(ChatColor.RED + entity.getName() + " has died");

        if (hostileMobs.contains(entity.getType())) {
            if (enemyCount != 0) {
                if (damager.getType() != EntityType.PLAYER)
                    return;
                database.changePoints((Player)damager, 1);
            }

        }
        if (entity.getType() == EntityType.PIG){
            enemyCount = 0;
            Bukkit.broadcastMessage(ChatColor.DARK_BLUE + "Wave " + (waveCount - 1) + " beaten, Press button to begin next wave");
            GameUtils.resetPlayersBetweenRounds();
            GameUtils.levelUp(waveCount, protection);
            if (protection % 5 == 0 && protection > 55){
                protection++;
            }

        }

    }
    public void handleMobDeath(Entity entity){
        if (hostileMobs.contains(entity.getType())) {
            enemyCount--;
            if (enemyCount == 0) {
                Bukkit.broadcastMessage(ChatColor.DARK_BLUE + "Wave " + (waveCount - 1) + " beaten, Press button to begin next wave");
                GameUtils.resetPlayersBetweenRounds();
                GameUtils.levelUp(waveCount, protection);
                if (protection % 5 == 0 && protection > 55){
                    protection++;
                }

            }

        }
    }

    public void handlePlayerDeath(Player player){
        player.setGameMode(GameMode.SPECTATOR);
        GameUtils.checkGameOver();


    }
    public void handleButtonPress(Block block){
        if (block.getType() == Material.POLISHED_BLACKSTONE_BUTTON){
            if (enemyCount <= 0){
                spawnWave();
                Bukkit.broadcastMessage(ChatColor.BOLD + "Button Pressed, Starting next wave");
            }else{
                Bukkit.broadcastMessage(ChatColor.BOLD + "Remove all enemies to begin next wave");
            }
        }

    }
    public static void fixBug(){
        Bukkit.getWorlds().get(0).spawnEntity(new Location(Bukkit.getWorlds().get(0),-707, 6, 136), EntityType.PIG);
        Bukkit.broadcastMessage(ChatColor.GOLD + "Bug fixed, Kill the pig");
    }
    public void handlePurchase(String[] args, Player p){
        if (args.length == 0){
            p.sendMessage(ChatColor.RED + "What item?");
            return;
        }
        int amount = 1;

        if (args.length == 2){
            amount = Integer.parseInt(args[1]);
        }
        StringBuilder error = new StringBuilder();
        if (SpartanShop.purchase(p, args[0], amount, error)){
            Bukkit.broadcastMessage(ChatColor.GREEN + "Transaction Secuessfull");
        }else {
            Bukkit.broadcastMessage(ChatColor.RED + "Transaction Failed, Reason: " + error.toString());
        }
    }
    public void getBalance(Player p){
        p.sendMessage("you have " + database.get(p).points + "¥");
    }
}
