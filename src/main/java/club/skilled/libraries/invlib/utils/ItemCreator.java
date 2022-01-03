package club.skilled.libraries.invlib.utils;


import lombok.Getter;
import lombok.Setter;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created by Mansitoh
 * Project: InvLib Date: 03/11/2022 @ 11:15
 * Twitter: @Mansitoh_PY Github: https://github.com/Mansitoh
 * Discord: https://discord.link/Skilled
 * CEO: Skilled | Development
 */

@Getter
@Setter
public class ItemCreator {


    public String displayname = "";
    public int amount = 1;
    public byte dataValue = 0;
    public byte damageValue = 0;
    public String owner = "Steve";
    public HashMap<String,String> replacer = new HashMap<>();
    public Material material = Material.AIR;
    public List<String> lore = new ArrayList<>();

    public ItemStack create() {
        ItemStack item = new ItemStack(getMaterial(),amount, (byte) getDamageValue(),(byte) getDataValue());
        List<String> changed = new ArrayList<>();
        for (String s : lore) {
            if (replacer != null) {
                for (String key : replacer.keySet()) {
                    s = s.replace(key, replacer.get(key));
                }
            }
            changed.add(ChatColor.translateAlternateColorCodes('&', s));
        }
        if(material.getId() != 397) {
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', displayname));
            meta.setLore(changed);
            item.setItemMeta(meta);
        }else{
            SkullMeta meta = (SkullMeta) item.getItemMeta();
            meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', displayname));
            meta.setLore(changed);
            meta.setOwner(getOwner());
            item.setItemMeta(meta);
        }
        return item;
    }

}
