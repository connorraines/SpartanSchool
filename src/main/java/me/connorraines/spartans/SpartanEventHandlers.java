package me.connorraines.spartans;

import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemHeldEvent;
import org.bukkit.inventory.ItemStack;

public class SpartanEventHandlers implements Listener{
    private GameLogic gameLogic;
    public SpartanEventHandlers(GameLogic gameLogic){
        this.gameLogic = gameLogic;
    }
    @EventHandler
    public void onEntityDamageByEntity(EntityDamageByEntityEvent e){
        LivingEntity entity = (LivingEntity) e.getEntity();
        Entity damager = e.getDamager();
        if (e.getDamage() > entity.getHealth()){

                gameLogic.handleEntityDamageByEntity((Entity) entity, damager);

        }

    }
    @EventHandler
    public void onMobDeath(EntityDeathEvent e){
        Entity deadEntity = e.getEntity();
        gameLogic.handleMobDeath(deadEntity);
    }
    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent e){
        Player player = e.getEntity();
        gameLogic.handlePlayerDeath(player);
    }
    @EventHandler
    public void onButtonPress(PlayerInteractEvent e){
        if (e.getAction() == Action.RIGHT_CLICK_BLOCK){
            Block block = e.getClickedBlock();
            gameLogic.handleButtonPress(block);
        }

    }
    @EventHandler
    public void onPlayerItemHeld(PlayerItemHeldEvent e){
        for(ItemStack item : e.getPlayer().getInventory().getContents())
        GameUtils.makeUnbrakeable(item);
    }
}
