package club.skilled.libraries.invlib.example;

import club.skilled.libraries.invlib.InvLib;
import club.skilled.libraries.invlib.menu.InvLibInventory;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by Mansitoh
 * Project: InvLib Date: 02/17/2022 @ 17:23
 * Twitter: @Mansitoh_PY Github: https://github.com/Mansitoh
 * Discord: https://discord.link/Skilled
 * CEO: Skilled | Development
 */
public class InvLibExample extends JavaPlugin {

    InvLib invLib;

    @Override
    public void onEnable() {
        invLib = new InvLib(this);
        for(Player p : Bukkit.getServer().getOnlinePlayers()){
            InvLibInventory inv = InvLibExampleInventorys.EXAMPLE_INVENTORY;
            inv.open(p);
        }
    }

}
