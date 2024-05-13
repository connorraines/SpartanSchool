package me.connorraines.spartans;

import me.connorraines.spartans.shop.item.Gapple;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.ItemStack;

public class ShopListener implements Listener {
    private GameLogic gameLogic;
    public ShopListener(GameLogic gameLogic){
        this.gameLogic = gameLogic;
    }
    @EventHandler
    public void onClick(InventoryClickEvent event){
        Player player = (Player) event.getWhoClicked();
        if (player.hasMetadata("OpenedMenu")) {
            event.setCancelled(true);

            switch (event.getSlot()){
                case 11:
                    String[] args = {"gapple"};
                    gameLogic.handlePurchase(args, player);
                    break;
                case 0:
                    player.closeInventory();
                    break;
            }


        }
    }
    @EventHandler
    public void onClose(InventoryCloseEvent event){
        Player player = (Player) event.getPlayer();

        if (player.hasMetadata("OpenedMenu")){
            player.removeMetadata("OpenedMenu", Spartans.getInstance());
        }
    }
}
