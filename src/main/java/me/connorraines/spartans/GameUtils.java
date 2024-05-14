package me.connorraines.spartans;

import org.bukkit.*;
import org.bukkit.attribute.Attribute;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class GameUtils {

    public static void resetPlayer(Player player){
        if (player.getGameMode() == GameMode.SPECTATOR){
            player.setGameMode(GameMode.ADVENTURE);
            player.teleport(new Location(Bukkit.getWorlds().get(0),-660, 4, 136));
        }
        player.setHealth(player.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue());

    }
    public static void resetPlayersBetweenRounds() {
        World world = Bukkit.getWorlds().get(0);
        for (Player player : world.getPlayers()) {
            resetPlayer(player);
        }
    }
    public static void setupPlayer (Player player, Location playerSpawnPoint){
        player.teleport(playerSpawnPoint);
        player.getInventory().clear();
        player.setGameMode(GameMode.ADVENTURE);
        ItemStack spartanHelm = new ItemStack(Material.GLASS);
        spartanHelm.addUnsafeEnchantment(Enchantment.BINDING_CURSE, 1);
        player.getInventory().addItem(new ItemStack(Material.IRON_SWORD));
        player.getInventory().addItem(new ItemStack(Material.IRON_AXE));
        player.getInventory().addItem(new ItemStack(Material.COOKED_BEEF, 64));
        player.getInventory().setHelmet(new ItemStack(spartanHelm));
        player.getInventory().setChestplate(new ItemStack(Material.IRON_CHESTPLATE));
        player.getInventory().setLeggings(new ItemStack(Material.IRON_LEGGINGS));
        player.getInventory().setBoots(new ItemStack(Material.IRON_BOOTS));
        player.setHealth(player.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue());

    }
    public static void makeUnbrakeable(ItemStack item){
        if(item != null && item.getType() != Material.AIR){
            ItemMeta meta = item.getItemMeta();
            if (meta != null){
                meta.setUnbreakable(true);
                item.setItemMeta(meta);
            }
        }
    }



    public static void getPlayersReady(Location playerSpawnPoint){
        World world= Bukkit.getWorlds().get(0);
        for (Player player: world.getPlayers()){
            setupPlayer(player, playerSpawnPoint);
        }
    }
    public static void removeAllMobs(){

        for(Entity en : Bukkit.getWorlds().get(0).getEntities()){
            if(!(en instanceof Player)) {

                en.remove();
            }
        }
    }
    public static void checkGameOver(){
        World world= Bukkit.getWorlds().get(0);
        int playersAlive = 0;
        for (Player player: world.getPlayers()){
            if (player.getGameMode() != GameMode.SPECTATOR){
                playersAlive++;
            }
        }
        if (playersAlive == 0) {
            Bukkit.broadcastMessage(ChatColor.BOLD + "Mission Failed, We'll Get Em' Next Time");
        }else{

        }
    }
    public static void addAllPlayersToDatabase(Database db){
        World world= Bukkit.getWorlds().get(0);
        int playersAlive = 0;
        for (Player player: world.getPlayers()){
            db.create(player, 10000000);
        }
    }
    public static void levelUp(int waveCount, int protection){

        if (waveCount % 5 == 0){
            if(waveCount <= 55){

                if(waveCount == 5){
                    for (Player player: Bukkit.getWorlds().get(0).getPlayers()) {
                        player.getInventory().clear();
                        ItemStack spartanHelm = new ItemStack(Material.GLASS);
                        spartanHelm.addUnsafeEnchantment(Enchantment.BINDING_CURSE, 1);
                        spartanHelm.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
                        ItemStack spartanBoots = new ItemStack(Material.IRON_BOOTS);
                        spartanBoots.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
                        ItemStack spartanLegs = new ItemStack(Material.IRON_LEGGINGS);
                        spartanLegs.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
                        ItemStack spartanChest = new ItemStack(Material.IRON_CHESTPLATE);
                        spartanChest.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
                        ItemStack spartanSword = new ItemStack(Material.IRON_SWORD);
                        spartanSword.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 2);
                        ItemStack spartanAxe = new ItemStack(Material.IRON_AXE);
                        spartanAxe.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 2);
                        player.getInventory().addItem(spartanSword);
                        player.getInventory().addItem(spartanAxe);
                        player.getInventory().addItem(new ItemStack(Material.COOKED_BEEF, 64));
                        player.getInventory().setHelmet(spartanHelm);
                        player.getInventory().setChestplate(spartanChest);
                        player.getInventory().setLeggings(spartanLegs);
                        player.getInventory().setBoots(spartanBoots);
                        player.setHealth(player.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue());
                    }
                }
                if(waveCount == 10){
                    for (Player player: Bukkit.getWorlds().get(0).getPlayers()) {
                        player.getInventory().clear();
                        player.setGameMode(GameMode.ADVENTURE);
                        ItemStack spartanHelm = new ItemStack(Material.GLASS);
                        spartanHelm.addUnsafeEnchantment(Enchantment.BINDING_CURSE, 1);
                        player.getInventory().addItem(new ItemStack(Material.DIAMOND_SWORD));
                        player.getInventory().addItem(new ItemStack(Material.DIAMOND_AXE));
                        player.getInventory().addItem(new ItemStack(Material.COOKED_BEEF, 64));
                        player.getInventory().setHelmet(new ItemStack(spartanHelm));
                        player.getInventory().setChestplate(new ItemStack(Material.DIAMOND_CHESTPLATE));
                        player.getInventory().setLeggings(new ItemStack(Material.DIAMOND_LEGGINGS));
                        player.getInventory().setBoots(new ItemStack(Material.DIAMOND_BOOTS));
                        player.setHealth(player.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue());
                    }
                }
                if(waveCount == 15){
                    for (Player player: Bukkit.getWorlds().get(0).getPlayers()) {
                        player.getInventory().clear();
                        ItemStack spartanHelm = new ItemStack(Material.GLASS);
                        spartanHelm.addUnsafeEnchantment(Enchantment.BINDING_CURSE, 1);
                        spartanHelm.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
                        ItemStack spartanBoots = new ItemStack(Material.DIAMOND_BOOTS);
                        spartanBoots.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
                        ItemStack spartanLegs = new ItemStack(Material.DIAMOND_LEGGINGS);
                        spartanLegs.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
                        ItemStack spartanChest = new ItemStack(Material.DIAMOND_CHESTPLATE);
                        spartanChest.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
                        ItemStack spartanSword = new ItemStack(Material.DIAMOND_SWORD);
                        spartanSword.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 2);
                        ItemStack spartanAxe = new ItemStack(Material.DIAMOND_AXE);
                        spartanAxe.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 2);
                        player.getInventory().addItem(spartanSword);
                        player.getInventory().addItem(spartanAxe);
                        player.getInventory().addItem(new ItemStack(Material.COOKED_BEEF, 64));
                        player.getInventory().setHelmet(spartanHelm);
                        player.getInventory().setChestplate(spartanChest);
                        player.getInventory().setLeggings(spartanLegs);
                        player.getInventory().setBoots(spartanBoots);
                        player.setHealth(player.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue());
                    }
                }
                if(waveCount == 20){
                    for (Player player: Bukkit.getWorlds().get(0).getPlayers()) {
                        player.getInventory().clear();
                        ItemStack spartanHelm = new ItemStack(Material.GLASS);
                        spartanHelm.addUnsafeEnchantment(Enchantment.BINDING_CURSE, 1);
                        spartanHelm.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3);
                        ItemStack spartanBoots = new ItemStack(Material.DIAMOND_BOOTS);
                        spartanBoots.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3);
                        ItemStack spartanLegs = new ItemStack(Material.DIAMOND_LEGGINGS);
                        spartanLegs.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3);
                        ItemStack spartanChest = new ItemStack(Material.DIAMOND_CHESTPLATE);
                        spartanChest.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3);
                        ItemStack spartanSword = new ItemStack(Material.DIAMOND_SWORD);
                        spartanSword.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 4);
                        spartanSword.addUnsafeEnchantment(Enchantment.FIRE_ASPECT, 1);
                        ItemStack spartanAxe = new ItemStack(Material.DIAMOND_AXE);
                        spartanAxe.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 4);
                        spartanAxe.addUnsafeEnchantment(Enchantment.FIRE_ASPECT, 1);
                        ItemStack spartanBow = new ItemStack((Material.BOW));
                        spartanBow.addUnsafeEnchantment(Enchantment.ARROW_DAMAGE, 2);
                        player.getInventory().addItem(spartanSword);
                        player.getInventory().addItem(spartanAxe);
                        player.getInventory().addItem(spartanBow);
                        player.getInventory().addItem(new ItemStack(Material.GOLDEN_CARROT, 64));
                        player.getInventory().setHelmet(spartanHelm);
                        player.getInventory().setChestplate(spartanChest);
                        player.getInventory().setLeggings(spartanLegs);
                        player.getInventory().setBoots(spartanBoots);
                        player.setHealth(player.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue());
                    }
                }
                if(waveCount == 25){
                    for (Player player: Bukkit.getWorlds().get(0).getPlayers()) {
                        player.getInventory().clear();
                        ItemStack spartanHelm = new ItemStack(Material.GLASS);
                        spartanHelm.addUnsafeEnchantment(Enchantment.BINDING_CURSE, 1);
                        spartanHelm.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);
                        ItemStack spartanBoots = new ItemStack(Material.DIAMOND_BOOTS);
                        spartanBoots.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);
                        ItemStack spartanLegs = new ItemStack(Material.DIAMOND_LEGGINGS);
                        spartanLegs.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);
                        ItemStack spartanChest = new ItemStack(Material.DIAMOND_CHESTPLATE);
                        spartanChest.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);
                        ItemStack spartanSword = new ItemStack(Material.NETHERITE_SWORD);
                        spartanSword.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 5);
                        spartanSword.addUnsafeEnchantment(Enchantment.FIRE_ASPECT, 2);
                        ItemStack spartanAxe = new ItemStack(Material.NETHERITE_AXE);
                        spartanAxe.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 5);
                        spartanAxe.addUnsafeEnchantment(Enchantment.FIRE_ASPECT, 2);
                        ItemStack spartanBow = new ItemStack((Material.BOW));
                        spartanBow.addUnsafeEnchantment(Enchantment.ARROW_DAMAGE, 3);
                        player.getInventory().addItem(spartanSword);
                        player.getInventory().addItem(spartanAxe);
                        player.getInventory().addItem(spartanBow);
                        player.getInventory().addItem(new ItemStack(Material.GOLDEN_CARROT, 64));
                        player.getInventory().setHelmet(spartanHelm);
                        player.getInventory().setChestplate(spartanChest);
                        player.getInventory().setLeggings(spartanLegs);
                        player.getInventory().setBoots(spartanBoots);
                        player.setHealth(player.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue());
                    }
                }
                if(waveCount == 30){
                    for (Player player: Bukkit.getWorlds().get(0).getPlayers()) {
                        player.getInventory().clear();
                        ItemStack spartanHelm = new ItemStack(Material.GLASS);
                        spartanHelm.addUnsafeEnchantment(Enchantment.BINDING_CURSE, 1);
                        spartanHelm.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 5);
                        ItemStack spartanBoots = new ItemStack(Material.NETHERITE_BOOTS);
                        spartanBoots.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 5);
                        ItemStack spartanLegs = new ItemStack(Material.DIAMOND_LEGGINGS);
                        spartanLegs.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 5);
                        ItemStack spartanChest = new ItemStack(Material.DIAMOND_CHESTPLATE);
                        spartanChest.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 5);
                        ItemStack spartanSword = new ItemStack(Material.NETHERITE_SWORD);
                        spartanSword.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 6);
                        spartanSword.addUnsafeEnchantment(Enchantment.FIRE_ASPECT, 3);
                        ItemStack spartanAxe = new ItemStack(Material.NETHERITE_AXE);
                        spartanAxe.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 6);
                        spartanAxe.addUnsafeEnchantment(Enchantment.FIRE_ASPECT, 3);
                        ItemStack spartanBow = new ItemStack((Material.BOW));
                        spartanBow.addUnsafeEnchantment(Enchantment.ARROW_DAMAGE, 4);
                        player.getInventory().addItem(spartanSword);
                        player.getInventory().addItem(spartanAxe);
                        player.getInventory().addItem(spartanBow);
                        player.getInventory().addItem(new ItemStack(Material.GOLDEN_CARROT, 64));
                        player.getInventory().setHelmet(spartanHelm);
                        player.getInventory().setChestplate(spartanChest);
                        player.getInventory().setLeggings(spartanLegs);
                        player.getInventory().setBoots(spartanBoots);
                        player.setHealth(player.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue());
                    }
                }
                if(waveCount == 35){
                    for (Player player: Bukkit.getWorlds().get(0).getPlayers()) {
                        player.getInventory().clear();
                        ItemStack spartanHelm = new ItemStack(Material.GLASS);
                        spartanHelm.addUnsafeEnchantment(Enchantment.BINDING_CURSE, 1);
                        spartanHelm.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 6);
                        ItemStack spartanBoots = new ItemStack(Material.NETHERITE_BOOTS);
                        spartanBoots.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 6);
                        ItemStack spartanLegs = new ItemStack(Material.NETHERITE_LEGGINGS);
                        spartanLegs.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 6);
                        ItemStack spartanChest = new ItemStack(Material.DIAMOND_CHESTPLATE);
                        spartanChest.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 6);
                        ItemStack spartanSword = new ItemStack(Material.NETHERITE_SWORD);
                        spartanSword.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 7);
                        spartanSword.addUnsafeEnchantment(Enchantment.FIRE_ASPECT, 4);
                        ItemStack spartanAxe = new ItemStack(Material.NETHERITE_AXE);
                        spartanAxe.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 7);
                        spartanAxe.addUnsafeEnchantment(Enchantment.FIRE_ASPECT, 4);
                        ItemStack spartanBow = new ItemStack((Material.BOW));
                        spartanBow.addUnsafeEnchantment(Enchantment.ARROW_DAMAGE, 5);
                        player.getInventory().addItem(spartanSword);
                        player.getInventory().addItem(spartanAxe);
                        player.getInventory().addItem(spartanBow);
                        player.getInventory().addItem(new ItemStack(Material.GOLDEN_CARROT, 64));
                        player.getInventory().setHelmet(spartanHelm);
                        player.getInventory().setChestplate(spartanChest);
                        player.getInventory().setLeggings(spartanLegs);
                        player.getInventory().setBoots(spartanBoots);
                        player.setHealth(player.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue());
                    }
                }
                if(waveCount == 40){
                    for (Player player: Bukkit.getWorlds().get(0).getPlayers()) {
                        player.getInventory().clear();
                        ItemStack spartanHelm = new ItemStack(Material.GLASS);
                        spartanHelm.addUnsafeEnchantment(Enchantment.BINDING_CURSE, 1);
                        spartanHelm.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 7);
                        ItemStack spartanBoots = new ItemStack(Material.NETHERITE_BOOTS);
                        spartanBoots.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 7);
                        ItemStack spartanLegs = new ItemStack(Material.NETHERITE_LEGGINGS);
                        spartanLegs.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 7);
                        ItemStack spartanChest = new ItemStack(Material.NETHERITE_CHESTPLATE);
                        spartanChest.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 7);
                        ItemStack spartanSword = new ItemStack(Material.NETHERITE_SWORD);
                        spartanSword.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 8);
                        spartanSword.addUnsafeEnchantment(Enchantment.FIRE_ASPECT, 5);
                        ItemStack spartanAxe = new ItemStack(Material.NETHERITE_AXE);
                        spartanAxe.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 8);
                        spartanAxe.addUnsafeEnchantment(Enchantment.FIRE_ASPECT, 5);
                        ItemStack spartanBow = new ItemStack((Material.BOW));
                        spartanBow.addUnsafeEnchantment(Enchantment.ARROW_DAMAGE, 6);
                        player.getInventory().addItem(spartanSword);
                        player.getInventory().addItem(spartanAxe);
                        player.getInventory().addItem(spartanBow);
                        player.getInventory().addItem(new ItemStack(Material.GOLDEN_CARROT, 64));
                        player.getInventory().setHelmet(spartanHelm);
                        player.getInventory().setChestplate(spartanChest);
                        player.getInventory().setLeggings(spartanLegs);
                        player.getInventory().setBoots(spartanBoots);
                        player.setHealth(player.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue());
                    }
                }
                if(waveCount == 45){
                    for (Player player: Bukkit.getWorlds().get(0).getPlayers()) {
                        player.getInventory().clear();
                        ItemStack spartanHelm = new ItemStack(Material.GLASS);
                        spartanHelm.addUnsafeEnchantment(Enchantment.BINDING_CURSE, 1);
                        spartanHelm.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 8);
                        ItemStack spartanBoots = new ItemStack(Material.NETHERITE_BOOTS);
                        spartanBoots.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 8);
                        ItemStack spartanLegs = new ItemStack(Material.NETHERITE_LEGGINGS);
                        spartanLegs.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 8);
                        ItemStack spartanChest = new ItemStack(Material.NETHERITE_CHESTPLATE);
                        spartanChest.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 8);
                        ItemStack spartanSword = new ItemStack(Material.NETHERITE_SWORD);
                        spartanSword.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 9);
                        spartanSword.addUnsafeEnchantment(Enchantment.FIRE_ASPECT, 6);
                        ItemStack spartanAxe = new ItemStack(Material.NETHERITE_AXE);
                        spartanAxe.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 9);
                        spartanAxe.addUnsafeEnchantment(Enchantment.FIRE_ASPECT, 6);
                        ItemStack spartanBow = new ItemStack((Material.BOW));
                        spartanBow.addUnsafeEnchantment(Enchantment.ARROW_DAMAGE, 7);
                        player.getInventory().addItem(spartanSword);
                        player.getInventory().addItem(spartanAxe);
                        player.getInventory().addItem(spartanBow);
                        player.getInventory().addItem(new ItemStack(Material.GOLDEN_CARROT, 64));
                        player.getInventory().setHelmet(spartanHelm);
                        player.getInventory().setChestplate(spartanChest);
                        player.getInventory().setLeggings(spartanLegs);
                        player.getInventory().setBoots(spartanBoots);
                        player.setHealth(player.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue());
                    }
                }
                if(waveCount == 50){
                    for (Player player: Bukkit.getWorlds().get(0).getPlayers()) {
                        player.getInventory().clear();
                        ItemStack spartanHelm = new ItemStack(Material.GLASS);
                        spartanHelm.addUnsafeEnchantment(Enchantment.BINDING_CURSE, 1);
                        spartanHelm.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 9);
                        spartanHelm.addUnsafeEnchantment(Enchantment.PROTECTION_FIRE, 1);
                        ItemStack spartanBoots = new ItemStack(Material.NETHERITE_BOOTS);
                        spartanBoots.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 9);
                        spartanBoots.addUnsafeEnchantment(Enchantment.PROTECTION_FIRE, 1);
                        ItemStack spartanLegs = new ItemStack(Material.NETHERITE_LEGGINGS);
                        spartanLegs.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 9);
                        spartanLegs.addUnsafeEnchantment(Enchantment.PROTECTION_FIRE, 9);
                        ItemStack spartanChest = new ItemStack(Material.NETHERITE_CHESTPLATE);
                        spartanChest.addUnsafeEnchantment(Enchantment.PROTECTION_FIRE, 9);
                        spartanChest.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 9);
                        ItemStack spartanShield = new ItemStack(Material.SHIELD);
                        ItemStack spartanSword = new ItemStack(Material.NETHERITE_SWORD);
                        spartanSword.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 10);
                        spartanSword.addUnsafeEnchantment(Enchantment.FIRE_ASPECT, 7);
                        ItemStack spartanAxe = new ItemStack(Material.NETHERITE_AXE);
                        spartanAxe.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 10);
                        spartanAxe.addUnsafeEnchantment(Enchantment.FIRE_ASPECT, 7);
                        ItemStack spartanBow = new ItemStack((Material.BOW));
                        spartanBow.addUnsafeEnchantment(Enchantment.ARROW_DAMAGE, 8);
                        player.getInventory().addItem(spartanShield);
                        player.getInventory().addItem(spartanSword);
                        player.getInventory().addItem(spartanAxe);
                        player.getInventory().addItem(spartanBow);
                        player.getInventory().addItem(new ItemStack(Material.GOLDEN_CARROT, 64));
                        player.getInventory().setHelmet(spartanHelm);
                        player.getInventory().setChestplate(spartanChest);
                        player.getInventory().setLeggings(spartanLegs);
                        player.getInventory().setBoots(spartanBoots);
                        player.setHealth(player.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue());
                    }
                }
                if(waveCount == 55) {
                    for (Player player : Bukkit.getWorlds().get(0).getPlayers()) {
                        player.getInventory().clear();
                        ItemStack spartanHelm = new ItemStack(Material.GLASS);
                        spartanHelm.addUnsafeEnchantment(Enchantment.BINDING_CURSE, 1);
                        spartanHelm.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 10);
                        spartanHelm.addUnsafeEnchantment(Enchantment.PROTECTION_FIRE, 2);
                        ItemStack spartanBoots = new ItemStack(Material.NETHERITE_BOOTS);
                        spartanBoots.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 10);
                        spartanBoots.addUnsafeEnchantment(Enchantment.PROTECTION_FIRE, 2);
                        ItemStack spartanLegs = new ItemStack(Material.NETHERITE_LEGGINGS);
                        spartanLegs.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 10);
                        spartanLegs.addUnsafeEnchantment(Enchantment.PROTECTION_FIRE, 2);
                        ItemStack spartanChest = new ItemStack(Material.NETHERITE_CHESTPLATE);
                        spartanChest.addUnsafeEnchantment(Enchantment.PROTECTION_FIRE, 2);
                        spartanChest.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 10);
                        ItemStack spartanShield = new ItemStack(Material.SHIELD);
                        spartanShield.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 3);
                        ItemStack spartanSword = new ItemStack(Material.NETHERITE_SWORD);
                        spartanSword.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 11);
                        spartanSword.addUnsafeEnchantment(Enchantment.FIRE_ASPECT, 8);
                        ItemStack spartanAxe = new ItemStack(Material.NETHERITE_AXE);
                        spartanAxe.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 11);
                        spartanAxe.addUnsafeEnchantment(Enchantment.FIRE_ASPECT, 8);
                        ItemStack spartanBow = new ItemStack((Material.BOW));
                        spartanBow.addUnsafeEnchantment(Enchantment.ARROW_DAMAGE, 9);
                        player.getInventory().addItem(spartanShield);
                        player.getInventory().addItem(spartanSword);
                        player.getInventory().addItem(spartanAxe);
                        player.getInventory().addItem(spartanBow);
                        player.getInventory().addItem(new ItemStack(Material.GOLDEN_CARROT, 64));
                        player.getInventory().setHelmet(spartanHelm);
                        player.getInventory().setChestplate(spartanChest);
                        player.getInventory().setLeggings(spartanLegs);
                        player.getInventory().setBoots(spartanBoots);
                        player.setHealth(player.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue());
                    }
                }
            }else{
                for (Player player : Bukkit.getWorlds().get(0).getPlayers()) {
                    player.getInventory().clear();
                    ItemStack spartanHelm = new ItemStack(Material.GLASS);
                    spartanHelm.addUnsafeEnchantment(Enchantment.BINDING_CURSE, 1);
                    spartanHelm.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 10 + protection);
                    spartanHelm.addUnsafeEnchantment(Enchantment.PROTECTION_FIRE, 2 + protection);
                    ItemStack spartanBoots = new ItemStack(Material.NETHERITE_BOOTS);
                    spartanBoots.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 10 + protection);
                    spartanBoots.addUnsafeEnchantment(Enchantment.PROTECTION_FIRE, 2 + protection);
                    ItemStack spartanLegs = new ItemStack(Material.NETHERITE_LEGGINGS);
                    spartanLegs.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 10 + protection);
                    spartanLegs.addUnsafeEnchantment(Enchantment.PROTECTION_FIRE, 2 + protection);
                    ItemStack spartanChest = new ItemStack(Material.NETHERITE_CHESTPLATE);
                    spartanChest.addUnsafeEnchantment(Enchantment.PROTECTION_FIRE, 2 + protection);
                    spartanChest.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 10 + protection);
                    ItemStack spartanShield = new ItemStack(Material.SHIELD);
                    spartanShield.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 3 + protection);
                    ItemStack spartanSword = new ItemStack(Material.NETHERITE_SWORD);
                    spartanSword.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 11 + protection);
                    spartanSword.addUnsafeEnchantment(Enchantment.FIRE_ASPECT, 8 + protection);
                    ItemStack spartanAxe = new ItemStack(Material.NETHERITE_AXE);
                    spartanAxe.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 11 + protection);
                    spartanAxe.addUnsafeEnchantment(Enchantment.FIRE_ASPECT, 8 + protection);
                    ItemStack spartanBow = new ItemStack((Material.BOW));
                    spartanBow.addUnsafeEnchantment(Enchantment.ARROW_DAMAGE, 9 + protection);
                    player.getInventory().addItem(spartanShield);
                    player.getInventory().addItem(spartanSword);
                    player.getInventory().addItem(spartanAxe);
                    player.getInventory().addItem(spartanBow);
                    player.getInventory().addItem(new ItemStack(Material.GOLDEN_CARROT, 64));
                    player.getInventory().setHelmet(spartanHelm);
                    player.getInventory().setChestplate(spartanChest);
                    player.getInventory().setLeggings(spartanLegs);
                    player.getInventory().setBoots(spartanBoots);
                    player.setHealth(player.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue());

                }
            }
        }
        return;
    }
}
