package club.skilled.libraries.invlib.menu;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Mansitoh
 * Project: InvLib Date: 02/17/2022 @ 17:20
 * Twitter: @Mansitoh_PY Github: https://github.com/Mansitoh
 * Discord: https://discord.link/Skilled
 * CEO: Skilled | Development
 */
public interface InvLibInventory {


    public HashMap<Player,InvLibInventory> opennedInv = new HashMap<>();

    String getDisplayname(Player p);

    int getRows(Player p);

    HashMap<Integer, Button> getButtons(Player p);

    Button getButtonToFillEmptySlots();

    public default Button getButton(int slot,Player p){
        if(getButtons(p).containsKey(slot)) {
            getButtons(p).get(slot);
        }
        return null;
    }


    public default void open(Player p) {
        Inventory inv = Bukkit.createInventory(p, 9 * this.getRows(p), ChatColor.translateAlternateColorCodes('&', this.getDisplayname(p)));
        if (this.getButtonToFillEmptySlots() != null) {
            for (int x = 0; x < 9 * this.getRows(p); x++) {
                inv.setItem(x, Button.getItem(this.getButtonToFillEmptySlots(), p));
            }
        }
        if (this.getButtons(p) != null) {
            for (int slot : this.getButtons(p).keySet()) {
                inv.setItem(slot, Button.getItem(this.getButtons(p).get(slot), p));
            }
        }
        p.openInventory(inv);
        opennedInv.put(p,this);
    }


}
