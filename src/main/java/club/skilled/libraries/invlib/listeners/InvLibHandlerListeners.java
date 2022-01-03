package club.skilled.libraries.invlib.listeners;

import club.skilled.libraries.invlib.events.ButtonClickEvent;
import club.skilled.libraries.invlib.events.PlayerClickInventoryEvent;
import club.skilled.libraries.invlib.menu.Button;
import club.skilled.libraries.invlib.menu.InvLibInventory;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;

/**
 * Created by Mansitoh
 * Project: InvLib Date: 02/17/2022 @ 17:21
 * Twitter: @Mansitoh_PY Github: https://github.com/Mansitoh
 * Discord: https://discord.link/Skilled
 * CEO: Skilled | Development
 */
public class InvLibHandlerListeners implements Listener {

    @EventHandler(priority =  EventPriority.HIGHEST)
    public void onClick(InventoryClickEvent e){
        Player p = (Player) e.getWhoClicked();
        if(e.getClickedInventory() == null) return;
        if(e.getClickedInventory().getItem(e.getSlot()) == null) return;
        if(e.getView().getTopInventory() == null) return;
        if(!InvLibInventory.opennedInv.containsKey(p)) return;
        int slot = e.getSlot();
        if(slot == -1) return;
        InvLibInventory inv = InvLibInventory.opennedInv.get(p);
        Button button = inv.getButton(slot,p);
        if (button == null) {
            if (inv.getButtonToFillEmptySlots() != null) {
                button = inv.getButtonToFillEmptySlots();
            }
        }
        PlayerClickInventoryEvent click = new PlayerClickInventoryEvent(p,inv,e.getAction());
        Bukkit.getServer().getPluginManager().callEvent(click);
        if(!click.isCancelled()) {
            ButtonClickEvent buttonClickEvent = new ButtonClickEvent(p, inv, button, e.getAction());
            Bukkit.getServer().getPluginManager().callEvent(buttonClickEvent);
        }
        e.setCancelled(true);

    }

    @EventHandler
    public void onClose(InventoryCloseEvent e){
        Player p = (Player) e.getPlayer();
        if(InvLibInventory.opennedInv.containsKey(p)) {
            InvLibInventory.opennedInv.remove(p);
        }
    }

    @EventHandler
    public void onButtonClick(ButtonClickEvent e){
        if(!e.isCancelled()) {
            e.getButton().execute(e);
        }
    }

}
