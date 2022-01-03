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
public interface InvLibInventory extends InventoryHolder {


    public HashMap<Player,InvLibInventory> opennedInv = new HashMap<>();

    String getDisplayname(Player p);

    int getRows(Player p);

    HashMap<Integer, Button> getButtons(Player p);

    Button getButtonToFillEmptySlots();

    Button getButton(int slot,Player p);


    public static void open(InvLibInventory creator, Player p) {
        Inventory inv = Bukkit.createInventory(p, 9 * creator.getRows(p), ChatColor.translateAlternateColorCodes('&', creator.getDisplayname(p)));
        if (creator.getButtonToFillEmptySlots() != null) {
            for (int x = 0; x < 9 * creator.getRows(p); x++) {
                inv.setItem(x, Button.getItem(creator.getButtonToFillEmptySlots(), p));
            }
        }
        if (creator.getButtons(p) != null) {
            for (int slot : creator.getButtons(p).keySet()) {
                inv.setItem(slot, Button.getItem(creator.getButtons(p).get(slot), p));
            }
        }
        p.openInventory(inv);
        opennedInv.put(p,creator);
    }


}
