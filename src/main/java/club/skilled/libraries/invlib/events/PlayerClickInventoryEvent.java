package club.skilled.libraries.invlib.events;

import club.skilled.libraries.invlib.menu.Button;
import club.skilled.libraries.invlib.menu.InvLibInventory;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.event.inventory.InventoryAction;

/**
 * Created by Mansitoh
 * Project: InvLib Date: 02/17/2022 @ 17:25
 * Twitter: @Mansitoh_PY Github: https://github.com/Mansitoh
 * Discord: https://discord.link/Skilled
 * CEO: Skilled | Development
 */
@Getter
@Setter
public class PlayerClickInventoryEvent extends Event implements Cancellable {

    private static final HandlerList handlers = new HandlerList();
    private Player player;
    private InvLibInventory inventory;
    private boolean cancelled;
    private InventoryAction action;

    public PlayerClickInventoryEvent(Player p,InvLibInventory inv,InventoryAction a) {
        this.player = p;
        this.inventory = inv;
        this.action = a;
    }

    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

}
