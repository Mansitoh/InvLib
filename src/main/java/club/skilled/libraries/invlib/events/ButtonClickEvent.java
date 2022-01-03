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
 * Project: InvLib Date: 03/13/2022 @ 13:36
 * Twitter: @Mansitoh_PY Github: https://github.com/Mansitoh
 * Discord: https://discord.link/Skilled
 * CEO: Skilled | Development
 */
@Getter
@Setter
public class ButtonClickEvent extends Event implements Cancellable {

    private static final HandlerList handlers = new HandlerList();
    private Player player;
    private InvLibInventory inventory;
    private Button button;
    private boolean cancelled;
    private InventoryAction action;

    public ButtonClickEvent(Player p,InvLibInventory inv,Button b,InventoryAction a) {
        this.player = p;
        this.inventory = inv;
        this.button = b;
        this.action = a;
    }

    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

}
