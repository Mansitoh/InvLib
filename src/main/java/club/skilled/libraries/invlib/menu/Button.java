package club.skilled.libraries.invlib.menu;

import club.skilled.libraries.invlib.events.ButtonClickEvent;
import club.skilled.libraries.invlib.events.PlayerClickInventoryEvent;
import club.skilled.libraries.invlib.utils.ItemCreator;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Mansitoh
 * Project: InvLib Date: 02/17/2022 @ 17:20
 * Twitter: @Mansitoh_PY Github: https://github.com/Mansitoh
 * Discord: https://discord.link/Skilled
 * CEO: Skilled | Development
 */
public interface Button {

    String getDisplayname(Player p);

    Material getMaterial(Player p);

    int getDamageValue(Player p);

    int getDataValue(Player p);

    String getOwner(Player p);

    HashMap<String, String> getReplacer(Player p);

    List<String> getLore(Player p);

    void execute(ButtonClickEvent e);


    static ItemStack getItem(Button b, Player p) {
        ItemCreator creator = new ItemCreator();
        creator.setDisplayname(b.getDisplayname(p));
        creator.setMaterial(b.getMaterial(p));
        creator.setDamageValue((byte) b.getDamageValue(p));
        creator.setDataValue((byte) b.getDataValue(p));
        creator.setOwner(b.getOwner(p));
        creator.setReplacer(b.getReplacer(p));
        creator.setLore(b.getLore(p));
        return creator.create();
    }

}
